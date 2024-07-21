package com.azbj.fm2002.exception;

public class SeniorUnderwriterException extends RuntimeException {
    public SeniorUnderwriterException(String message) {
        super(message);
    }

    public SeniorUnderwriterException(String message, Throwable cause) {
        super(message, cause);
    }
}