package com.azbj.fm2002.dto;

public class BiReportResponse {
    private String biNumber;
    private String biPdf;
    private String message;
    private String status;
    private Integer premiumTerm;
    private Integer benefitTerm;
    private String quoteId;
    private Double premium;
    private Double sumAssured;

    // Getters and Setters
    public String getBiNumber() {
        return biNumber;
    }

    public void setBiNumber(String biNumber) {
        this.biNumber = biNumber;
    }

    public String getBiPdf() {
        return biPdf;
    }

    public void setBiPdf(String biPdf) {
        this.biPdf = biPdf;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(Integer premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public Integer getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(Integer benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
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
}