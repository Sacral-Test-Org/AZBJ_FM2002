package com.azbj.fm2002.dto;

import java.util.Date;

public class LoanTypeValidationRequest {
    private String loanType;
    private Date receivedDate;
    private Date defaultDate;
    private String bookingFrequency;
    private int productId;

    // Getters and Setters
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getDefaultDate() {
        return defaultDate;
    }

    public void setDefaultDate(Date defaultDate) {
        this.defaultDate = defaultDate;
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
}