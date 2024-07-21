package com.azbj.fm2002.exception;

public class PanDetailsException extends RuntimeException {
    public PanDetailsException(String message) {
        super(message);
    }

    public PanDetailsException(String message, Throwable cause) {
        super(message, cause);
    }
}