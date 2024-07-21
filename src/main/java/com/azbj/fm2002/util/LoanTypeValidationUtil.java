package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.LoanTypeValidationRequest;
import com.azbj.fm2002.dto.LoanTypeValidationResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LoanTypeValidationUtil {

    public LoanTypeValidationResponse validateLoanType(LoanTypeValidationRequest request) {
        LoanTypeValidationResponse response = new LoanTypeValidationResponse();
        try {
            // Validate loan type
            if (request.getGlobalLoadingFlag().equals("F")) {
                response.setFormStatus("Y");
            }

            // Calculate Perm_receipt_date
            LocalDate permReceiptDate = request.getReceivedDate() != null ? request.getReceivedDate() : LocalDate.now();
            response.setPermReceiptDate(permReceiptDate);

            // Check booking frequency and product ID
            if ("monthly".equalsIgnoreCase(request.getBookingFrequency()) && request.getProductId() == 10) {
                if (!isValidReceiptDate(permReceiptDate)) {
                    response.setErrorMessage("Invalid receipt date for monthly booking frequency and product ID 10.");
                    return response;
                }
            }

            if ((request.getProductId() == 14 || request.getProductId() == 16) && "01".equals(request.getBookingFrequency())) {
                response.setErrorMessage("Single premium mode is not available for this product.");
                return response;
            }

            // Navigate to the correct field
            if (request.getProductId() == 10 || request.getProductId() == 14 || request.getProductId() == 16) {
                response.setNextField("premiumAmount");
            } else {
                response.setNextField("package");
            }

        } catch (SQLException e) {
            response.setErrorMessage("SQL Error: " + e.getMessage());
        }

        return response;
    }

    private boolean isValidReceiptDate(LocalDate receiptDate) {
        // Define the specific date ranges for validation
        LocalDate startDate = LocalDate.parse("2023-01-01", DateTimeFormatter.ISO_DATE);
        LocalDate endDate = LocalDate.parse("2023-12-31", DateTimeFormatter.ISO_DATE);
        return (receiptDate.isAfter(startDate) || receiptDate.isEqual(startDate)) &&
               (receiptDate.isBefore(endDate) || receiptDate.isEqual(endDate));
    }
}
