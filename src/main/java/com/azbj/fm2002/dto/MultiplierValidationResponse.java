package com.azbj.fm2002.dto;

public class MultiplierValidationResponse {
    private boolean isValid;
    private String errorMessage;
    private double sumAssured;

    public MultiplierValidationResponse() {}

    public MultiplierValidationResponse(boolean isValid, String errorMessage, double sumAssured) {
        this.isValid = isValid;
        this.errorMessage = errorMessage;
        this.sumAssured = sumAssured;
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

    public double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(double sumAssured) {
        this.sumAssured = sumAssured;
    }
}
