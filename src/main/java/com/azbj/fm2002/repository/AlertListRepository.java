package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.AlertListValidationRequest;
import com.azbj.fm2002.model.AlertListValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AlertListRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AlertListValidationResponse validateOptions(AlertListValidationRequest request) {
        AlertListValidationResponse response = new AlertListValidationResponse();

        // Validate options
        if (!isValidOption(request.getBackdating()) ||
            !isValidOption(request.getDispatch()) ||
            !isValidOption(request.getReceipt()) ||
            !isValidOption(request.getPremium()) ||
            !isValidOption(request.getRider()) ||
            !isValidOption(request.getExcessPremium()) ||
            !isValidOption(request.getMobile())) {
            response.setValid(false);
            return response;
        }

        // Check product ID and funds option
        if (!isProductIdValid(request.getProductId(), request.getFundsOption())) {
            response.setValid(false);
            return response;
        }

        response.setValid(true);
        return response;
    }

    private boolean isValidOption(String option) {
        return "N".equals(option) || "Y".equals(option);
    }

    private boolean isProductIdValid(String productId, String fundsOption) {
        if ("Y".equals(productId) || "P".equals(productId)) {
            return "Y".equals(fundsOption);
        }
        return true;
    }
}
