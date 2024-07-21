package com.azbj.fm2002.exception;

public class PanValidationException extends RuntimeException {
    private String message;
    private String errorCode;

    public PanValidationException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}