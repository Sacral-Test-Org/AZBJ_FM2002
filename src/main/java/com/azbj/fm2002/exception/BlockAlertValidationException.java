package com.azbj.fm2002.exception;

public class BlockAlertValidationException extends RuntimeException {
    public BlockAlertValidationException(String message) {
        super(message);
    }

    public BlockAlertValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}