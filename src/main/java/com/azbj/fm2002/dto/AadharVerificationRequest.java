package com.azbj.fm2002.dto;

public class AadharVerificationRequest {
    private String aadhaarNumber;

    public AadharVerificationRequest() {}

    public AadharVerificationRequest(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }
}