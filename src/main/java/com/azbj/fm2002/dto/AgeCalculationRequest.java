package com.azbj.fm2002.dto;

import java.time.LocalDate;

public class AgeCalculationRequest {
    private LocalDate insuredPersonDob;
    private LocalDate policyholderDob;
    private LocalDate inceptionDate;
    private String proofType;
    private String fieldValue;

    public AgeCalculationRequest() {}

    public AgeCalculationRequest(LocalDate insuredPersonDob, LocalDate policyholderDob, LocalDate inceptionDate, String proofType, String fieldValue) {
        this.insuredPersonDob = insuredPersonDob;
        this.policyholderDob = policyholderDob;
        this.inceptionDate = inceptionDate;
        this.proofType = proofType;
        this.fieldValue = fieldValue;
    }

    public LocalDate getInsuredPersonDob() {
        return insuredPersonDob;
    }

    public void setInsuredPersonDob(LocalDate insuredPersonDob) {
        this.insuredPersonDob = insuredPersonDob;
    }

    public LocalDate getPolicyholderDob() {
        return policyholderDob;
    }

    public void setPolicyholderDob(LocalDate policyholderDob) {
        this.policyholderDob = policyholderDob;
    }

    public LocalDate getInceptionDate() {
        return inceptionDate;
    }

    public void setInceptionDate(LocalDate inceptionDate) {
        this.inceptionDate = inceptionDate;
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }
}