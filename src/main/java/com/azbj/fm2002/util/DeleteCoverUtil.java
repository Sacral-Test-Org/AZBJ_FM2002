package com.azbj.fm2002.util;

import java.util.List;
import java.util.Map;

public class DeleteCoverUtil {

    public boolean validateDeleteCover(String coverId, List<Map<String, Object>> covers, int productId) {
        boolean isValid = true;
        boolean hasRiderR001A01 = false;
        boolean hasRiderR005A01 = false;
        boolean hasRiderR004A01 = false;
        boolean hasRiderR008A01 = false;
        boolean hasRiderR036A01 = false;
        boolean hasRiderR036B01 = false;
        boolean hasRiderR035A01 = false;
        int entryAge = 0;

        for (Map<String, Object> cover : covers) {
            String coverCode = (String) cover.get("coverCode");
            boolean markedForDeletion = (boolean) cover.get("markedForDeletion");
            int sumInsured = (int) cover.get("sumInsured");

            if (coverCode.startsWith("R") && productId == 4 && markedForDeletion) {
                System.out.println("Error: The selected riders are compulsory with the selected package.");
                isValid = false;
            }

            if (coverCode.startsWith("L")) {
                entryAge = (int) cover.get("entryAge");
            }

            switch (coverCode) {
                case "R001A01":
                    hasRiderR001A01 = true;
                    break;
                case "R004A01":
                    hasRiderR004A01 = true;
                    break;
                case "R005A01":
                    hasRiderR005A01 = true;
                    break;
                case "R008A01":
                    hasRiderR008A01 = true;
                    break;
                case "R036A01":
                    hasRiderR036A01 = true;
                    break;
                case "R036B01":
                    hasRiderR036B01 = true;
                    break;
                case "R035A01":
                    hasRiderR035A01 = true;
                    break;
            }

            if (coverCode.startsWith("T") && sumInsured == 0) {
                cover.put("markedForDeletion", true);
            }
        }

        if (hasRiderR001A01 && !hasRiderR005A01) {
            System.out.println("Error: Rider R001A01 must be accompanied by Rider R005A01.");
            isValid = false;
        }

        if (hasRiderR005A01 && !hasRiderR001A01) {
            System.out.println("Error: Rider R005A01 must be accompanied by Rider R001A01.");
            isValid = false;
        }

        for (Map<String, Object> cover : covers) {
            if ((boolean) cover.get("markedForDeletion")) {
                // Apply deletion logic here
            }
        }

        if (productId == 315) {
            for (Map<String, Object> cover : covers) {
                if (coverId.equals(cover.get("coverId")) && (boolean) cover.get("hasPolicyMembers")) {
                    System.out.println("Error: Cannot delete cover with existing policy members.");
                    isValid = false;
                }
            }
        }

        // Disable commit and exit buttons
        disableCommitAndExitButtons();

        return isValid;
    }

    private void disableCommitAndExitButtons() {
        // Logic to disable commit and exit buttons
    }
}
