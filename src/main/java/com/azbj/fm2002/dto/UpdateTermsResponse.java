package com.azbj.fm2002.dto;

public class UpdateTermsResponse {
    private String status;
    private String message;

    public UpdateTermsResponse() {}

    public UpdateTermsResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}