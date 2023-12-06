package com.changddao.goorm_response_error.service;

import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;
    @Test
    void 회원_등록(){
    //given
        Long userId = userService.joinUser(User.builder()
                .username("changho")
                .grade(5)
                .build());
        //when
        Assertions.assertThat(userId).isEqualTo(1);
    //that
    }
    @Test
    void 학점변경(){
    //given
        User user = new User("changho", 1);
        userService.joinUser(user);
        User findUser = userRepository.findById(1L).orElse(null);
        //when
        userService.updateGrade(findUser.getId(), 3);
    //that
        List<User> users = userRepository.findAll();
        for (User user1 : users) {
            System.out.println("user1 = " + user1.getGrade());
            //학점변경 완료
        }
    }

}