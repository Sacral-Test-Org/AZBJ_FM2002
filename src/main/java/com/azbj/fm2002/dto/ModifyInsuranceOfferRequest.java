package com.azbj.fm2002.dto;

public class ModifyInsuranceOfferRequest {
    private String productId;
    private double sumAssured;
    private int benefitTerm;
    private int premiumTerm;
    private double premiumAmount;
    private String coverName;
    private String coverCode;
    private double gst;

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public int getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(int benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public int getPremiumTerm() {
        return premiumTerm;
    }

    public void setPremiumTerm(int premiumTerm) {
        this.premiumTerm = premiumTerm;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }
}