package com.example.cats.Error.Exception;

public class FactsUnknownError extends RuntimeException{
    private final String errorCode;

    public FactsUnknownError(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
