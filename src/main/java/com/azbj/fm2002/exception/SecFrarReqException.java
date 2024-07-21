package com.azbj.fm2002.exception;

public class SecFrarReqException extends RuntimeException {
    public SecFrarReqException(String message) {
        super(message);
    }

    public SecFrarReqException(String message, Throwable cause) {
        super(message, cause);
    }
}