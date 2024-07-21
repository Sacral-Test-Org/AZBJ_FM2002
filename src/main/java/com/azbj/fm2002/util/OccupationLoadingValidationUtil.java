package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.OccupationLoadingValidationRequest;
import com.azbj.fm2002.dto.OccupationLoadingValidationResponse;

public class OccupationLoadingValidationUtil {

    public static OccupationLoadingValidationResponse validate(OccupationLoadingValidationRequest request) {
        OccupationLoadingValidationResponse response = new OccupationLoadingValidationResponse();

        String coverCode = request.getCoverCode();
        double occupationLoadingClass = request.getOccupationLoadingClass();
        String calculationType = request.getCalculationType();
        String userId = request.getUserId();

        if (isCoverCodeInGroup1(coverCode) && !isOccupationLoadingClassValidForGroup1(occupationLoadingClass)) {
            response.setMessage("The Occupation loading class can be 1 or 1.5 or 2.0 for this Rider");
        } else if (isCoverCodeInGroup2(coverCode) && !isOccupationLoadingClassValidForGroup2(occupationLoadingClass)) {
            response.setMessage("The Occupation loading class can be 1 or 2 or 3 or 4 for this Rider");
        } else if (isCoverCodeInGroup3(coverCode) && !isOccupationLoadingClassValidForGroup3(occupationLoadingClass)) {
            response.setMessage("The Occupation loading class can be 1 or 2 or 3 for this Rider");
        } else if (occupationLoadingClass == 99.99 && ("D".equals(calculationType) || "AZ".equals(calculationType))) {
            if (!userId.startsWith("P00")) {
                response.setMessage("Hazardous Occupation");
            } else if ("D".equals(calculationType)) {
                response.setMessage("Hazardous Occupation, recommend decline");
            } else if ("AZ".equals(calculationType)) {
                response.setMessage("Hazardous Occupation, refer to Allianz Re");
            }
        }

        return response;
    }

    private static boolean isCoverCodeInGroup1(String coverCode) {
        return "R001A01".equals(coverCode) || "R003A01".equals(coverCode) || "R004A01".equals(coverCode) ||
                "R020A01".equals(coverCode) || "R003B01".equals(coverCode) || "R047A01".equals(coverCode);
    }

    private static boolean isOccupationLoadingClassValidForGroup1(double occupationLoadingClass) {
        return occupationLoadingClass == 1 || occupationLoadingClass == 1.5 || occupationLoadingClass == 2 ||
                occupationLoadingClass == 97 || occupationLoadingClass == 98 || occupationLoadingClass == 99 ||
                occupationLoadingClass == 99.99;
    }

    private static boolean isCoverCodeInGroup2(String coverCode) {
        return coverCode.startsWith("L") || "R002A01".equals(coverCode) || "R006A01".equals(coverCode) || "R006B01".equals(coverCode);
    }

    private static boolean isOccupationLoadingClassValidForGroup2(double occupationLoadingClass) {
        return occupationLoadingClass == 1 || occupationLoadingClass == 2 || occupationLoadingClass == 3 ||
                occupationLoadingClass == 4 || occupationLoadingClass == 97 || occupationLoadingClass == 98 ||
                occupationLoadingClass == 99 || occupationLoadingClass == 99.99;
    }

    private static boolean isCoverCodeInGroup3(String coverCode) {
        return "R005A01".equals(coverCode) || "R021A01".equals(coverCode) || "R046A01".equals(coverCode);
    }

    private static boolean isOccupationLoadingClassValidForGroup3(double occupationLoadingClass) {
        return occupationLoadingClass == 1 || occupationLoadingClass == 2 || occupationLoadingClass == 3 ||
                occupationLoadingClass == 97 || occupationLoadingClass == 98 || occupationLoadingClass == 99 ||
                occupationLoadingClass == 99.99;
    }
}