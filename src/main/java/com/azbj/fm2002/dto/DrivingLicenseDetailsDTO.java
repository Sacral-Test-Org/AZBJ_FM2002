package com.azbj.fm2002.dto;

import java.util.Date;

public class DrivingLicenseDetailsDTO {
    private String drivingLicenseNumber;
    private Date dateOfBirth;

    public DrivingLicenseDetailsDTO() {}

    public DrivingLicenseDetailsDTO(String drivingLicenseNumber, Date dateOfBirth) {
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.dateOfBirth = dateOfBirth;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
