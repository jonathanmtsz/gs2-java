package com.GSPELEAPI.gspeleapi.exceptions;

import org.springframework.http.HttpStatus;

public class SearchFailedException {
    private final Throwable throwable;
    private final String message;
    private final HttpStatus httpStatus;

    public SearchFailedException(Throwable throwable, String message, HttpStatus httpStatus) {
        this.throwable = throwable;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    private static class ValidationError {
        private String field;
        private String message;
    }
}
