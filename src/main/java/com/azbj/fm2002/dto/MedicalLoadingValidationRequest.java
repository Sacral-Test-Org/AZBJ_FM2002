package com.azbj.fm2002.dto;

public class MedicalLoadingValidationRequest {
    private String coverCode;
    private int medicalLoadingPercentage;
    private String productDefinition;
    private int nonResidentInsurancePercentage;

    public MedicalLoadingValidationRequest() {}

    public MedicalLoadingValidationRequest(String coverCode, int medicalLoadingPercentage, String productDefinition, int nonResidentInsurancePercentage) {
        this.coverCode = coverCode;
        this.medicalLoadingPercentage = medicalLoadingPercentage;
        this.productDefinition = productDefinition;
        this.nonResidentInsurancePercentage = nonResidentInsurancePercentage;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public int getMedicalLoadingPercentage() {
        return medicalLoadingPercentage;
    }

    public void setMedicalLoadingPercentage(int medicalLoadingPercentage) {
        this.medicalLoadingPercentage = medicalLoadingPercentage;
    }

    public String getProductDefinition() {
        return productDefinition;
    }

    public void setProductDefinition(String productDefinition) {
        this.productDefinition = productDefinition;
    }

    public int getNonResidentInsurancePercentage() {
        return nonResidentInsurancePercentage;
    }

    public void setNonResidentInsurancePercentage(int nonResidentInsurancePercentage) {
        this.nonResidentInsurancePercentage = nonResidentInsurancePercentage;
    }
}