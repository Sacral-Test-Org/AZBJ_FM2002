package com.azbj.fm2002.dto;

public class LateralShiftDTO {
    private String insuredPersonId;
    private boolean status;
    private int shiftNumber;
    private String partnerName;
    private String partnerId;
    private String ipNumber;
    private String name;

    // Getters and Setters
    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    public void setInsuredPersonId(String insuredPersonId) {
        this.insuredPersonId = insuredPersonId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getShiftNumber() {
        return shiftNumber;
    }

    public void setShiftNumber(int shiftNumber) {
        this.shiftNumber = shiftNumber;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(String ipNumber) {
        this.ipNumber = ipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}