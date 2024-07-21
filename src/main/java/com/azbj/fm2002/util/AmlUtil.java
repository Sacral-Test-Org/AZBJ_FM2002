package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.AmlValidationRequest;

public class AmlUtil {

    /**
     * Calculates the total premium based on the AML validation request.
     *
     * @param request the AML validation request
     * @return the total premium as a double
     */
    public static double calculateTotalPremium(AmlValidationRequest request) {
        double totalPremium = 0.0;
        if (request != null && request.getPremiums() != null) {
            for (double premium : request.getPremiums()) {
                totalPremium += premium;
            }
        }
        return totalPremium;
    }
}
