package com.azbj.fm2002.dto;

public class ModifyInsuranceOfferResponse {
    private boolean success;
    private String message;
    private InsuranceOfferDetails updatedOfferDetails;

    public ModifyInsuranceOfferResponse() {}

    public ModifyInsuranceOfferResponse(boolean success, String message, InsuranceOfferDetails updatedOfferDetails) {
        this.success = success;
        this.message = message;
        this.updatedOfferDetails = updatedOfferDetails;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public InsuranceOfferDetails getUpdatedOfferDetails() {
        return updatedOfferDetails;
    }

    public void setUpdatedOfferDetails(InsuranceOfferDetails updatedOfferDetails) {
        this.updatedOfferDetails = updatedOfferDetails;
    }
}

class InsuranceOfferDetails {
    private String productId;
    private double sumAssured;
    private int benefitTerm;
    private int premiumTerm;
    private double premiumAmount;
    private String coverName;
    private String coverCode;
    private double gst;

    public InsuranceOfferDetails() {}

    public InsuranceOfferDetails(String productId, double sumAssured, int benefitTerm, int premiumTerm, double premiumAmount, String coverName, String coverCode, double gst) {
        this.productId = productId;
        this.sumAssured = sumAssured;
        this.benefitTerm = benefitTerm;
        this.premiumTerm = premiumTerm;
        this.premiumAmount = premiumAmount;
        this.coverName = coverName;
        this.coverCode = coverCode;
        this.gst = gst;
    }

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
