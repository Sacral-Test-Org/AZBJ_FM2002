package com.azbj.fm2002.dto;

public class ValidateCashPlusPensionFundRequest {
    private int productId;
    private String fundId;
    private double apportionmentPercentage;

    public ValidateCashPlusPensionFundRequest() {}

    public ValidateCashPlusPensionFundRequest(int productId, String fundId, double apportionmentPercentage) {
        this.productId = productId;
        this.fundId = fundId;
        this.apportionmentPercentage = apportionmentPercentage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getFundId() {
        return fundId;
    }

    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public double getApportionmentPercentage() {
        return apportionmentPercentage;
    }

    public void setApportionmentPercentage(double apportionmentPercentage) {
        this.apportionmentPercentage = apportionmentPercentage;
    }
}