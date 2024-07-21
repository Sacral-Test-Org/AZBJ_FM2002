package com.azbj.fm2002.dto;

public class MultiplierValidationRequest {
    private Double multiplier;
    private Integer productId;
    private String packageType;
    private String bookingFrequency;
    private Double premiumAmount;

    public MultiplierValidationRequest() {}

    public MultiplierValidationRequest(Double multiplier, Integer productId, String packageType, String bookingFrequency, Double premiumAmount) {
        this.multiplier = multiplier;
        this.productId = productId;
        this.packageType = packageType;
        this.bookingFrequency = bookingFrequency;
        this.premiumAmount = premiumAmount;
    }

    public Double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Double multiplier) {
        this.multiplier = multiplier;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }

    public Double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}