package com.azbj.fm2002.dto;

import java.util.List;

public class CounterOfferValidationResponse {
    private Boolean isValid;
    private List<String> validationErrors;

    public CounterOfferValidationResponse() {}

    public CounterOfferValidationResponse(Boolean isValid, List<String> validationErrors) {
        this.isValid = isValid;
        this.validationErrors = validationErrors;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public List<String> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<String> validationErrors) {
        this.validationErrors = validationErrors;
    }
}
