package com.azbj.fm2002.exception;

public class BenefitTermException extends RuntimeException {
    private String errorMessage;

    public BenefitTermException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
