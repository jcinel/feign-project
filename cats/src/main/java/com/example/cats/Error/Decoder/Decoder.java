package com.example.cats.Error.Decoder;
import com.example.cats.Error.Exception.FactsErrorCode;
import com.example.cats.Error.Exception.FactsException;
import com.example.cats.Error.Exception.FactsUnexpectedError;
import com.example.cats.Error.Exception.FactsUnknownError;
import com.example.cats.Error.Response.FactsErrorResponse;
import feign.Response;
import com.google.gson.Gson;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;


public class Decoder implements ErrorDecoder {
    public static final String RESPONSE_BODY_NULL_ERROR_MESSAGE = "Response body is null";
    private final Gson gson;

    public Decoder() {
        this.gson = new Gson();
    }

    @Override
    public Exception decode(String s, Response response) {
        Optional<FactsErrorCode> errorCode;
        FactsErrorResponse errorResponse;

        try {
            validateResponseBodyIsNotNull(response);
            errorResponse = buildFactsErrorResponse(response);
            errorCode = FactsErrorCode.getByCode(errorResponse.getErrorCode());
        } catch (Exception ex) {
            throw new FactsUnexpectedError(ex);
        }

        if (errorCode.isPresent()) {
            throw new FactsException(errorCode.get());
        } else {
            throw new FactsUnknownError(errorResponse.getErrorCode());
        }
    }

    private void validateResponseBodyIsNotNull(Response response) {
        if (response.body() == null) {
            throw new NullPointerException(RESPONSE_BODY_NULL_ERROR_MESSAGE);
        }
    }
    private FactsErrorResponse buildFactsErrorResponse(Response response) throws IOException {
        var writer = new StringWriter();
        IOUtils.copy(response.body().asInputStream(), writer, StandardCharsets.UTF_8.displayName());
        return gson.fromJson(writer.toString(), FactsErrorResponse.class);
    }
}
