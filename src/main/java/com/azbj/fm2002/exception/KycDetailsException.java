package com.azbj.fm2002.exception;

public class KycDetailsException extends RuntimeException {
    public KycDetailsException(String message) {
        super(message);
    }

    public KycDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}