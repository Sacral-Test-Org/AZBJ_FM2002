package com.azbj.fm2002.dto;

public class LoanTypeValidationResponse {
    private String formStatus;
    private String errorMessage;

    public LoanTypeValidationResponse() {}

    public LoanTypeValidationResponse(String formStatus, String errorMessage) {
        this.formStatus = formStatus;
        this.errorMessage = errorMessage;
    }

    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}