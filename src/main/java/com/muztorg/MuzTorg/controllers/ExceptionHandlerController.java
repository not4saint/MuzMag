package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.security.exceptions.EmptyUserInformationException;
import com.muztorg.MuzTorg.security.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EmptyUserInformationException.class)
    public ResponseEntity<ErrorResponse> handleEmptyUserInformationException(RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
