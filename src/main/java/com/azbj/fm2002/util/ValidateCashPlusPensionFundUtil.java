package com.azbj.fm2002.util;

public class ValidateCashPlusPensionFundUtil {

    public static boolean validateApportionment(int productId, String fundId, double apportionmentPercentage) {
        int[] validProductIds = {31, 32, 33, 34, 49, 50};
        boolean isValidProductId = false;
        for (int id : validProductIds) {
            if (id == productId) {
                isValidProductId = true;
                break;
            }
        }

        if (isValidProductId && "NCPPF".equals(fundId)) {
            if (apportionmentPercentage > 20) {
                System.out.println("Apportionment for Cash Plus Pension Fund cannot be more than 20");
                return false;
            }
        }

        // Update form status to 'Y' after validation
        // Assuming there's a form status object or method to update the status
        // formStatus.setStatus('Y');
        // For now, we just print it
        System.out.println("Form status updated to 'Y'");
        return true;
    }
}
