package com.azbj.fm2002.dto;

public class SumAssuredCalculationRequest {
    private int productId;
    private String bookingFrequency;
    private double multiplier;
    private double premiumAmount;

    public SumAssuredCalculationRequest() {}

    public SumAssuredCalculationRequest(int productId, String bookingFrequency, double multiplier, double premiumAmount) {
        this.productId = productId;
        this.bookingFrequency = bookingFrequency;
        this.multiplier = multiplier;
        this.premiumAmount = premiumAmount;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(double premiumAmount) {
        this.premiumAmount = premiumAmount;
    }
}