package com.azbj.fm2002.exception;

public class RequestProcessingException extends RuntimeException {
    private String message;
    private Throwable cause;

    public RequestProcessingException(String message) {
        super(message);
        this.message = message;
    }

    public RequestProcessingException(String message, Throwable cause) {
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