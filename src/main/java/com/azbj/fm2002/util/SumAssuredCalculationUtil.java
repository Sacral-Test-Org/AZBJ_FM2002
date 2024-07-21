package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.SumAssuredCalculationRequest;
import com.azbj.fm2002.dto.SumAssuredCalculationResponse;
import java.math.BigDecimal;

public class SumAssuredCalculationUtil {

    public static SumAssuredCalculationResponse calculate(SumAssuredCalculationRequest request) {
        BigDecimal sumAssured;
        BigDecimal multiplier = request.getMultiplier();
        BigDecimal premiumAmount = request.getPremiumAmount();
        String bookingFrequency = request.getBookingFrequency();
        int productId = request.getProductId();

        if (productId == 343) {
            if (!"01".equals(bookingFrequency)) {
                BigDecimal bookingFrequencyValue = new BigDecimal(bookingFrequency);
                BigDecimal option1 = multiplier.multiply(premiumAmount).multiply(bookingFrequencyValue);
                BigDecimal option2 = premiumAmount.multiply(bookingFrequencyValue).multiply(new BigDecimal("1.05"));
                sumAssured = option1.max(option2);
            } else {
                BigDecimal option1 = multiplier.multiply(premiumAmount);
                BigDecimal option2 = premiumAmount.multiply(new BigDecimal("1.05"));
                sumAssured = option1.max(option2);
            }
        } else {
            sumAssured = BigDecimal.ZERO;
        }

        if (sumAssured == null) {
            sumAssured = BigDecimal.ZERO;
        }

        sumAssured = sumAssured.setScale(0, BigDecimal.ROUND_HALF_UP);

        SumAssuredCalculationResponse response = new SumAssuredCalculationResponse();
        response.setSumAssured(sumAssured);
        return response;
    }

    public static BigDecimal calculate(BigDecimal gmi) {
        if (gmi == null) {
            throw new IllegalArgumentException("GMI cannot be null");
        }
        return gmi.multiply(new BigDecimal(144)).setScale(0, BigDecimal.ROUND_HALF_UP);
    }
}
