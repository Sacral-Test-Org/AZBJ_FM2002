package com.azbj.fm2002.dto;

public class SaveOnlyRequest {
    private String contractId;
    private int ipNo;
    private String coverCode;
    private double sumInsured;
    private String agentCode;

    public SaveOnlyRequest() {}

    public SaveOnlyRequest(String contractId, int ipNo, String coverCode, double sumInsured, String agentCode) {
        this.contractId = contractId;
        this.ipNo = ipNo;
        this.coverCode = coverCode;
        this.sumInsured = sumInsured;
        this.agentCode = agentCode;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public int getIpNo() {
        return ipNo;
    }

    public void setIpNo(int ipNo) {
        this.ipNo = ipNo;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public double getSumInsured() {
        return sumInsured;
    }

    public void setSumInsured(double sumInsured) {
        this.sumInsured = sumInsured;
    }

    public String getAgentCode() {
        return agentCode;
    }

    public void setAgentCode(String agentCode) {
        this.agentCode = agentCode;
    }
}