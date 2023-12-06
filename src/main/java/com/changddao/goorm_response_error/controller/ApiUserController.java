package com.changddao.goorm_response_error.controller;

import com.changddao.goorm_response_error.dto.RequestUserDto;
import com.changddao.goorm_response_error.dto.ResponseUserDto;
import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.repository.UserRepository;
import com.changddao.goorm_response_error.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApiUserController {
    private final UserService userService;
    private final UserRepository userRepository;

    @PostMapping("create/user")
    public Results createUser(@RequestBody RequestUserDto userData, BindingResult results) {
        if (results.hasErrors()) {
            throw new RuntimeException("잘못 입력했음");
        }
        User user = User.builder().username(userData.getUsername())
                .grade(userData.getGrade())
                .build();
        userService.joinUser(user);
        return new Results(new ResponseUserDto(user.getId(),user.getUsername(),user.getGrade()));
    }



}
