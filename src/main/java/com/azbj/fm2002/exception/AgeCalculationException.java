package com.azbj.fm2002.exception;

public class AgeCalculationException extends RuntimeException {
    public AgeCalculationException(String message) {
        super(message);
    }

    public AgeCalculationException(String message, Throwable cause) {
        super(message, cause);
    }
}