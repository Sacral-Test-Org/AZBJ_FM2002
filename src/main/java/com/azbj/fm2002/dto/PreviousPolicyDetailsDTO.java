package com.azbj.fm2002.dto;

public class PreviousPolicyDetailsDTO {
    private String policyNumber;
    private String customerName;
    private String status;
    private String reason;
    private String comments;

    // Constructors
    public PreviousPolicyDetailsDTO() {}

    public PreviousPolicyDetailsDTO(String policyNumber, String customerName, String status, String reason, String comments) {
        this.policyNumber = policyNumber;
        this.customerName = customerName;
        this.status = status;
        this.reason = reason;
        this.comments = comments;
    }

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
