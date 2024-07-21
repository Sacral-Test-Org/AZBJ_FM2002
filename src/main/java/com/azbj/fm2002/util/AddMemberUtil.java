package com.azbj.fm2002.util;

public class AddMemberUtil {

    public boolean validateMemberDetails(Object memberDetails) {
        // Assuming memberDetails is a Map for simplicity
        Map<String, Object> details = (Map<String, Object>) memberDetails;
        String relationship = (String) details.get("relationship");
        if (relationship == null || relationship.isEmpty()) {
            return false;
        }
        // Additional validation logic can be added here
        return true;
    }

    public String assignIdentificationNumber(Object memberDetails) {
        Map<String, Object> details = (Map<String, Object>) memberDetails;
        String relationship = (String) details.get("relationship");
        if ("spouse".equalsIgnoreCase(relationship)) {
            return "ID-2";
        } else {
            // Assuming we start from ID-3 for non-spouse members
            return "ID-3";
        }
    }

    public String assignCoverCode(Object memberDetails) {
        Map<String, Object> details = (Map<String, Object>) memberDetails;
        String relationship = (String) details.get("relationship");
        if ("spouse".equalsIgnoreCase(relationship)) {
            return "COVER-SPOUSE";
        } else {
            return "COVER-CHILD";
        }
    }
}
