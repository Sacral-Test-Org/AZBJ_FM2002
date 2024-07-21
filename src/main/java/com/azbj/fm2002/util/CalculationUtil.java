package com.azbj.fm2002.util;

import java.math.BigDecimal;
import java.util.Date;
import com.azbj.fm2002.dto.PremiumCalculationRequest;
import com.azbj.fm2002.dto.PremiumCalculationResponse;
import com.azbj.fm2002.dto.SumAssuredCalculationRequest;
import com.azbj.fm2002.dto.SumAssuredCalculationResponse;

public class CalculationUtil {

    public static BigDecimal calculateStandardPremium(BigDecimal basePremium, BigDecimal multiplier) {
        return basePremium.multiply(multiplier);
    }

    public static BigDecimal calculateFrequencyPremium(BigDecimal standardPremium, String bookingFrequency) {
        BigDecimal frequencyMultiplier;
        switch (bookingFrequency) {
            case "01":
                frequencyMultiplier = BigDecimal.ONE;
                break;
            case "02":
                frequencyMultiplier = new BigDecimal("0.5");
                break;
            case "04":
                frequencyMultiplier = new BigDecimal("0.25");
                break;
            case "12":
                frequencyMultiplier = new BigDecimal("0.0833");
                break;
            default:
                throw new IllegalArgumentException("Invalid booking frequency");
        }
        return standardPremium.multiply(frequencyMultiplier);
    }

    public static int calculateAge(Date dateOfBirth, Date inceptionDate, Date effectiveDate) {
        Date referenceDate = (effectiveDate != null) ? effectiveDate : inceptionDate;
        long ageInMillis = referenceDate.getTime() - dateOfBirth.getTime();
        return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
    }

    public static Integer calculateSpecialCases(int productId, int benefitTerm) {
        if (productId == 281) {
            return benefitTerm;
        } else if (productId == 11) {
            return 18 - benefitTerm;
        } else {
            return benefitTerm;
        }
    }

    public static PremiumCalculationResponse calculatePremium(PremiumCalculationRequest request) {
        BigDecimal standardPremium = calculateStandardPremium(request.getBasePremium(), request.getMultiplier());
        BigDecimal frequencyPremium = calculateFrequencyPremium(standardPremium, request.getBookingFrequency());
        BigDecimal totalPremium = frequencyPremium.add(request.getAdditionalCharges());
        return new PremiumCalculationResponse(totalPremium);
    }

    public static SumAssuredCalculationResponse calculateSumAssured(SumAssuredCalculationRequest request) {
        BigDecimal sumAssured;
        if ("01".equals(request.getBookingFrequency())) {
            sumAssured = request.getMultiplier().multiply(request.getPremiumAmount());
        } else {
            sumAssured = request.getMultiplier().multiply(request.getPremiumAmount()).multiply(new BigDecimal(request.getBookingFrequency()));
        }
        sumAssured = sumAssured.max(request.getPremiumAmount().multiply(new BigDecimal("1.05")));
        return new SumAssuredCalculationResponse(sumAssured.setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public static int calculateEntryAge(Date dateOfBirth, Date inceptionDate) {
        long ageInMillis = inceptionDate.getTime() - dateOfBirth.getTime();
        return (int) (ageInMillis / (1000L * 60 * 60 * 24 * 365));
    }

    public static boolean validatePremiumTerm(int premiumTerm) {
        return premiumTerm > 0;
    }

    public static boolean validateBenefitTerm(int benefitTerm) {
        return benefitTerm > 0;
    }

    public static int calculateBenefitTerm(int entryAge, Date packageMaturityDate) {
        long termInMillis = packageMaturityDate.getTime() - entryAge * 1000L * 60 * 60 * 24 * 365;
        return (int) (termInMillis / (1000L * 60 * 60 * 24 * 365));
    }

    public static int calculatePremiumTerm(int entryAge) {
        return 18 - entryAge;
    }

    public static BigDecimal calculatePremiumAmount(BigDecimal sumAssured, String bookingFrequency, String productId) {
        BigDecimal premiumAmount;
        if ("01".equals(bookingFrequency)) {
            premiumAmount = sumAssured.multiply(new BigDecimal("0.01"));
        } else {
            premiumAmount = sumAssured.multiply(new BigDecimal(bookingFrequency)).multiply(new BigDecimal("0.01"));
        }
        return premiumAmount.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal calculateServiceTax(BigDecimal premiumAmount) {
        return premiumAmount.multiply(new BigDecimal("0.18"));
    }

    public static BigDecimal calculateGST(BigDecimal premiumAmount) {
        return premiumAmount.multiply(new BigDecimal("0.18"));
    }
}
