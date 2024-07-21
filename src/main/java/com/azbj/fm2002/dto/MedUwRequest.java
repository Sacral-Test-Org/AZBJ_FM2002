package com.azbj.fm2002.dto;

import java.util.Date;

public class MedUwRequest {
    private String contractId;
    private String policyReference;
    private String eventNumber;
    private String testCode;
    private String description;
    private String ipType;
    private Date dateCalled;

    // Getters and Setters
    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPolicyReference() {
        return policyReference;
    }

    public void setPolicyReference(String policyReference) {
        this.policyReference = policyReference;
    }

    public String getEventNumber() {
        return eventNumber;
    }

    public void setEventNumber(String eventNumber) {
        this.eventNumber = eventNumber;
    }

    public String getTestCode() {
        return testCode;
    }

    public void setTestCode(String testCode) {
        this.testCode = testCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIpType() {
        return ipType;
    }

    public void setIpType(String ipType) {
        this.ipType = ipType;
    }

    public Date getDateCalled() {
        return dateCalled;
    }

    public void setDateCalled(Date dateCalled) {
        this.dateCalled = dateCalled;
    }
}