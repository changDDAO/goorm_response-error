package com.changddao.goorm_response_error.controller;

import com.changddao.goorm_response_error.dto.*;
import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.handleexception.CustomFindAllException;
import com.changddao.goorm_response_error.handleexception.CustomStatusCode;
import com.changddao.goorm_response_error.handleexception.CreateException;
import com.changddao.goorm_response_error.repository.UserRepository;
import com.changddao.goorm_response_error.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ApiUserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("create/user")
    public ApiResponse createUser(@RequestBody @Validated RequestUserDto userData, BindingResult results) {
        if (results.hasErrors()) {
            if (results.hasFieldErrors("username")) {
                throw new CreateException("이름을 잘못 입력하였습니다.");
            }
            if (results.hasFieldErrors("grade")) {
                log.info("grade is {}", results.getFieldValue("grade"));
                throw new CreateException("학점을 잘못 입력하였습니다.",
                        new Throwable(results.getFieldValue("grade").toString()));

            }
        }
        User user = User.builder().username(userData.getUsername())
                .grade(userData.getGrade())
                .build();
        userService.joinUser(user);
        return new ApiResponse(new Status(CustomStatusCode.OK.getStatusCode(), CustomStatusCode.OK.name()),
                new MetaData(1),
                new ResponseUserDto(user));
    }

    @GetMapping("findAll/users")
    public ApiResponse findAllAsc() {
        List<User> users = userService.findAllGradeASC();
        if (users.isEmpty()) {
            throw new CustomFindAllException("저장된 유저가 없습니다. 유저를 등록 하세요");
        }
        return new ApiResponse(
                new Status(CustomStatusCode.OK.getStatusCode(),
                        "grade를 기준으로 오름차순 정렬된 리스트입니다." ),
                new MetaData(users.size()),
                users);
    }
    @GetMapping("findAll/users/desc")
    public ApiResponse findAllDesc() {
        List<User> users = userService.findAllGradeDESC();
        if (users.isEmpty()) {
            throw new CustomFindAllException("저장된 유저가 없습니다. 유저를 등록 하세요");
        }
        return new ApiResponse(
                new Status(CustomStatusCode.OK.getStatusCode(),
                        "grade를 기준으로 내림차순 정렬된 리스트입니다." ),
                new MetaData(users.size()),
                users);
    }
    @GetMapping("findAll/users/{grade}")
    public ApiResponse findAllSameGrade(@PathVariable("grade")Integer grade) {
        List<User> users = userService.findAllEqualGrade(grade);
        if (users.isEmpty()) {
            throw new CustomFindAllException("저장된 유저가 없습니다. 유저를 등록 하세요");
        }
        return new ApiResponse(
                new Status(CustomStatusCode.OK.getStatusCode(),
                        "학점이 동일한 User 리스트입니다." ),
                new MetaData(users.size()),
                users);

    }


}
