package com.changddao.goorm_response_error.repository;

import com.changddao.goorm_response_error.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
// 굳이 에노테이션 필요없긴함 스프링이 ComponentScan 대상으로 인식함
public interface UserRepository extends JpaRepository<User, Long> {

}
