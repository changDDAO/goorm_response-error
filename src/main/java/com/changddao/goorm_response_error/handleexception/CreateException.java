package com.changddao.goorm_response_error.handleexception;


public class CreateException extends IllegalArgumentException{
    public CreateException(String message) {
        super(message);
    }

    public CreateException(String message, Throwable cause) {
        super(message, cause);
    }
}
