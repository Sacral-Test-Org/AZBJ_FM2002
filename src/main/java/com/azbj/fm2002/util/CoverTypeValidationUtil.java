package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.CoverTypeValidationRequest;
import com.azbj.fm2002.dto.CoverTypeValidationResponse;
import com.azbj.fm2002.dto.NavigationErrorRequest;
import com.azbj.fm2002.dto.NavigationErrorResponse;

public class CoverTypeValidationUtil {

    public CoverTypeValidationResponse validate(CoverTypeValidationRequest request) {
        CoverTypeValidationResponse response = new CoverTypeValidationResponse();
        if (!request.isLoading()) {
            response.setFormStatus("Y");
        }
        return response;
    }

    public NavigationErrorResponse handleErrors(NavigationErrorRequest request) {
        NavigationErrorResponse response = new NavigationErrorResponse();
        if ("monthly".equals(request.getBookingFrequency()) && request.getProductId() == 10) {
            if (!isValidReceiptDate(request.getReceiptDate())) {
                response.setErrorMessage("Invalid receipt date.");
            }
        } else if ((request.getProductId() == 14 || request.getProductId() == 16) && "01".equals(request.getBookingFrequency())) {
            response.setErrorMessage("Single premium mode is not available for this product.");
        } else if (isUnitLinkedProduct(request.getProductType()) || "INVESTPLUS".equals(request.getProductType()) || "INVESTPLUS_PREM".equals(request.getProductType())) {
            response.setNextFocusField("premiumAmount");
        } else {
            response.setNextFocusField("package");
        }
        return response;
    }

    private boolean isValidReceiptDate(String receiptDate) {
        // Implement the logic to validate the receipt date
        return true; // Placeholder
    }

    private boolean isUnitLinkedProduct(String productType) {
        // Implement the logic to check if the product is unit-linked
        return "unit-linked".equals(productType); // Placeholder
    }
}
