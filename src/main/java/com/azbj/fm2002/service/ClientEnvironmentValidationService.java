package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ClientEnvironmentValidationRepository;
import com.azbj.fm2002.dto.ValidationRequest;
import com.azbj.fm2002.dto.ValidationResponse;
import com.azbj.fm2002.dto.SaveOnlyRequest;
import com.azbj.fm2002.dto.SaveOnlyResponse;
import com.azbj.fm2002.dto.ManualCasePushDTO;
import com.azbj.fm2002.exception.ValidationException;
import com.azbj.fm2002.exception.SaveOnlyException;
import com.azbj.fm2002.util.SaveOnlyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientEnvironmentValidationService {

    @Autowired
    private ClientEnvironmentValidationRepository repository;

    public boolean validatePartnerReferences() {
        return repository.validatePartnerReferences();
    }

    public ValidationResponse validatePolicy(ValidationRequest request) throws ValidationException {
        try {
            // Suppress non-critical messages
            ValidationUtil.suppressNonCriticalMessages();

            // Execute validation procedure
            ValidationResponse response = repository.validate(request);

            // Restore message levels
            ValidationUtil.restoreMessageLevels();

            // Check validation results
            if (response.isValid() && "T".equals(request.getControlValue()) && request.getResultField() != null) {
                response.setSpecificItemDisabled(true);
            }

            return response;
        } catch (Exception e) {
            throw new ValidationException("Error during policy validation", e);
        }
    }

    public SaveOnlyResponse saveOnly(SaveOnlyRequest request) throws SaveOnlyException {
        try {
            // Check entries in azbj_ip_ext and wip_azbj_ip_ext tables
            int count1 = repository.checkEntries(request.getContractId(), 1);
            int count2 = repository.checkEntries(request.getContractId(), 2);

            if (count1 == 0 || count2 == 0) {
                SaveOnlyUtil.logError("Contract ID: " + request.getContractId() + " - Policy status: Not found");
            } else {
                SaveOnlyUtil.logError("Contract ID: " + request.getContractId() + " - Policy status: Found");
            }

            // Execute procedures based on flags
            if ("Y".equals(request.getIncmpPrpDtlsSaveFlg())) {
                repository.executeIncmpfSaveDtls();
            }
            if ("Y".equals(request.getSaveBtnFlag())) {
                repository.executeSaveDuplContactNoDtls();
            }

            // Update or insert records in azbj_policy_covers_risk_sa table
            repository.updateOrInsertPolicyCovers(request.getContractId(), request.getCoverCode(), request.getSumInsured());

            // Check for preferred IC entries and update or insert records in AZBJ_MEDUW_PREFERED_IC table
            repository.updateOrInsertPreferredIC(request.getAgentCode());

            // Commit transaction
            repository.commitTransaction();

            // Log user action
            SaveOnlyUtil.logUserAction("UPDATE", "SAVE-ONLY");

            return new SaveOnlyResponse("Success");
        } catch (Exception e) {
            throw new SaveOnlyException("Error during save only operation", e);
        }
    }

    public ValidationResponse validatePolicy(ValidationRequest request) throws ValidationException {
        try {
            // Reset variable
            int v_covers_call = 0;

            // Perform preliminary claim validation
            repository.performPreliminaryClaimValidation(request);

            // Check application number in azbj_application_bypass_det table
            List<AzbjApplicationBypassDet> bypassDetList = repository.findByApplicationNumberAndBypassFlagAndBypassModule(request.getApplicationNumber(), "Y", "AADHAR_CARD_BYPASS");

            if (!bypassDetList.isEmpty()) {
                // Further checks
                long count = repository.countByApplicationNumberAndPanIssuanceDateNot(request.getApplicationNumber(), request.getPanIssuanceDate());
                if (count >= 0) {
                    repository.performPanVerification(request);
                }
            }

            // Additional validations
            if (request.getPersonSubIcCode() != null && request.getPersonSubIcCode().matches("some pattern") && !request.getProductId().matches("some list")) {
                throw new ValidationException("POSP is not allowed to log in for this product");
            }

            if ("Y".equals(request.getSuspectedCaseFlag()) && "N".equals(request.getSuspectedScreenFlag())) {
                throw new ValidationException("Select the dropdown list for name and DOB matching on the suspected CP search screen");
            }

            if (request.getAgentSubCode() == null && !request.getAgentCode().matches("some pattern")) {
                throw new ValidationException("Lead By is mandatory for the channel");
            }

            if (request.getReferralId() == null && !request.getAgentCode().matches("some pattern")) {
                throw new ValidationException("Bank/Referral ID is mandatory for the channel");
            }

            if ("UPI_M".equals(request.getMethodOfPayment()) && request.getPremiumAmount() <= 5000) {
                request.setMethodOfPaymentDisabled(true);
            }

            if (request.getAgentBiNumber() != null && request.getProductId().matches("some values")) {
                request.setPremiumTerm("some value");
                request.setBenefitTerm("some value");
            }

            if (request.getProductId().matches("some values") && request.getPremiumTerm() != null) {
                request.setPremiumTermDisabled(true);
            }

            if ("S".equals(request.getMethodOfPayment())) {
                request.setMethodOfPaymentDisabled(true);
            }

            return new ValidationResponse("Success");
        } catch (Exception e) {
            throw new ValidationException("Error during policy validation", e);
        }
    }

    public ManualCasePushDTO checkTransactionsAndRetrieveMessages(String applicationNumber) throws ValidationException {
        try {
            // Check for existing transactions
            int count = repository.checkExistingTransactions(applicationNumber);

            if (count > 0) {
                // Retrieve messages
                List<ManualCasePushDTO> messages = repository.retrieveMessages(applicationNumber);
                return messages;
            } else {
                throw new ValidationException("No Details available for this case");
            }
        } catch (Exception e) {
            throw new ValidationException("Error during transaction check and message retrieval", e);
        }
    }
}
