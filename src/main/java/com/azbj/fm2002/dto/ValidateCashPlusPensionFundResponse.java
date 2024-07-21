package com.azbj.fm2002.dto;

public class ValidateCashPlusPensionFundResponse {
    private boolean isValid;
    private String errorMessage;

    public ValidateCashPlusPensionFundResponse(boolean isValid, String errorMessage) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}