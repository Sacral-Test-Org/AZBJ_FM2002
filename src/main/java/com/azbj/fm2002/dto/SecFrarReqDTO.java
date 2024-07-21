package com.azbj.fm2002.dto;

public class SecFrarReqDTO {
    private int serialNumber;
    private int requestNumber;
    private String description;
    private String life;
    private String uwReason;
    private String uwReasonDisplay;
    private String supervisorId;
    private String password;
    private String supervisorComments;

    // Getters and Setters
    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(int requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLife() {
        return life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getUwReason() {
        return uwReason;
    }

    public void setUwReason(String uwReason) {
        this.uwReason = uwReason;
    }

    public String getUwReasonDisplay() {
        return uwReasonDisplay;
    }

    public void setUwReasonDisplay(String uwReasonDisplay) {
        this.uwReasonDisplay = uwReasonDisplay;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSupervisorComments() {
        return supervisorComments;
    }

    public void setSupervisorComments(String supervisorComments) {
        this.supervisorComments = supervisorComments;
    }
}