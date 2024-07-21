package com.azbj.fm2002.dto;

public class PanDetailsDTO {
    private String panNumber;
    private String panStatus;
    private String nameMatch;
    private String dobMatch;

    // Getters and Setters
    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        if (panNumber != null && panNumber.length() <= 100) {
            this.panNumber = panNumber;
        } else {
            throw new IllegalArgumentException("PAN Number must be 100 characters or less");
        }
    }

    public String getPanStatus() {
        return panStatus;
    }

    public void setPanStatus(String panStatus) {
        if (panStatus != null && panStatus.length() <= 2000) {
            this.panStatus = panStatus;
        } else {
            throw new IllegalArgumentException("PAN Status must be 2000 characters or less");
        }
    }

    public String getNameMatch() {
        return nameMatch;
    }

    public void setNameMatch(String nameMatch) {
        if (nameMatch != null && nameMatch.length() <= 2) {
            this.nameMatch = nameMatch;
        } else {
            throw new IllegalArgumentException("Name Match must be 2 characters or less");
        }
    }

    public String getDobMatch() {
        return dobMatch;
    }

    public void setDobMatch(String dobMatch) {
        if (dobMatch != null && dobMatch.length() <= 2) {
            this.dobMatch = dobMatch;
        } else {
            throw new IllegalArgumentException("DOB Match must be 2 characters or less");
        }
    }
}