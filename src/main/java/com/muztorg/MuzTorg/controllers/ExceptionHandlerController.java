package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.security.exceptions.EmailAlreadyRegisteredException;
import com.muztorg.MuzTorg.security.exceptions.EmptyUserInformationException;
import com.muztorg.MuzTorg.security.exceptions.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ExceptionHandlerController {
    public String configureMessage(BindingResult bindingResult) {
        StringBuilder str = new StringBuilder();
        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError fieldError : errors) {
            str.append(fieldError.getField()).append(" - ").append(fieldError.getDefaultMessage()).append(";");
        }
        return str.toString();
    }
    @ExceptionHandler({EmptyUserInformationException.class, EmailAlreadyRegisteredException.class})
    public ResponseEntity<ErrorResponse> handleEmptyUserInformationException(RuntimeException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
