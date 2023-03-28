package com.muztorg.MuzTorg.security.exceptions;

public class EmptyUserInformationException extends RuntimeException {
    public EmptyUserInformationException(String message) {
        super(message);
    }
}
