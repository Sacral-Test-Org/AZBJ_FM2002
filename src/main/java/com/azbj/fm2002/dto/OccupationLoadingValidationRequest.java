package com.azbj.fm2002.dto;

public class OccupationLoadingValidationRequest {
    private String coverCode;
    private double occupationLoadingClass;
    private String calculationType;
    private String userId;

    public OccupationLoadingValidationRequest() {}

    public OccupationLoadingValidationRequest(String coverCode, double occupationLoadingClass, String calculationType, String userId) {
        this.coverCode = coverCode;
        this.occupationLoadingClass = occupationLoadingClass;
        this.calculationType = calculationType;
        this.userId = userId;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public double getOccupationLoadingClass() {
        return occupationLoadingClass;
    }

    public void setOccupationLoadingClass(double occupationLoadingClass) {
        this.occupationLoadingClass = occupationLoadingClass;
    }

    public String getCalculationType() {
        return calculationType;
    }

    public void setCalculationType(String calculationType) {
        this.calculationType = calculationType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}