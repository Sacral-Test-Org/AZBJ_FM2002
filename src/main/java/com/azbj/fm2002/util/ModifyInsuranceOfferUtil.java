package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.ModifyInsuranceOfferRequest;
import java.util.HashMap;
import java.util.Map;

public class ModifyInsuranceOfferUtil {

    public static Map<String, Double> calculateLoadingPercentages(ModifyInsuranceOfferRequest offerDetails) {
        Map<String, Double> loadingPercentages = new HashMap<>();
        double medicalLoading = calculateMedicalLoading(offerDetails);
        double occupationLoading = calculateOccupationLoading(offerDetails);
        double specialLoading = calculateSpecialLoading(offerDetails);
        double residentialLoading = calculateResidentialLoading(offerDetails);

        loadingPercentages.put("medical", medicalLoading);
        loadingPercentages.put("occupation", occupationLoading);
        loadingPercentages.put("special", specialLoading);
        loadingPercentages.put("residential", residentialLoading);

        return loadingPercentages;
    }

    private static double calculateMedicalLoading(ModifyInsuranceOfferRequest offerDetails) {
        // Logic to calculate medical loading based on offerDetails
        return 0.0; // Placeholder value
    }

    private static double calculateOccupationLoading(ModifyInsuranceOfferRequest offerDetails) {
        // Logic to calculate occupation loading based on offerDetails
        return 0.0; // Placeholder value
    }

    private static double calculateSpecialLoading(ModifyInsuranceOfferRequest offerDetails) {
        // Logic to calculate special loading based on offerDetails
        return 0.0; // Placeholder value
    }

    private static double calculateResidentialLoading(ModifyInsuranceOfferRequest offerDetails) {
        // Logic to calculate residential loading based on offerDetails
        return 0.0; // Placeholder value
    }
}
