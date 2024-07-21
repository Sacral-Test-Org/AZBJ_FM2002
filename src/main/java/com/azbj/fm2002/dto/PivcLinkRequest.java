package com.azbj.fm2002.dto;

public class PivcLinkRequest {
    private String verificationNumber;
    private String signCardNumber;

    public PivcLinkRequest() {}

    public PivcLinkRequest(String verificationNumber, String signCardNumber) {
        this.verificationNumber = verificationNumber;
        this.signCardNumber = signCardNumber;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }

    public String getSignCardNumber() {
        return signCardNumber;
    }

    public void setSignCardNumber(String signCardNumber) {
        this.signCardNumber = signCardNumber;
    }
}