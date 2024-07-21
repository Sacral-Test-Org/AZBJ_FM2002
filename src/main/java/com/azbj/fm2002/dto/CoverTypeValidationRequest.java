package com.azbj.fm2002.dto;

public class CoverTypeValidationRequest {
    private String coverType;
    private boolean isLoading;
    private String bookingFrequency;
    private int productId;
    private String receiptDate;
    private String productType;

    // Getters and Setters
    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public String getBookingFrequency() {
        return bookingFrequency;
    }

    public void setBookingFrequency(String bookingFrequency) {
        this.bookingFrequency = bookingFrequency;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}