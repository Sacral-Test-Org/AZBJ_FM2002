package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.BlockAlertValidationRequest;
import com.azbj.fm2002.dto.BlockAlertValidationResponse;

public class BlockAlertValidationUtil {

    public BlockAlertValidationResponse validateConditions(BlockAlertValidationRequest request) {
        BlockAlertValidationResponse response = new BlockAlertValidationResponse();

        boolean proceedEnabled = false;

        // Check if all radio buttons are either 'N' or 'Y'
        boolean allRadioButtonsValid = request.getRadBackdating().matches("[NY]") &&
                request.getRadDispatch().matches("[NY]") &&
                request.getRadReceipt().matches("[NY]") &&
                request.getRadPremium().matches("[NY]") &&
                request.getRadRider().matches("[NY]") &&
                request.getRadMobile().matches("[NY]");

        // Check if proceed button control is 'X' or excess premium radio button is 'N' or 'Y'
        boolean proceedButtonControlValid = request.getVProceedBtn().equals("X") ||
                request.getRadExcessPremium().matches("[NY]");

        // Check if product ID is not linked to 'Y' or 'P'
        boolean productIdNotLinked = !request.getProductId().matches("[YP]");

        // Check if product ID is linked to 'Y' or 'P' and funds radio button is 'Y'
        boolean productIdLinkedAndFundsValid = request.getProductId().matches("[YP]") &&
                request.getRadFunds().equals("Y");

        // Determine if the proceed button should be enabled
        if (allRadioButtonsValid && proceedButtonControlValid && (productIdNotLinked || productIdLinkedAndFundsValid)) {
            proceedEnabled = true;
        }

        response.setProceedEnabled(proceedEnabled);

        // Handle focus and navigation based on funds radio button
        if (request.getRadFunds().equals("Y")) {
            response.setFocusField("radMobile");
        } else {
            response.setClearBlock(true);
            response.setAction("W");
            response.setNavigateToTab("insuredPerson");
            response.setHideAlertListWindow(true);
        }

        return response;
    }
}
