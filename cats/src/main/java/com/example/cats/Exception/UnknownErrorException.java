package com.example.cats.Exception;

import org.springframework.http.HttpStatus;

public class UnknownErrorException extends ServiceException {

    public static final String UNEXPECTED_ERROR_CODE = "UN-002";
    public static final String UNEXPECTED_ERROR_MESSAGE = "Erro desconhecido %s";

    public UnknownErrorException(String errorCode) {
        super(UNEXPECTED_ERROR_CODE, String.format(UNEXPECTED_ERROR_MESSAGE, errorCode), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
