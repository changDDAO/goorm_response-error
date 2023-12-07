package com.changddao.goorm_response_error.repository;

import com.changddao.goorm_response_error.entity.User;
import org.assertj.core.api.Assertions;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
@SpringBootTest
@Transactional
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    void 회원_저장(){
    //given
        User user = User.builder()
                .username("changho")
                .grade(3).build();
    //when
        userRepository.save(user);
        Optional<User> findUser = userRepository.findById(user.getId());
        //that
        assertThat(findUser.get()).isEqualTo(user);
    }

    @Test
    void 회원_이름_변경(){
    //given
        User user = new User("jongho", 5);
    //when
        userRepository.save(user);
        User user1 = userRepository.findById(user.getId()).get();
        user1.changeUsername("kimchi");
        User findUser = userRepository.findById(user1.getId()).get();
        //that
        System.out.println(findUser.getUsername());
    }

    @Test
    void DB저장에_Valid(){
    //given
        User user1 = User.builder()
                .username("changho")
                .grade(70)
                .build();
        //when
        userRepository.save(user1);
    /*    that
        db에서 제약처리
        List of constraint violations:[
        ConstraintViolationImpl
        {interpolatedMessage='5를 초과하는 학점은 입력이 불가능 합니다.',
         propertyPath=grade, rootBeanClass=class com.changddao.goorm_response_error.entity.User, messageTemplate='5를 초과하는 학점은 입력이 불가능 합니다.'}
        ]*/

    }
    @Test
    void 학점_변경(){
    //given
        User user1 = new User("jina", 3);
        User user2 = new User("changho", 4);
        userRepository.save(user1);
        userRepository.save(user2);
    //when
        User findUser = userRepository.findById(user1.getId()).get();
        findUser.changeGrade(1);
        //that
        User changeUser = userRepository.findById(user1.getId()).get();
        assertThat(changeUser.getGrade()).isEqualTo(1);
    }

    @Test
    void 회원_전체조회(){
    //given
        User user1 = new User("jina", 3);
        User user2 = new User("changho", 4);
        userRepository.save(user1);
        userRepository.save(user2);
    //when
        List<User> users = userRepository.findAll();
        //that
        assertThat(users.size()).isEqualTo(2);
    }
    @Test
    void 학점이같은User(){
    //given
        User user1 = new User("jina", 3);
        User user2 = new User("changho", 4);
        User user3 = new User("파이리", 3);
        User user4 = new User("꼬부기", 4);
    //when
        List<User> users = userRepository.getUsersEqualGrade(3);
        //that
        for (User user : users) {
            System.out.print("user.getUsername() = " + user.getUsername()+", ");
            System.out.println("user.getGrade() = " + user.getGrade());
        }
    }

}