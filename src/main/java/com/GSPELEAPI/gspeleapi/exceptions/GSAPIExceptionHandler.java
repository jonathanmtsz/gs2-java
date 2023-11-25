package com.GSPELEAPI.gspeleapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GSAPIExceptionHandler {
    @ExceptionHandler(value = {org.hibernate.ObjectNotFoundException.class})
    public ResponseEntity<Object> handleObjectNotFoundException
            (ObjectNotFoundException objectNotFoundException)
    {
        SearchFailedException searchFailedException = new SearchFailedException(
                objectNotFoundException.getCause(),
                objectNotFoundException.getMessage(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(searchFailedException, HttpStatus.NOT_FOUND);
    }
}
