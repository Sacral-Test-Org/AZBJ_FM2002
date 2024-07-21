package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.WNrMedRepository;
import com.azbj.fm2002.model.WNrMed;
import com.azbj.fm2002.model.ReceiptStatus;
import com.azbj.fm2002.model.ProductIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WNrMedService {

    @Autowired
    private WNrMedRepository wNrMedRepository;

    public ProductIdResponse setInsurancePolicyType(int productId) {
        if (productId == 3 || productId == 4 || productId == 5 || productId == 9 || productId == 10) {
            Optional<WNrMed> wNrMedOptional = wNrMedRepository.findByProductId(productId);
            if (wNrMedOptional.isPresent()) {
                WNrMed wNrMed = wNrMedOptional.get();
                wNrMed.setInsurancePolicyType(1);
                wNrMedRepository.save(wNrMed);
                return new ProductIdResponse(productId, 1);
            }
        }
        return new ProductIdResponse(productId, null);
    }

    public void updateReceiptStatus(ReceiptStatus receiptStatus) {
        if (receiptStatus.isHomeVisit()) {
            boolean userConfirmed = promptUserForConfirmation();
            if (!userConfirmed) {
                receiptStatus.setTestConductedFromField(null);
                return;
            }
        }

        if ("Y".equals(receiptStatus.getReceiptStatus())) {
            if (receiptStatus.getReceiptDate() == null) {
                receiptStatus.setReceiptDateToCurrentDate();
            }
            updateSystemVariables(receiptStatus);
        } else if ("N".equals(receiptStatus.getReceiptStatus())) {
            receiptStatus.clearReceiptDate();
            updateSystemVariablesForNoReceipt(receiptStatus);
            setGlobalFlagsToNo();
        }

        if ("Y".equals(receiptStatus.getReceiptStatus())) {
            if (receiptStatus.getReceiptDate() == null) {
                receiptStatus.setReceiptDateToCurrentDate();
            }
        } else if ("N".equals(receiptStatus.getReceiptStatus())) {
            receiptStatus.clearReceiptDate();
            setGlobalFlagsToNo();
        }

        if ("Y".equals(receiptStatus.getReceiptStatus()) || "N".equals(receiptStatus.getReceiptStatus())) {
            updateUserWhoRaisedMedicalRequest(receiptStatus);
        }

        navigateThroughRecords(receiptStatus);

        wNrMedRepository.updateReceiptStatus(receiptStatus);
    }

    private boolean promptUserForConfirmation() {
        // Logic to prompt user for confirmation
        return true; // Assume user confirms for simplicity
    }

    private void updateSystemVariables(ReceiptStatus receiptStatus) {
        // Logic to update system variables
    }

    private void updateSystemVariablesForNoReceipt(ReceiptStatus receiptStatus) {
        // Logic to update system variables for no receipt
    }

    private void setGlobalFlagsToNo() {
        // Logic to set global flags to 'N'
    }

    private void updateUserWhoRaisedMedicalRequest(ReceiptStatus receiptStatus) {
        // Logic to update user who raised the medical request
    }

    private void navigateThroughRecords(ReceiptStatus receiptStatus) {
        if ("Y".equals(receiptStatus.getReceiptStatus()) || "N".equals(receiptStatus.getReceiptStatus())) {
            handleWaivedRequirements();
            deleteCurrentRecord();
        } else {
            moveToNextOrPreviousRecord();
        }
    }

    private void handleWaivedRequirements() {
        // Logic to handle waived requirements
    }

    private void deleteCurrentRecord() {
        // Logic to delete current record
    }

    private void moveToNextOrPreviousRecord() {
        // Logic to move to next or previous record
    }
}
