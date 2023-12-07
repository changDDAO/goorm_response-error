package com.changddao.goorm_response_error.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult<T> {
    private T status;
    private T data;
}
