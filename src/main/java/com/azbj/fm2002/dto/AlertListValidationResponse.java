package com.azbj.fm2002.dto;

public class AlertListValidationResponse {
    private boolean isValid;
    private String message;

    public AlertListValidationResponse() {}

    public AlertListValidationResponse(boolean isValid, String message) {
        this.isValid = isValid;
        this.message = message;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
