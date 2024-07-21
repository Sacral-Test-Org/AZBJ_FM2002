package com.azbj.fm2002.dto;

import java.util.Date;

public class SurrogateProofDetailsDTO {
    private String surrogateProofType;
    private String proofDescription;
    private String fieldValue;
    private Date documentDate;
    private double derivedIncome;
    private double derivedTasaValue;

    // Getters and Setters
    public String getSurrogateProofType() {
        return surrogateProofType;
    }

    public void setSurrogateProofType(String surrogateProofType) {
        this.surrogateProofType = surrogateProofType;
    }

    public String getProofDescription() {
        return proofDescription;
    }

    public void setProofDescription(String proofDescription) {
        this.proofDescription = proofDescription;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }

    public double getDerivedIncome() {
        return derivedIncome;
    }

    public void setDerivedIncome(double derivedIncome) {
        this.derivedIncome = derivedIncome;
    }

    public double getDerivedTasaValue() {
        return derivedTasaValue;
    }

    public void setDerivedTasaValue(double derivedTasaValue) {
        this.derivedTasaValue = derivedTasaValue;
    }
}