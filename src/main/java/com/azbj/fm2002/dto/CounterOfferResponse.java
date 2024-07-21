package com.azbj.fm2002.dto;

public class CounterOfferResponse {
    private String status;
    private String message;

    public CounterOfferResponse() {}

    public CounterOfferResponse(String status, String message) {
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
