package com.azbj.fm2002.dto;

public class ReinsuranceCoverDetailsDTO {
    private String product;
    private Double specialRiskPercentage;
    private Double reinsurancePercentage;
    private Double coverAmount;
    private Double calculatedReinsuranceAmount;

    // Getters and Setters
    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getSpecialRiskPercentage() {
        return specialRiskPercentage;
    }

    public void setSpecialRiskPercentage(Double specialRiskPercentage) {
        this.specialRiskPercentage = specialRiskPercentage;
    }

    public Double getReinsurancePercentage() {
        return reinsurancePercentage;
    }

    public void setReinsurancePercentage(Double reinsurancePercentage) {
        this.reinsurancePercentage = reinsurancePercentage;
    }

    public Double getCoverAmount() {
        return coverAmount;
    }

    public void setCoverAmount(Double coverAmount) {
        this.coverAmount = coverAmount;
    }

    public Double getCalculatedReinsuranceAmount() {
        return calculatedReinsuranceAmount;
    }

    public void setCalculatedReinsuranceAmount(Double calculatedReinsuranceAmount) {
        this.calculatedReinsuranceAmount = calculatedReinsuranceAmount;
    }
}