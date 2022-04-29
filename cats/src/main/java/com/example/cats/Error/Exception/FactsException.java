package com.example.cats.Error.Exception;

public class FactsException extends RuntimeException{
    private final FactsErrorCode errorCode;

    public FactsException(FactsErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FactsErrorCode getErrorCode() {
        return errorCode;
    }
}
