package com.changddao.goorm_response_error.repository;

import com.changddao.goorm_response_error.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
// 굳이 에노테이션 필요없긴함 스프링이 ComponentScan 대상으로 인식함
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u where u.grade=:grade")
    List<User> getUsersEqualGrade(@Param("grade") Integer grade);
}
