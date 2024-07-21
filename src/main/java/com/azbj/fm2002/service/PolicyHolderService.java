package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.PolicyHolderRepository;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.util.AgeCalculationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyHolderService {

    @Autowired
    private PolicyHolderRepository policyHolderRepository;

    public List<ProposalType> fetchProposalTypes() {
        return policyHolderRepository.findAllProposalTypes();
    }

    public String validateAgeProof(String ageProof) {
        try {
            return policyHolderRepository.findAgeUidByAgeProof(ageProof);
        } catch (NoDataFoundException e) {
            return "NA1";
        } catch (Exception e) {
            return "NA2";
        }
    }

    public String updateFormStatus(String formStatus) {
        int result = policyHolderRepository.updateFormStatus(formStatus);
        return result > 0 ? "Success" : "Failure";
    }

    public void updatePolicyHolderDetails(PolicyHolder policyHolder) {
        policyHolderRepository.save(policyHolder);
    }

    public void clearPolicyHolderDetails(PolicyHolder policyHolder) {
        policyHolderRepository.delete(policyHolder);
    }

    public boolean validateAccountNumber(String accountNumber) {
        return accountNumber != null && accountNumber.length() == 16;
    }

    public boolean validatePaCode(String paCode) {
        return policyHolderRepository.validatePaCode(paCode);
    }

    public boolean validatePanIssuanceDate(String panIssuanceDate) {
        return panIssuanceDate.compareTo(java.time.LocalDate.now().toString()) <= 0;
    }

    public MailingAddressDTO fetchMailingAddress(String partnerId) {
        return policyHolderRepository.findMailingAddress(partnerId);
    }

    public PaymentMethodValidationResponse validatePaymentMethod(PaymentMethodValidationRequest request) {
        return policyHolderRepository.validatePaymentMethod(request);
    }

    public BankAccountDetails getBankAccountDetails(String applicationNumber) {
        return policyHolderRepository.getBankAccountDetails(applicationNumber);
    }

    public VerificationStatus getVerificationStatus(String applicationNumber) {
        return policyHolderRepository.getVerificationStatus(applicationNumber);
    }

    public ValidationResponse validate(String ageProofType, String ageProofID, String agentCode) {
        ValidationResponse response = new ValidationResponse();
        if ("AC".equals(ageProofType) || "ACS".equals(ageProofType)) {
            if (ageProofID.length() == 12) {
                // Extract first name and last name from policy holder's name
                String firstName = "John"; // Placeholder
                String lastName = "Doe"; // Placeholder
                // Format date of birth
                String dob = "1990-01-01"; // Placeholder
                // Validate Aadhaar details
                String validatedDetails = "Validated"; // Placeholder
                policyHolderRepository.updateAgeProofDetails(ageProofID, validatedDetails);
                response.setMessage("Aadhaar validated");
            }
        } else if ("SYBM".equals(ageProofType) && !agentCode.startsWith("522")) {
            response.setMessage("Syndicate Bank BM Certificate is allowed only for Syndicate Bank");
        } else if ("Pan Card".equals(ageProofType) && ageProofID != null) {
            policyHolderRepository.updateAgeProofDetails(ageProofID, "Y");
            response.setMessage("PAN Card validated");
        }
        return response;
    }

    public PassportDetailsDTO fetchPassportDetails() {
        return policyHolderRepository.findPassportDetails();
    }

    public void verifyVoterId() {
        String applicationNumber = policyHolderRepository.getApplicationNumber("signCardNumber");
        String ageProof = policyHolderRepository.getAgeProof("insuredPersonId");
        if ("VI".equals(ageProof)) {
            String state = policyHolderRepository.getStateOfResidence("policyHolderId");
            // Call verification form with parameters
        } else {
            // Display message indicating Voter's ID details are not selected
        }
    }

    public DrivingLicenseDetailsDTO getDrivingLicenseDetails() {
        return policyHolderRepository.findDrivingLicenseDetails();
    }

    public void handleFinancialDocumentForm(Object parameterList) {
        // Process the parameter list and perform necessary actions
    }

    public EiaDetailsDTO getEiaDetails(String applicationNumber) {
        return policyHolderRepository.findEiaDetails(applicationNumber);
    }

    public void openEIAccount() {
        String applicationNo = "appNo"; // Placeholder
        PolicyHolderDetails details = policyHolderRepository.findPolicyHolderDetails(applicationNo);
        boolean exists = policyHolderRepository.checkExistingEIAccount(applicationNo);
        if (!exists) {
            policyHolderRepository.insertNewEIAccount(details);
        }
    }

    public void verifyAadhaar(String aadhaarNumber, String moduleName) {
        // Create a parameter list named 'Param1'
        // Add the Aadhaar number and module name ('BBU') to the parameter list
        // Increment the eKYC review count
        // Call the form 'AZBJ_ADHAAR_KYC' with the created parameter list
    }

    public PolicyHolderSearchResponse searchPolicyHolder(PolicyHolderSearchRequest request) {
        PolicyHolder policyHolder = policyHolderRepository.findPolicyHolderById(request.getPolicyHolderId());
        PolicyHolderSearchResponse response = new PolicyHolderSearchResponse();
        response.setPolicyHolder(policyHolder);
        return response;
    }

    public List<LanguageDTO> fetchLanguages() {
        return policyHolderRepository.findAllLanguages();
    }

    public void updateCommunicationLanguage(int languageId) {
        policyHolderRepository.updateLanguage(languageId);
    }

    public AgeCalculationResponse calculateAge(AgeCalculationRequest request) {
        int age = AgeCalculationUtil.calculateAge(request.getDateOfBirth(), request.getInceptionDate());
        AgeCalculationResponse response = new AgeCalculationResponse();
        response.setAge(age);
        return response;
    }
}