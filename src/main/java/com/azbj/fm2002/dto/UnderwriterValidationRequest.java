package com.azbj.fm2002.dto;

public class UnderwriterValidationRequest {
    private String underwriterId;

    public UnderwriterValidationRequest() {}

    public UnderwriterValidationRequest(String underwriterId) {
        this.underwriterId = underwriterId;
    }

    public String getUnderwriterId() {
        return underwriterId;
    }

    public void setUnderwriterId(String underwriterId) {
        this.underwriterId = underwriterId;
    }
}
