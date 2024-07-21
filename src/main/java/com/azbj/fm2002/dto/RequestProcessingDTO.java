package com.azbj.fm2002.dto;

public class RequestProcessingDTO {
    private String requestType;
    private String testNumber;
    private String description;
    private String dateCalled;
    private String raisedBy;
    private String requestCalled;
    private Integer insuredPersonType;

    // Getters and Setters
    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getTestNumber() {
        return testNumber;
    }

    public void setTestNumber(String testNumber) {
        this.testNumber = testNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateCalled() {
        return dateCalled;
    }

    public void setDateCalled(String dateCalled) {
        this.dateCalled = dateCalled;
    }

    public String getRaisedBy() {
        return raisedBy;
    }

    public void setRaisedBy(String raisedBy) {
        this.raisedBy = raisedBy;
    }

    public String getRequestCalled() {
        return requestCalled;
    }

    public void setRequestCalled(String requestCalled) {
        this.requestCalled = requestCalled;
    }

    public Integer getInsuredPersonType() {
        return insuredPersonType;
    }

    public void setInsuredPersonType(Integer insuredPersonType) {
        this.insuredPersonType = insuredPersonType;
    }
}