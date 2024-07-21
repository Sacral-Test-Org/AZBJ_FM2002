package com.azbj.fm2002.exception;

public class MedicalLoadingValidationException extends RuntimeException {
    private String errorMessage;

    public MedicalLoadingValidationException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}