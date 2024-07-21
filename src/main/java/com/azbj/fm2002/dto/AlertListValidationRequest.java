package com.azbj.fm2002.dto;

public class AlertListValidationRequest {
    private String backdating;
    private String dispatch;
    private String receipt;
    private String premium;
    private String rider;
    private String excessPremium;
    private String mobile;

    // Getters and Setters
    public String getBackdating() {
        return backdating;
    }

    public void setBackdating(String backdating) {
        this.backdating = backdating;
    }

    public String getDispatch() {
        return dispatch;
    }

    public void setDispatch(String dispatch) {
        this.dispatch = dispatch;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getRider() {
        return rider;
    }

    public void setRider(String rider) {
        this.rider = rider;
    }

    public String getExcessPremium() {
        return excessPremium;
    }

    public void setExcessPremium(String excessPremium) {
        this.excessPremium = excessPremium;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}