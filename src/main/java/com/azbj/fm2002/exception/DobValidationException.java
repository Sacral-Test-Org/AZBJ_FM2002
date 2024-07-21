package com.azbj.fm2002.exception;

public class DobValidationException extends RuntimeException {
    private String message;

    public DobValidationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}