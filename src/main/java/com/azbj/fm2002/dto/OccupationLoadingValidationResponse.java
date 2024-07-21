package com.azbj.fm2002.dto;

public class OccupationLoadingValidationResponse {
    private boolean valid;
    private String message;

    public OccupationLoadingValidationResponse() {}

    public OccupationLoadingValidationResponse(boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
