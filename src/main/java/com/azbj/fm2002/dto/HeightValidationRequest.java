package com.azbj.fm2002.dto;

public class HeightValidationRequest {
    private Double height;

    public HeightValidationRequest() {}

    public HeightValidationRequest(Double height) {
        this.height = height;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}