package com.azbj.fm2002.exception;

public class MultiplierValidationException extends RuntimeException {
    private String errorMessage;

    public MultiplierValidationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}