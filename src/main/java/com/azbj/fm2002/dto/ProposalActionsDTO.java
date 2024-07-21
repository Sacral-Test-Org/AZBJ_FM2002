package com.azbj.fm2002.dto;

public class ProposalActionsDTO {
    private Long proposalId;
    private String action;
    private String status;
    private String message;

    public ProposalActionsDTO() {}

    public ProposalActionsDTO(Long proposalId, String action, String status, String message) {
        this.proposalId = proposalId;
        this.action = action;
        this.status = status;
        this.message = message;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
