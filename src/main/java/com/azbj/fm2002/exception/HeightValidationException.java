package com.azbj.fm2002.exception;

public class HeightValidationException extends RuntimeException {
    private String message;

    public HeightValidationException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}