package com.azbj.fm2002.exception;

public class CoverTypeValidationException extends RuntimeException {
    public CoverTypeValidationException(String message) {
        super(message);
    }

    public CoverTypeValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}