package com.example.cats.Exception;

import org.springframework.http.HttpStatus;

public abstract class ServiceException extends RuntimeException {

    private final String code;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    protected ServiceException(String code, String errorMessage, HttpStatus httpStatus) {
        this.code = code;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
