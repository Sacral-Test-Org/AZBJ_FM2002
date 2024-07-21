package com.azbj.fm2002.exception;

public class GpbOptedException extends RuntimeException {
    private String message;

    public GpbOptedException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}