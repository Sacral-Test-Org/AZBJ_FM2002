package com.azbj.fm2002.exception;

public class ThirdPartyChequeException extends RuntimeException {
    public ThirdPartyChequeException(String message) {
        super(message);
    }

    public ThirdPartyChequeException(String message, Throwable cause) {
        super(message, cause);
    }
}