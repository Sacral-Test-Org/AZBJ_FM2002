package com.azbj.fm2002.dto;

public class MailingAddressDTO {
    private String partnerId;
    private String[] addressLines;
    private String country;
    private String postcode;
    private String[] contactNumbers;

    // Getters and Setters
    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String[] getAddressLines() {
        return addressLines;
    }

    public void setAddressLines(String[] addressLines) {
        this.addressLines = addressLines;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String[] getContactNumbers() {
        return contactNumbers;
    }

    public void setContactNumbers(String[] contactNumbers) {
        this.contactNumbers = contactNumbers;
    }
}