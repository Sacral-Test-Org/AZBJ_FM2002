package com.azbj.fm2002.dto;

public class RejectedApplicationReasonDTO {
    private String reason;

    public RejectedApplicationReasonDTO() {}

    public RejectedApplicationReasonDTO(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}