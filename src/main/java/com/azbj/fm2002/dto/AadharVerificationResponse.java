package com.azbj.fm2002.dto;

public class AadharVerificationResponse {
    private boolean isValid;
    private String message;
    private AadharDetails aadharDetails;

    public AadharVerificationResponse() {}

    public AadharVerificationResponse(boolean isValid, String message, AadharDetails aadharDetails) {
        this.isValid = isValid;
        this.message = message;
        this.aadharDetails = aadharDetails;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AadharDetails getAadharDetails() {
        return aadharDetails;
    }

    public void setAadharDetails(AadharDetails aadharDetails) {
        this.aadharDetails = aadharDetails;
    }
}

class AadharDetails {
    private String aadharNumber;
    private String firstName;
    private String lastName;
    private String dateOfBirth;

    public AadharDetails() {}

    public AadharDetails(String aadharNumber, String firstName, String lastName, String dateOfBirth) {
        this.aadharNumber = aadharNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}