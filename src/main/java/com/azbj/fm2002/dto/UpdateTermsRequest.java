package com.azbj.fm2002.dto;

public class UpdateTermsRequest {
    private String premiumTerm;
    private String packageCode;
    private String benefitTerm;

    public UpdateTermsRequest() {}

    public UpdateTermsRequest(String premiumTerm, String packageCode, String benefitTerm) {
        this.premiumTerm = premiumTerm;
        this.packageCode = packageCode;
        this.benefitTerm = benefitTerm;
    }

    public String getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(String premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(String benefitTerm) {
        this.benefitTerm = benefitTerm;
    }
}