package com.azbj.fm2002.exception;

public class PolicyDetailsException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PolicyDetailsException(String message) {
        super(message);
    }

    public PolicyDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}