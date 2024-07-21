package com.azbj.fm2002.exception;

public class ReinsuranceDetailsException extends RuntimeException {
    private String message;

    public ReinsuranceDetailsException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}