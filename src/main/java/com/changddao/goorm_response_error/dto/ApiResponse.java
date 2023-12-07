package com.changddao.goorm_response_error.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T>{
    T status;
    T metadata;
    T results;
}
