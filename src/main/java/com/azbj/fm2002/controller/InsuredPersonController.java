package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.InsuredPersonService;
import com.azbj.fm2002.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/insured-person")
public class InsuredPersonController {

    @Autowired
    private InsuredPersonService insuredPersonService;

    @GetMapping("/details/{insuredPersonID}")
    public ResponseEntity<Object> getInsuredPersonDetails(@PathVariable String insuredPersonID) {
        Object insuredPersonDetails = insuredPersonService.getInsuredPersonDetails(insuredPersonID);
        return ResponseEntity.ok(insuredPersonDetails);
    }

    @PostMapping("/details")
    public ResponseEntity<Void> saveInsuredPersonDetails(@RequestBody Object insuredPersonDetails) {
        insuredPersonService.saveInsuredPersonDetails(insuredPersonDetails);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate-changed-weight")
    public ResponseEntity<Void> validateChangedWeight() {
        insuredPersonService.validateChangedWeight();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/validate-age-proof/{ageProof}")
    public ResponseEntity<String> validateAgeProof(@PathVariable String ageProof) {
        String result = insuredPersonService.validateAgeProof(ageProof);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/age-proof-uid/{ageProof}")
    public ResponseEntity<String> getAgeProofUID(@PathVariable String ageProof) {
        String uid = insuredPersonService.getAgeProofUID(ageProof);
        return ResponseEntity.ok(uid);
    }

    @PostMapping("/validate-age-proof-id")
    public ResponseEntity<Void> validateAgeProofID(@RequestParam String ageProofType, @RequestParam String ageProofID) {
        insuredPersonService.validateAgeProofID(ageProofType, ageProofID);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate-mib-code")
    public ResponseEntity<Boolean> validateMibCode(@RequestParam String mibCode) {
        boolean isValid = insuredPersonService.validateMibCode(mibCode);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/validate-annual-income")
    public ResponseEntity<Boolean> validateAnnualIncome(@RequestParam double annualIncome) {
        boolean isValid = insuredPersonService.validateAnnualIncome(annualIncome);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/save-annual-income")
    public ResponseEntity<Void> saveAnnualIncome(@RequestParam double annualIncome) {
        insuredPersonService.saveAnnualIncome(annualIncome);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/probable-cp-details")
    public ResponseEntity<List<ProbableCP>> getProbableCPDetails() {
        List<ProbableCP> probableCPDetails = insuredPersonService.getProbableCPDetails();
        return ResponseEntity.ok(probableCPDetails);
    }

    @PostMapping("/validate-weight")
    public ResponseEntity<Boolean> validateWeight(@RequestParam double weight, @RequestParam String productDefinition, @RequestParam String packageCode) {
        boolean isValid = insuredPersonService.validateWeight(weight, productDefinition, packageCode);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/load-data")
    public ResponseEntity<DataResponse> loadData(@RequestParam String verificationNumber) {
        DataResponse dataResponse = insuredPersonService.processDataLoad(verificationNumber);
        return ResponseEntity.ok(dataResponse);
    }

    @GetMapping("/generate-new-proposal-number")
    public ResponseEntity<String> generateNewProposalNumber() {
        String proposalNumber = insuredPersonService.generateNewProposalNumber();
        return ResponseEntity.ok(proposalNumber);
    }

    @PostMapping("/update-lateral-shift-status")
    public ResponseEntity<Void> updateLateralShiftStatus(@RequestParam String insuredPersonId, @RequestParam boolean status) {
        insuredPersonService.updateLateralShiftStatus(insuredPersonId, status);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search-customer-partner")
    public ResponseEntity<SearchCpResponse> searchCustomerPartner(@RequestBody SearchCpRequest searchCpRequest) {
        SearchCpResponse response = insuredPersonService.searchCustomerPartner(searchCpRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate-height")
    public ResponseEntity<HeightValidationResponse> validateHeight(@RequestBody HeightValidationRequest request) {
        HeightValidationResponse response = insuredPersonService.validateHeight(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/generate-proposal-number")
    public ResponseEntity<String> generateProposalNumber(@RequestParam String date) {
        String proposalNumber = insuredPersonService.generateProposalNumber(date);
        return ResponseEntity.ok(proposalNumber);
    }

    @GetMapping("/search-mailing-address")
    public ResponseEntity<MailingAddressDTO> searchMailingAddress() {
        MailingAddressDTO mailingAddress = insuredPersonService.searchMailingAddress();
        return ResponseEntity.ok(mailingAddress);
    }

    @GetMapping("/passport-details")
    public ResponseEntity<PassportDetailsDTO> getPassportDetails() {
        PassportDetailsDTO passportDetails = insuredPersonService.fetchPassportDetails();
        return ResponseEntity.ok(passportDetails);
    }

    @PostMapping("/set-ip-type")
    public ResponseEntity<Boolean> setIpType(@RequestParam int productId) {
        boolean result = insuredPersonService.setIpType(productId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validate-ip-type")
    public ResponseEntity<Boolean> validateIpType(@RequestParam Object policyHolder, @RequestParam Object insuredPerson) {
        boolean result = insuredPersonService.validateIpType(policyHolder, insuredPerson);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validate-policy")
    public ResponseEntity<PolicyValidationResponse> validatePolicy(@RequestBody PolicyValidationRequest request) {
        PolicyValidationResponse response = insuredPersonService.validatePolicy(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculate-entry-age")
    public ResponseEntity<AgeCalculationResponse> calculateEntryAge(@RequestBody AgeCalculationRequest request) {
        AgeCalculationResponse response = insuredPersonService.calculateAge(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/generate-encrypted-url")
    public ResponseEntity<String> generateEncryptedUrl(@RequestParam String verificationNumber) {
        String encryptedUrl = insuredPersonService.encryptUrl(verificationNumber);
        return ResponseEntity.ok(encryptedUrl);
    }
}
