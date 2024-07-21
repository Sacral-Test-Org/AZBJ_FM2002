package com.azbj.fm2002.dto;

public class IncompleteProposalDetailsDTO {
    private Long id;
    private String proposalFormField;
    private String comments;
    private String detailsReceived;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProposalFormField() {
        return proposalFormField;
    }

    public void setProposalFormField(String proposalFormField) {
        this.proposalFormField = proposalFormField;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getDetailsReceived() {
        return detailsReceived;
    }

    public void setDetailsReceived(String detailsReceived) {
        this.detailsReceived = detailsReceived;
    }
}