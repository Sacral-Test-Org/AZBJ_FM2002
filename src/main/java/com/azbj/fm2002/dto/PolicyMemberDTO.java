package com.azbj.fm2002.dto;

public class PolicyMemberDTO {
    private String relationship;
    private String companyName;
    private Double sumAssured;
    private Double premiumAmount;

    // Getters and Setters
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(Double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}
