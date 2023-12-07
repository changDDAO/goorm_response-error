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
    @Test
    void SortingTest(){
    //given
        User user1 = new User("jina", 5);
        User user2 = new User("changho", 3);
        User user3 = new User("jaeson", 4);
        User user4 = new User("junsu", 1);
    //when
        userService.joinUser(user1);
        userService.joinUser(user2);
        userService.joinUser(user3);
        userService.joinUser(user4);
        List<User> usersAsc = userService.findAllGradeASC();
        //that
        for (User user : usersAsc) {
            System.out.println("user.getUsername() = " + user.getUsername());
            System.out.println("user.getGrade() = " + user.getGrade());
        }
    }

}