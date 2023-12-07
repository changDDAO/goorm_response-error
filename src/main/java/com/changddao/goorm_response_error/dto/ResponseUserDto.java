package com.changddao.goorm_response_error.dto;

import com.changddao.goorm_response_error.entity.User;
import com.changddao.goorm_response_error.handleexception.CustomStatusCode;
import lombok.Data;

@Data
public class ResponseUserDto {
    private Long id;
    private String username;
    private Integer grade;

    public ResponseUserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.grade = user.getGrade();
    }
}
