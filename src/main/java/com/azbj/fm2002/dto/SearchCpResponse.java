package com.azbj.fm2002.dto;

public class SearchCpResponse {
    private Object partnerDetails;

    public SearchCpResponse() {}

    public SearchCpResponse(Object partnerDetails) {
        this.partnerDetails = partnerDetails;
    }

    public Object getPartnerDetails() {
        return partnerDetails;
    }

    public void setPartnerDetails(Object partnerDetails) {
        this.partnerDetails = partnerDetails;
    }
}