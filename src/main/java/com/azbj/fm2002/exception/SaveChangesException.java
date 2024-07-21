package com.azbj.fm2002.exception;

public class SaveChangesException extends RuntimeException {
    public SaveChangesException(String message) {
        super(message);
    }

    public SaveChangesException(String message, Throwable cause) {
        super(message, cause);
    }
}