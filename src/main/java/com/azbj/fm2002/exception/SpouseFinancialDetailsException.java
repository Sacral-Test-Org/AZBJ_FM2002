package com.azbj.fm2002.exception;

public class SpouseFinancialDetailsException extends RuntimeException {
    public SpouseFinancialDetailsException(String message) {
        super(message);
    }

    public SpouseFinancialDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}