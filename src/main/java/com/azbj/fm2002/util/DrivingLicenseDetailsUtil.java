package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.DrivingLicenseDetailsDTO;

public class DrivingLicenseDetailsUtil {

    public boolean validateDrivingLicenseDetails(DrivingLicenseDetailsDTO details) {
        if (details == null) {
            return false;
        }

        boolean insuredPersonValid = validatePerson(details.getInsuredPersonLicenseNumber(), details.getInsuredPersonDob());
        boolean policyHolderValid = validatePerson(details.getPolicyHolderLicenseNumber(), details.getPolicyHolderDob());

        return insuredPersonValid || policyHolderValid;
    }

    private boolean validatePerson(String licenseNumber, String dob) {
        if (licenseNumber == null || licenseNumber.isEmpty()) {
            return false;
        }
        if (dob == null || dob.isEmpty()) {
            return false;
        }
        // Additional validation logic can be added here
        return true;
    }
}
