package com.azbj.fm2002.exception;

public class AadharVerificationException extends RuntimeException {
    private String errorMessage;

    public AadharVerificationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}