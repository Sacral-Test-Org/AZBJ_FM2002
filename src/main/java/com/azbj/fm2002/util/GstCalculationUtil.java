package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.GstCalculationRequest;
import com.azbj.fm2002.dto.GstCalculationResponse;
import java.math.BigDecimal;
import java.util.Date;

public class GstCalculationUtil {

    public static GstCalculationResponse calculateGstAmount(String productId, String coverCode, Double premium, Date effectiveDate, String postalCode, Double sumAssured, String eventCode) {
        GstCalculationResponse response = new GstCalculationResponse();
        try {
            // Validate sum assured
            if (sumAssured <= 0) {
                response.setErrorMessage("Sum assured must be greater than zero.");
                return response;
            }

            // Call the GST calculation procedure
            BigDecimal stateGst = new BigDecimal(0);
            BigDecimal centralGst = new BigDecimal(0);
            BigDecimal utGst = new BigDecimal(0);
            BigDecimal integratedGst = new BigDecimal(0);

            // Mocking the procedure call and GST calculation
            // In real scenario, this would be a call to the database procedure
            stateGst = stateGst.add(new BigDecimal(premium * 0.09));
            centralGst = centralGst.add(new BigDecimal(premium * 0.09));
            integratedGst = integratedGst.add(new BigDecimal(premium * 0.18));

            // Calculate total GST
            BigDecimal totalGst = stateGst.add(centralGst).add(utGst).add(integratedGst);

            // Set the response
            response.setStateGst(stateGst);
            response.setCentralGst(centralGst);
            response.setUtGst(utGst);
            response.setIntegratedGst(integratedGst);
            response.setTotalGst(totalGst);
        } catch (Exception e) {
            response.setErrorMessage("Error calculating GST: " + e.getMessage());
        }
        return response;
    }
}
