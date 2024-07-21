package com.azbj.fm2002.exception;

public class ManualCasePushException extends RuntimeException {
    private String message;
    private String errorCode;

    public ManualCasePushException(String message, String errorCode) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
