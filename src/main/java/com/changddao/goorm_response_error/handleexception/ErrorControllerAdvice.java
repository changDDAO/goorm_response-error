package com.changddao.goorm_response_error.handleexception;

import com.changddao.goorm_response_error.dto.ErrorData;
import com.changddao.goorm_response_error.dto.ErrorResult;
import com.changddao.goorm_response_error.dto.Status;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.changddao.goorm_response_error.controller")
public class ErrorControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<ErrorResult> userHandler(CreateException e) {
        ErrorResult result = new ErrorResult(new Status(CustomStatusCode.USER_INPUT_ERROR.getStatusCode()
                , e.getMessage()), new ErrorData(e.getCause().getMessage()));
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.LENGTH_REQUIRED)
    @ExceptionHandler(CustomFindAllException.class)
    public ErrorResult findAllHandler(CustomFindAllException e) {
        return new ErrorResult(new Status(CustomStatusCode.NO_DATA_ERROR.getStatusCode(),
                e.getMessage()),
                new ErrorData("data 빵개요.."));
    }

}
