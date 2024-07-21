package com.azbj.fm2002.dto;

import java.math.BigDecimal;

public class PremiumCalculationRequest {
    private String policyId;
    private String productId;
    private String coverCode;
    private String packageCode;
    private int entryAge;
    private String bookingFrequency;
    private int benefitTerm;
    private BigDecimal basePremium;
    private String ageProofType;
    private double sumAssured;
    private double premiumAmount;

    // Getters and Setters
    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public int getEntryAge() {
        return entryAge;
    }

    public void setEntryAge(int entryAge) {
        this.entryAge = entryAge;
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }

    public int getBenefitTerm() {
        return benefitTerm;
    }

    public void setBenefitTerm(int benefitTerm) {
        this.benefitTerm = benefitTerm;
    }

    public BigDecimal getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(BigDecimal basePremium) {
        this.basePremium = basePremium;
    }

    public String getAgeProofType() {
        return ageProofType;
    }

    public void setAgeProofType(String ageProofType) {
        this.ageProofType = ageProofType;
    }

    public double getSumAssured() {
        return sumAssured;
    }

    public void setSumAssured(double sumAssured) {
        this.sumAssured = sumAssured;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}