package com.azbj.fm2002.dto;

public class AmlDetailsDTO {
    private String documentDescription;
    private String documentType;
    private boolean mandatoryFlag;
    private String value;
    private String proofType;
    private String documentId;
    private String expiryDate;
    private String oldPolicyReference;
    private String proofDescription;
    private String documentRemarks;

    // Getters and Setters
    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public boolean isMandatoryFlag() {
        return mandatoryFlag;
    }

    public void setMandatoryFlag(boolean mandatoryFlag) {
        this.mandatoryFlag = mandatoryFlag;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value.toUpperCase();
    }

    public String getProofType() {
        return proofType;
    }

    public void setProofType(String proofType) {
        this.proofType = proofType;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId.toUpperCase();
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOldPolicyReference() {
        return oldPolicyReference;
    }

    public void setOldPolicyReference(String oldPolicyReference) {
        this.oldPolicyReference = oldPolicyReference;
    }

    public String getProofDescription() {
        return proofDescription;
    }

    public void setProofDescription(String proofDescription) {
        this.proofDescription = proofDescription;
    }

    public String getDocumentRemarks() {
        return documentRemarks;
    }

    public void setDocumentRemarks(String documentRemarks) {
        this.documentRemarks = documentRemarks;
    }
}