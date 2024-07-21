package com.azbj.fm2002.dto;

public class ReinsuranceDetailsDTO {
    private String coverNumber;
    private String coverCode;
    private String coverDescription;
    private String reinsuranceType;
    private String reinsuranceCode;
    private Double reinsurancePercentage;
    private String referenceNumber;

    // Getters and Setters
    public String getCoverNumber() {
        return coverNumber;
    }

    public void setCoverNumber(String coverNumber) {
        this.coverNumber = coverNumber;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public String getCoverDescription() {
        return coverDescription;
    }

    public void setCoverDescription(String coverDescription) {
        this.coverDescription = coverDescription;
    }

    public String getReinsuranceType() {
        return reinsuranceType;
    }

    public void setReinsuranceType(String reinsuranceType) {
        this.reinsuranceType = reinsuranceType;
    }

    public String getReinsuranceCode() {
        return reinsuranceCode;
    }

    public void setReinsuranceCode(String reinsuranceCode) {
        this.reinsuranceCode = reinsuranceCode;
    }

    public Double getReinsurancePercentage() {
        return reinsurancePercentage;
    }

    public void setReinsurancePercentage(Double reinsurancePercentage) {
        this.reinsurancePercentage = reinsurancePercentage;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
}