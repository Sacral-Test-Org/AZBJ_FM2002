package com.azbj.fm2002.exception;

public class UnderwriterValidationException extends RuntimeException {
    private String message;

    public UnderwriterValidationException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}