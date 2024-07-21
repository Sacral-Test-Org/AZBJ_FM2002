package com.azbj.fm2002.dto;

public class ImageTransferRequest {
    private String proposalNumber;
    private String imageName;

    public ImageTransferRequest() {}

    public ImageTransferRequest(String proposalNumber, String imageName) {
        this.proposalNumber = proposalNumber;
        this.imageName = imageName;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
