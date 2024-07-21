package com.azbj.fm2002.dto;

public class PolicyMemberValidationRequest {
    private double weight;
    private double height;

    public PolicyMemberValidationRequest() {}

    public PolicyMemberValidationRequest(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}
