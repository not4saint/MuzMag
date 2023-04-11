package com.muztorg.MuzTorg.security.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private String path;
    private String message;
    private int statusCode;
    private LocalDateTime localDateTime;
}
