package com.azbj.fm2002.dto;

public class AgeCalculationResponse {
    private int determinedAge;
    private String proofType;
    private String fieldValue;

    public AgeCalculationResponse(int determinedAge, String proofType, String fieldValue) {
        this.determinedAge = determinedAge;
        this.proofType = proofType;
        this.fieldValue = fieldValue;
    }

    public int getDeterminedAge() {
        return determinedAge;
    }

    public void setDeterminedAge(int determinedAge) {
        this.determinedAge = determinedAge;
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
