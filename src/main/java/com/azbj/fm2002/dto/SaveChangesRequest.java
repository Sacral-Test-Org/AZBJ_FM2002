package com.azbj.fm2002.dto;

public class SaveChangesRequest {
    private String formStatus;
    private String contractId;
    private String insuredPersonId;
    private String policyHolderId;
    private String userId;
    private String comments;
    private String medicalTests;
    private String furtherRequirements;
    private String probableCPs;
    private String probableCPsPH;

    // Getters and Setters
    public String getFormStatus() {
        return formStatus;
    }

    public void setFormStatus(String formStatus) {
        this.formStatus = formStatus;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    public void setInsuredPersonId(String insuredPersonId) {
        this.insuredPersonId = insuredPersonId;
    }

    public String getPolicyHolderId() {
        return policyHolderId;
    }

    public void setPolicyHolderId(String policyHolderId) {
        this.policyHolderId = policyHolderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getMedicalTests() {
        return medicalTests;
    }

    public void setMedicalTests(String medicalTests) {
        this.medicalTests = medicalTests;
    }

    public String getFurtherRequirements() {
        return furtherRequirements;
    }

    public void setFurtherRequirements(String furtherRequirements) {
        this.furtherRequirements = furtherRequirements;
    }

    public String getProbableCPs() {
        return probableCPs;
    }

    public void setProbableCPs(String probableCPs) {
        this.probableCPs = probableCPs;
    }

    public String getProbableCPsPH() {
        return probableCPsPH;
    }

    public void setProbableCPsPH(String probableCPsPH) {
        this.probableCPsPH = probableCPsPH;
    }
}