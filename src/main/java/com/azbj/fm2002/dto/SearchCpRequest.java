package com.azbj.fm2002.dto;

public class SearchCpRequest {
    private String partnerId;

    public SearchCpRequest() {}

    public SearchCpRequest(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}