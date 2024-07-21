package com.azbj.fm2002.exception;

public class UpdateTermsException extends RuntimeException {
    private String message;

    public UpdateTermsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}