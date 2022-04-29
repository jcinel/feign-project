package com.example.cats.Error.Exception;

public class FactsServiceUnavailableException extends RuntimeException{
    private final FactsErrorCode errorCode;

    public FactsServiceUnavailableException(FactsErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public FactsErrorCode getErrorCode() {
        return errorCode;
    }
}
