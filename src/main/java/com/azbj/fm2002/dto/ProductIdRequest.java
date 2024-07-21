package com.azbj.fm2002.dto;

public class ProductIdRequest {
    private int productId;

    public ProductIdRequest() {}

    public ProductIdRequest(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}