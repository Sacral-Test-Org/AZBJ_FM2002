package com.azbj.fm2002.exception;

public class SaveReasonException extends RuntimeException {
    private String message;
    private Throwable cause;

    public SaveReasonException(String message) {
        super(message);
        this.message = message;
    }

    public SaveReasonException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }
}