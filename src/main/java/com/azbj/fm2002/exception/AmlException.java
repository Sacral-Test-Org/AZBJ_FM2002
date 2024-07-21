package com.azbj.fm2002.exception;

public class AmlException extends RuntimeException {
    public AmlException(String message) {
        super(message);
    }

    public AmlException(String message, Throwable cause) {
        super(message, cause);
    }
}