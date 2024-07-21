package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PolicyHolderService;
import com.azbj.fm2002.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/policyholder")
public class PolicyHolderController {

    @Autowired
    private PolicyHolderService policyHolderService;

    @GetMapping("/proposal-types")
    public List<ProposalType> getProposalTypes() {
        return policyHolderService.fetchProposalTypes();
    }

    @PostMapping("/validate-age-proof")
    public String validateAgeProof(@RequestParam String ageProof) {
        return policyHolderService.validateAgeProof(ageProof);
    }

    @PostMapping("/update-form-status")
    public ResponseEntity<String> updateFormStatus(@RequestParam String formStatus) {
        String result = policyHolderService.updateFormStatus(formStatus);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/update-policy-holder-details")
    public void updatePolicyHolderDetails(@RequestBody PolicyHolder policyHolder) {
        policyHolderService.updatePolicyHolderDetails(policyHolder);
    }

    @PostMapping("/clear-policy-holder-details")
    public void clearPolicyHolderDetails() {
        policyHolderService.clearPolicyHolderDetails();
    }

    @PostMapping("/validate-account-number")
    public boolean validateAccountNumber(@RequestParam String accountNumber) {
        return policyHolderService.validateAccountNumber(accountNumber);
    }

    @PostMapping("/validate-pa-code")
    public boolean validatePaCode(@RequestParam String paCode) {
        return policyHolderService.validatePaCode(paCode);
    }

    @PostMapping("/validate-pan-issuance-date")
    public boolean validatePanIssuanceDate(@RequestParam String panIssuanceDate) {
        return policyHolderService.validatePanIssuanceDate(panIssuanceDate);
    }

    @GetMapping("/mailing-address")
    public MailingAddressDTO getMailingAddress(@RequestParam String partnerId) {
        return policyHolderService.fetchMailingAddress(partnerId);
    }

    @PostMapping("/validate-payment-method")
    public PaymentMethodValidationResponse validatePaymentMethod(@RequestBody PaymentMethodValidationRequest request) {
        return policyHolderService.validatePaymentMethod(request);
    }

    @GetMapping("/bank-account-details")
    public BankAccountDetails getBankAccountDetails(@RequestParam String applicationNumber) {
        return policyHolderService.getBankAccountDetails(applicationNumber);
    }

    @GetMapping("/verification-status")
    public VerificationStatus getVerificationStatus(@RequestParam String applicationNumber) {
        return policyHolderService.getVerificationStatus(applicationNumber);
    }

    @PostMapping("/validate-age-proof-details")
    public ResponseEntity<ValidationResponse> validateAgeProof(@RequestParam String ageProofType, @RequestParam String ageProofID, @RequestParam String agentCode) {
        ValidationResponse response = policyHolderService.validateAgeProof(ageProofType, ageProofID, agentCode);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/passport-details")
    public PassportDetailsDTO getPassportDetails() {
        return policyHolderService.fetchPassportDetails();
    }

    @PostMapping("/verify-voter-id")
    public void verifyVoterId() {
        policyHolderService.verifyVoterId();
    }

    @GetMapping("/driving-license-details")
    public DrivingLicenseDetailsDTO getDrivingLicenseDetails() {
        return policyHolderService.getDrivingLicenseDetails();
    }

    @PostMapping("/call-financial-document-form")
    public void callFinancialDocumentForm(@RequestBody Object parameterList) {
        policyHolderService.handleFinancialDocumentForm(parameterList);
    }

    @GetMapping("/eia-details")
    public EiaDetailsDTO getEiaDetails(@RequestParam String applicationNumber) {
        return policyHolderService.getEiaDetails(applicationNumber);
    }

    @PostMapping("/open-ei-account")
    public ResponseEntity<?> openEIAccount() {
        return policyHolderService.openEIAccount();
    }

    @PostMapping("/initiate-aadhaar-verification")
    public void initiateAadhaarVerification(@RequestParam String aadhaarNumber, @RequestParam String moduleName) {
        policyHolderService.verifyAadhaar(aadhaarNumber, moduleName);
    }

    @PostMapping("/search-policy-holder")
    public PolicyHolderSearchResponse searchPolicyHolder(@RequestBody PolicyHolderSearchRequest request) {
        return policyHolderService.searchPolicyHolder(request);
    }

    @GetMapping("/languages")
    public List<LanguageDTO> getLanguages() {
        return policyHolderService.fetchLanguages();
    }

    @PostMapping("/update-language")
    public void updateLanguage(@RequestParam int languageId) {
        policyHolderService.updateCommunicationLanguage(languageId);
    }

    @PostMapping("/calculate-entry-age")
    public AgeCalculationResponse calculateEntryAge(@RequestBody AgeCalculationRequest request) {
        return policyHolderService.calculateAge(request);
    }
}
