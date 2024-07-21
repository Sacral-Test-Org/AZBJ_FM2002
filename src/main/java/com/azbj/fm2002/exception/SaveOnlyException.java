package com.azbj.fm2002.exception;

public class SaveOnlyException extends RuntimeException {
    private String message;
    private Throwable cause;

    public SaveOnlyException(String message) {
        super(message);
        this.message = message;
    }

    public SaveOnlyException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
        this.cause = cause;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}