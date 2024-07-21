package com.azbj.fm2002.dto;

public class PolicyMemberValidationResponse {
    private boolean isValid;
    private double bmi;
    private String errorMessage;

    public PolicyMemberValidationResponse() {}

    public PolicyMemberValidationResponse(boolean isValid, double bmi, String errorMessage) {
        this.isValid = isValid;
        this.bmi = bmi;
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
