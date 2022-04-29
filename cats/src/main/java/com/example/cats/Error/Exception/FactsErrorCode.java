package com.example.cats.Error.Exception;

import java.util.Arrays;
import java.util.Optional;

public enum FactsErrorCode {
    UNAUTHORIZED("001"),
    UNAVAILABLE("010");

    private final String code;

    FactsErrorCode(String code) {
        this.code = code;
    }

    public static Optional<FactsErrorCode> getByCode(String code) {
        return Arrays.stream(FactsErrorCode.values())
                .filter(error -> error.getCode().equals(code)).findFirst();
    }

    public String getCode() {
        return code;
    }
}
