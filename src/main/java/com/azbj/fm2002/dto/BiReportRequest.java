package com.azbj.fm2002.dto;

public class BiReportRequest {
    private String coverType;
    private String coverDetails;
    private Double premium;
    private Double sumAssured;
    private Integer benefitTerm;
    private Integer premiumTerm;

    // Getters and Setters
    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getCoverDetails() {
        return coverDetails;
    }

    public void setCoverDetails(String coverDetails) {
        this.coverDetails = coverDetails;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(Double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public Integer getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(Integer benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public Integer getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(Integer premiumTerm) {
        this.premiumTerm = premiumTerm;
    }
}