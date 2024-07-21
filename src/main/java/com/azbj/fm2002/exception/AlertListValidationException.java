package com.azbj.fm2002.exception;

public class AlertListValidationException extends RuntimeException {
    private String message;

    public AlertListValidationException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
