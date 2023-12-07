package com.changddao.goorm_response_error.handleexception;

public class CustomFindAllException extends RuntimeException{
    public CustomFindAllException(String message) {
        super(message);
    }
}
