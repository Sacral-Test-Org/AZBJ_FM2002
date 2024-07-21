package com.azbj.fm2002.dto;

public class PolicyMemberLoadingDetailsDTO {
    private String ipNumber;
    private String name;
    private String partId;
    private String relation;
    private String coverCode;
    private String coverDescription;

    // Getters and Setters
    public String getIpNumber() {
        return ipNumber;
    }

    public void setIpNumber(String ipNumber) {
        this.ipNumber = ipNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartId() {
        return partId;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getCoverCode() {
        return coverCode;
    }

    public void setCoverCode(String coverCode) {
        this.coverCode = coverCode;
    }

    public String getCoverDescription() {
        return coverDescription;
    }

    public void setCoverDescription(String coverDescription) {
        this.coverDescription = coverDescription;
    }
}