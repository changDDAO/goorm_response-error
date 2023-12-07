package com.changddao.goorm_response_error.handleexception;

public enum CustomStatusCode {
    USER_INPUT_ERROR(4000),
    OK(2000),
    NO_DATA_ERROR(5001),
    SERVER_ERROR(5000);
    // errorcode를 저장할 필드
        private Integer statusCode;
    private CustomStatusCode(Integer errorCode) {
        this.statusCode = errorCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
