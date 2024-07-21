package com.azbj.fm2002.dto;

public class PanValidationRequest {
    private String panCard;
    private String proposalType;

    public PanValidationRequest() {}

    public PanValidationRequest(String panCard, String proposalType) {
        this.panCard = panCard;
        this.proposalType = proposalType;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getProposalType() {
        return proposalType;
    }

    public void setProposalType(String proposalType) {
        this.proposalType = proposalType;
    }
}
