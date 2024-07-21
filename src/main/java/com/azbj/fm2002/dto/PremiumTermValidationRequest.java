package com.azbj.fm2002.dto;

public class PremiumTermValidationRequest {
    private int premiumTerm;

    public PremiumTermValidationRequest() {}

    public PremiumTermValidationRequest(int premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public int getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(int premiumTerm) {
        this.premiumTerm = premiumTerm;
    }
}
