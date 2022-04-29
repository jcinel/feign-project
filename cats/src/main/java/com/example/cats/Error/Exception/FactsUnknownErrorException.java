package com.example.cats.Error.Exception;

public class FactsUnknownErrorException extends RuntimeException{
    private final String errorCode;

    public FactsUnknownErrorException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
