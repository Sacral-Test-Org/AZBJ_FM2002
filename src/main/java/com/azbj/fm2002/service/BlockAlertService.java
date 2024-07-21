package com.azbj.fm2002.service;

import com.azbj.fm2002.dto.BlockAlertValidationRequest;
import com.azbj.fm2002.dto.BlockAlertValidationResponse;
import com.azbj.fm2002.repository.BlockAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BlockAlertService {

    @Autowired
    private BlockAlertRepository blockAlertRepository;

    public BlockAlertValidationResponse validateConditions(BlockAlertValidationRequest request) {
        boolean isValid = blockAlertRepository.findConditions(request);
        BlockAlertValidationResponse response = new BlockAlertValidationResponse();
        response.setValid(isValid);
        return response;
    }

    public void updateStatus(BlockAlertValidationRequest request) {
        blockAlertRepository.updatePolicy(request);
    }

    public boolean validateBackdation(boolean backdationOption, String policyRef, String userId) {
        if (backdationOption) {
            blockAlertRepository.deleteFromAzbjChkBackdation(policyRef);
            blockAlertRepository.insertIntoAzbjChkBackdation(policyRef, "Y", userId, new Date());
        } else {
            blockAlertRepository.insertIntoAzbjChkBackdation(policyRef, "N", userId, new Date());
        }
        return true;
    }

    public String unitlink(String cn_product_id) {
        return blockAlertRepository.getUnitlinkValue(cn_product_id);
    }

    public BlockAlertValidationResponse validateProceedButton(BlockAlertValidationRequest request) {
        BlockAlertValidationResponse response = new BlockAlertValidationResponse();
        boolean isProceedEnabled = false;

        boolean allRadioButtonsValid = request.getRadBackdation().matches("[NY]") &&
                request.getRadioDispatch().matches("[NY]") &&
                request.getRadReceipt().matches("[NY]") &&
                request.getRadPremium().matches("[NY]") &&
                request.getRadRider().matches("[NY]") &&
                request.getRadMob().matches("[NY]");

        boolean proceedButtonControlValid = request.getVProceedBtn().equals("X") ||
                request.getRadExcessPre().matches("[NY]");

        String productType = unitlink(request.getCnProductId());

        if (allRadioButtonsValid && proceedButtonControlValid) {
            if (!productType.equals("Y") && !productType.equals("P")) {
                isProceedEnabled = true;
            } else if (productType.matches("[YP]") && request.getRadFunds().equals("Y")) {
                isProceedEnabled = true;
            }
        }

        response.setProceedEnabled(isProceedEnabled);
        return response;
    }
}
