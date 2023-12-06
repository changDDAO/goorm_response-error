package com.changddao.goorm_response_error.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseUserDto {
    private Long id;
    private String username;
    private Integer grade;
}
