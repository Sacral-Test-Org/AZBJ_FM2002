package com.azbj.fm2002.dto;

public class CoverTypeValidationResponse {
    private boolean isValid;
    private String errorMessage;

    public CoverTypeValidationResponse() {}

    public CoverTypeValidationResponse(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}