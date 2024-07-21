package com.azbj.fm2002.util;

import com.azbj.fm2002.entity.PolicyDetailsEntity;
import com.azbj.fm2002.dto.ReinsuranceDetailsDTO;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PolicyDetailsUtil {

    public static BigDecimal calculatePremium(PolicyDetailsEntity policyDetails) {
        // Logic to calculate premium amount
        BigDecimal premiumAmount = policyDetails.getAnnualPremium();
        // Additional calculations can be added here
        return premiumAmount;
    }

    public static LocalDate calculateInceptionDate(PolicyDetailsEntity policyDetails) {
        // Logic to calculate inception date
        LocalDate inceptionDate = policyDetails.getInceptionDate();
        // Additional calculations can be added here
        return inceptionDate;
    }

    public static ReinsuranceDetailsDTO calculateReinsuranceDetails(PolicyDetailsEntity policyDetails) {
        // Logic to calculate reinsurance details
        ReinsuranceDetailsDTO reinsuranceDetails = new ReinsuranceDetailsDTO();
        // Populate reinsuranceDetails based on policyDetails
        reinsuranceDetails.setMlPercentage(policyDetails.getMlPercentage());
        reinsuranceDetails.setOcPercentage(policyDetails.getOcPercentage());
        reinsuranceDetails.setNriPercentage(policyDetails.getNriPercentage());
        reinsuranceDetails.setSrPercentage(policyDetails.getSrPercentage());
        // Additional calculations can be added here
        return reinsuranceDetails;
    }
}
