package com.example.cats.Exception;

import org.springframework.http.HttpStatus;

public class UnexpectedErrorException extends ServiceException {

    public static final String UNEXPECTED_ERROR_CODE = "UN-999";
    public static final String UNEXPECTED_ERROR_MESSAGE = "Erro inesperado";

    public UnexpectedErrorException() {
        super(UNEXPECTED_ERROR_CODE, UNEXPECTED_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
