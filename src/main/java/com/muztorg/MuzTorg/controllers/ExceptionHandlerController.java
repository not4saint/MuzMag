package com.muztorg.MuzTorg.controllers;

import com.muztorg.MuzTorg.security.exceptions.EmailAlreadyRegisteredException;
import com.muztorg.MuzTorg.security.exceptions.EmptyUserInformationException;
import com.muztorg.MuzTorg.security.exceptions.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
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
    public ResponseEntity<ExceptionResponse> handleEmptyUserInformationException(RuntimeException e,
                                                                                 HttpServletRequest httpRequest) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(httpRequest.getRequestURI(), e.getMessage(),
                                                                    HttpStatus.BAD_REQUEST.value(), LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
