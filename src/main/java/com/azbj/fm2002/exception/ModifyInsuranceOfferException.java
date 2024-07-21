package com.azbj.fm2002.exception;

public class ModifyInsuranceOfferException extends RuntimeException {
    private String errorMessage;
    private String errorCode;

    public ModifyInsuranceOfferException(String errorMessage, String errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
}