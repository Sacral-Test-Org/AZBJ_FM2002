package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.PartnerDetailsDTO;

public class PartnerDetailsUtil {

    public static boolean validatePartnerDetails(PartnerDetailsDTO partnerDetails) {
        if (partnerDetails == null) {
            return false;
        }
        if (partnerDetails.getPartnerName() == null || partnerDetails.getPartnerName().isEmpty()) {
            return false;
        }
        if (partnerDetails.getDoctorCode() == null || partnerDetails.getDoctorCode().isEmpty()) {
            return false;
        }
        if (partnerDetails.getApplicationNumber() == null || partnerDetails.getApplicationNumber().isEmpty()) {
            return false;
        }
        return true;
    }
}
