package com.azbj.fm2002.util;

import com.azbj.fm2002.model.ProductDefinition;

public class HeightValidationUtil {

    public static boolean validateHeight(Double height, ProductDefinition productDefinition, String packageCode, int pensionFlag, String globalLoadingFlag, Double frequencyPremium) {
        // Check if product definition does not match specific product names or codes
        if (productDefinition != null && !isValidProductDefinition(productDefinition)) {
            return false;
        }

        // Ensure package code does not match certain patterns
        if (packageCode != null && isInvalidPackageCode(packageCode)) {
            return false;
        }

        // Verify that the pension flag is set to 0
        if (pensionFlag != 0) {
            return false;
        }

        // If height is not null, further checks
        if (height != null) {
            if (height <= 0) {
                System.out.println("Please Select a Valid Height for the Person");
                return false;
            }

            if (!isValidProductDefinitionForHeight(productDefinition) || isInvalidFlagsForHeight()) {
                return false;
            }
        }

        // If global loading flag is set to 'F', update form status to 'Y'
        if ("F".equals(globalLoadingFlag)) {
            updateFormStatus("Y");
        }

        // If frequency premium is not null, disable certain form properties
        if (frequencyPremium != null) {
            disableFormProperties();
        }

        return true;
    }

    private static boolean isValidProductDefinition(ProductDefinition productDefinition) {
        // Implement logic to check if product definition is valid
        // Placeholder logic
        return true;
    }

    private static boolean isInvalidPackageCode(String packageCode) {
        // Implement logic to check if package code is invalid
        // Placeholder logic
        return false;
    }

    private static boolean isValidProductDefinitionForHeight(ProductDefinition productDefinition) {
        // Implement logic to check if product definition is valid for height
        // Placeholder logic
        return true;
    }

    private static boolean isInvalidFlagsForHeight() {
        // Implement logic to check if certain flags are invalid for height
        // Placeholder logic
        return false;
    }

    private static void updateFormStatus(String status) {
        // Implement logic to update form status
        // Placeholder logic
    }

    private static void disableFormProperties() {
        // Implement logic to disable certain form properties
        // Placeholder logic
    }
}
