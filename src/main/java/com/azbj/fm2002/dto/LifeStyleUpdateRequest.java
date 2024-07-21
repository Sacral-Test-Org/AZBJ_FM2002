package com.azbj.fm2002.dto;

public class LifeStyleUpdateRequest {
    private int productId;
    private String primaryStatus;
    private String secondaryStatus;
    private String contractId;
    private String verificationNumber;

    public LifeStyleUpdateRequest() {}

    public LifeStyleUpdateRequest(int productId, String primaryStatus, String secondaryStatus, String contractId, String verificationNumber) {
        this.productId = productId;
        this.primaryStatus = primaryStatus;
        this.secondaryStatus = secondaryStatus;
        this.contractId = contractId;
        this.verificationNumber = verificationNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getPrimaryStatus() {
        return primaryStatus;
    }

    public void setPrimaryStatus(String primaryStatus) {
        this.primaryStatus = primaryStatus;
    }

    public String getSecondaryStatus() {
        return secondaryStatus;
    }

    public void setSecondaryStatus(String secondaryStatus) {
        this.secondaryStatus = secondaryStatus;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getVerificationNumber() {
        return verificationNumber;
    }

    public void setVerificationNumber(String verificationNumber) {
        this.verificationNumber = verificationNumber;
    }
}