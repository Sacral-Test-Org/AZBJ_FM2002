package com.azbj.fm2002.exception;

public class RejectedApplicationReasonException extends RuntimeException {
    public RejectedApplicationReasonException(String message) {
        super(message);
    }

    public RejectedApplicationReasonException(String message, Throwable cause) {
        super(message, cause);
    }
}