package com.azbj.fm2002.dto;

public class DiscountTypeRequest {
    private String agentCode;
    private int productId;
    private String applicationNo;
    private String receiptNo;

    public DiscountTypeRequest() {}

    public DiscountTypeRequest(String agentCode, int productId, String applicationNo, String receiptNo) {
        this.agentCode = agentCode;
        this.productId = productId;
        this.applicationNo = applicationNo;
        this.receiptNo = receiptNo;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getApplicationNo() {
        return applicationNo;
    }

    public void setApplicationNo(String applicationNo) {
        this.applicationNo = applicationNo;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }
}