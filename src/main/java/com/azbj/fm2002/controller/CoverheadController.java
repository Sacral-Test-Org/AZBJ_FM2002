package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.CoverheadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/coverhead")
public class CoverheadController {

    @Autowired
    private CoverheadService coverheadService;

    @PostMapping("/calculateTerms")
    public ResponseEntity<Map<String, Integer>> calculateTerms(@RequestParam int vestingAge, @RequestParam Date dateOfBirth) {
        Map<String, Integer> result = coverheadService.calculateTerms(vestingAge, dateOfBirth);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/calculateSumAssured")
    public ResponseEntity<Double> calculateSumAssured(@RequestParam double premiumAmount, @RequestParam String bookingFrequency) {
        double sumAssured = coverheadService.calculateSumAssured(premiumAmount, bookingFrequency);
        return ResponseEntity.ok(sumAssured);
    }

    @PostMapping("/validateSRLPercentage")
    public ResponseEntity<Boolean> validateSRLPercentage(@RequestParam double srlPercentage, @RequestParam String coverCode, @RequestParam String productDefinition) {
        boolean isValid = coverheadService.validateSRLPercentage(srlPercentage, coverCode, productDefinition);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/determineAgeProofType")
    public ResponseEntity<String> determineAgeProofType(@RequestBody Map<String, Object> ageProofDetails) {
        String ageProofType = coverheadService.determineAgeProofType(ageProofDetails);
        return ResponseEntity.ok(ageProofType);
    }

    @GetMapping("/getPaymentMethods")
    public ResponseEntity<List<String>> getPaymentMethods(@RequestParam String bookingFrequency, @RequestParam String agentCode) {
        List<String> paymentMethods = coverheadService.getPaymentMethods(bookingFrequency, agentCode);
        return ResponseEntity.ok(paymentMethods);
    }

    @PostMapping("/validateBookingFrequencyAndProductId")
    public ResponseEntity<String> validateBookingFrequencyAndProductId(@RequestParam String bookingFrequency, @RequestParam String productId, @RequestParam Date receiptDate, @RequestParam Date opusDate) {
        String validationMessage = coverheadService.validateBookingFrequencyAndProductId(bookingFrequency, productId, receiptDate, opusDate);
        return ResponseEntity.ok(validationMessage);
    }

    @PostMapping("/updateDiscountStatus")
    public ResponseEntity<Void> updateDiscountStatus(@RequestParam String discountStatus) {
        coverheadService.updateDiscountStatus(discountStatus);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/loadCoverDetails")
    public ResponseEntity<String> loadCoverDetails() {
        coverheadService.copyCoverDetails();
        return ResponseEntity.ok("Cover details loaded successfully");
    }

    @PostMapping("/validateInceptionDate")
    public ResponseEntity<Map<String, Object>> validateInceptionDate(@RequestParam Date inceptionDate) {
        Map<String, Object> validationResult = coverheadService.validateInceptionDate(inceptionDate);
        return ResponseEntity.ok(validationResult);
    }

    @GetMapping("/getProductDetails")
    public ResponseEntity<Map<String, Object>> getProductDetails(@RequestParam int productId) {
        Map<String, Object> productDetails = coverheadService.getProductDetails(productId);
        return ResponseEntity.ok(productDetails);
    }

    @GetMapping("/getPackageDetails")
    public ResponseEntity<Map<String, Object>> getPackageDetails(@RequestParam String packageCode) {
        Map<String, Object> packageDetails = coverheadService.getPackageDetails(packageCode);
        return ResponseEntity.ok(packageDetails);
    }

    @PostMapping("/validatePackageCode")
    public ResponseEntity<Boolean> validatePackageCode(@RequestParam String packageCode) {
        boolean isValid = coverheadService.validatePackageCode(packageCode);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/updateBenefitType")
    public ResponseEntity<Void> updateBenefitType(@RequestParam String packageCode) {
        coverheadService.updateBenefitType(packageCode);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/calculatePremiumAndCharges")
    public ResponseEntity<Map<String, Object>> calculatePremiumAndCharges(@RequestBody Map<String, Object> premiumCalculationRequest) {
        Map<String, Object> response = coverheadService.calculatePremiumAndCharges(premiumCalculationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validateTerms")
    public ResponseEntity<Map<String, Object>> validateTerms(@RequestBody Map<String, Object> premiumCalculationRequest) {
        Map<String, Object> response = coverheadService.validateTerms(premiumCalculationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculatePremiumTerms")
    public ResponseEntity<Map<String, Object>> calculatePremiumTerms(@RequestBody Map<String, Object> premiumCalculationRequest) {
        Map<String, Object> response = coverheadService.calculatePremiumTerms(premiumCalculationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/checkServiceTaxApplicability")
    public ResponseEntity<Boolean> checkServiceTaxApplicability(@RequestParam String email) {
        boolean isApplicable = coverheadService.checkServiceTaxApplicability(email);
        return ResponseEntity.ok(isApplicable);
    }

    @PostMapping("/validate")
    public ResponseEntity<Map<String, Object>> validate(@RequestBody Map<String, Object> validationRequest) {
        Map<String, Object> response = coverheadService.validateApplicationData(validationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/initiateCounterOffer")
    public ResponseEntity<Void> initiateCounterOffer() {
        coverheadService.initiateCounterOffer();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validateMultiplier")
    public ResponseEntity<Map<String, Object>> validateMultiplier(@RequestBody Map<String, Object> multiplierValidationRequest) {
        Map<String, Object> response = coverheadService.validateMultiplier(multiplierValidationRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getCurrentUsername")
    public ResponseEntity<String> getCurrentUsername() {
        String username = coverheadService.getCurrentUsername();
        return ResponseEntity.ok(username);
    }

    @PostMapping("/handleActivateButton")
    public ResponseEntity<Map<String, Object>> handleActivateButton(@RequestBody Map<String, Object> fieldValues) {
        Map<String, Object> response = coverheadService.handleActivateButton(fieldValues);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getPremiumTerm")
    public ResponseEntity<Integer> getPremiumTerm(@RequestParam int productId, @RequestParam String coverCode, @RequestParam int loanTerm) {
        int premiumTerm = coverheadService.calculatePremiumTerm(productId, coverCode, loanTerm);
        return ResponseEntity.ok(premiumTerm);
    }

    @GetMapping("/getBenefitTerm")
    public ResponseEntity<Integer> getBenefitTerm(@RequestParam int productId, @RequestParam int age) {
        int benefitTerm = coverheadService.calculateBenefitTerm(productId, age);
        return ResponseEntity.ok(benefitTerm);
    }

    @GetMapping("/getReasons")
    public ResponseEntity<List<String>> getReasons() {
        List<String> reasons = coverheadService.fetchReasons();
        return ResponseEntity.ok(reasons);
    }

    @PostMapping("/handleCounterOfferReason")
    public ResponseEntity<Map<String, Object>> handleCounterOfferReason(@RequestBody Map<String, Object> counterOfferReasonRequest) {
        Map<String, Object> response = coverheadService.validateCounterOfferReason(counterOfferReasonRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getProductID")
    public ResponseEntity<Integer> getProductID() {
        int productId = coverheadService.getProductID();
        return ResponseEntity.ok(productId);
    }

    @GetMapping("/countBalicRiskRecords")
    public ResponseEntity<Integer> countBalicRiskRecords() {
        int count = coverheadService.countBalicRiskRecords();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/updateInsuredPersonRiskData")
    public ResponseEntity<Void> updateInsuredPersonRiskData(@RequestBody Map<String, Object> insuredPersonRiskData) {
        coverheadService.updateInsuredPersonRiskData(insuredPersonRiskData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/countBalicRiskPhRecords")
    public ResponseEntity<Integer> countBalicRiskPhRecords() {
        int count = coverheadService.countBalicRiskPhRecords();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/updatePolicyHolderRiskData")
    public ResponseEntity<Void> updatePolicyHolderRiskData(@RequestBody Map<String, Object> policyHolderRiskData) {
        coverheadService.updatePolicyHolderRiskData(policyHolderRiskData);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validateLoanType")
    public ResponseEntity<Map<String, Object>> validateLoanType(@RequestBody Map<String, Object> loanTypeValidationRequest) {
        Map<String, Object> response = coverheadService.validateLoanType(loanTypeValidationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/navigateToNextItem")
    public ResponseEntity<Map<String, Object>> navigateToNextItem(@RequestBody Map<String, Object> navigationRequest) {
        Map<String, Object> response = coverheadService.navigateToNextItem(navigationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/manageJointLifeOption")
    public ResponseEntity<Map<String, Object>> manageJointLifeOption(@RequestBody Map<String, Object> jointLifeOptionRequest) {
        Map<String, Object> response = coverheadService.validateJointLifeOption(jointLifeOptionRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validateCoverType")
    public ResponseEntity<Map<String, Object>> validateCoverType(@RequestBody Map<String, Object> coverTypeValidationRequest) {
        Map<String, Object> response = coverheadService.validateCoverType(coverTypeValidationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handleNavigationErrors")
    public ResponseEntity<Map<String, Object>> handleNavigationErrors(@RequestBody Map<String, Object> navigationErrorRequest) {
        Map<String, Object> response = coverheadService.handleNavigationErrors(navigationErrorRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateCashBackFlag")
    public ResponseEntity<Map<String, Object>> updateCashBackFlag(@RequestBody Map<String, Object> cashBackRequest) {
        Map<String, Object> response = coverheadService.updateCashBackFlag(cashBackRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculateSumAssuredOnDeath")
    public ResponseEntity<Map<String, Object>> calculateSumAssuredOnDeath(@RequestBody Map<String, Object> sumAssuredCalculationRequest) {
        Map<String, Object> response = coverheadService.calculateSumAssuredOnDeath(sumAssuredCalculationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validateInvestmentAmount")
    public ResponseEntity<Map<String, Object>> validateInvestmentAmount(@RequestBody Map<String, Object> investmentValidationRequest) {
        Map<String, Object> response = coverheadService.validateInvestmentAmount(investmentValidationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/populateTotalRiderInvestment")
    public ResponseEntity<Map<String, Object>> populateTotalRiderInvestment(@RequestBody Map<String, Object> investmentValidationRequest) {
        Map<String, Object> response = coverheadService.populateTotalRiderInvestment(investmentValidationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/populateSolution")
    public ResponseEntity<Map<String, Object>> populateSolution(@RequestBody Map<String, Object> populateSolutionRequest) {
        Map<String, Object> response = coverheadService.populateSolution(populateSolutionRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handleOkButtonRequest")
    public ResponseEntity<Map<String, Object>> handleOkButtonRequest(@RequestBody Map<String, Object> okButtonRequest) {
        Map<String, Object> response = coverheadService.handleOkButton(okButtonRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateFormStatus")
    public ResponseEntity<Void> updateFormStatus(@RequestParam String formStatus) {
        coverheadService.updateFormStatus(formStatus);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/determineDiscountType")
    public ResponseEntity<Map<String, Object>> determineDiscountType(@RequestBody Map<String, Object> discountTypeRequest) {
        Map<String, Object> response = coverheadService.determineDiscountType(discountTypeRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handleJointLifeCheckbox")
    public ResponseEntity<Map<String, Object>> handleJointLifeCheckbox(@RequestBody Map<String, Object> jointLifeRequest) {
        Map<String, Object> response = coverheadService.validateJointLife(jointLifeRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handleGpbOptedSelection")
    public ResponseEntity<Map<String, Object>> handleGpbOptedSelection(@RequestBody Map<String, Object> gpbOptedRequest) {
        Map<String, Object> response = coverheadService.handleGpbOptedSelection(gpbOptedRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/modifyInsuranceOffer")
    public ResponseEntity<Map<String, Object>> modifyInsuranceOffer(@RequestBody Map<String, Object> modifyInsuranceOfferRequest) {
        Map<String, Object> response = coverheadService.modifyInsuranceOffer(modifyInsuranceOfferRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/calculatePremium")
    public ResponseEntity<Map<String, Object>> calculatePremium(@RequestBody Map<String, Object> premiumCalculationRequest) {
        Map<String, Object> response = coverheadService.calculatePremium(premiumCalculationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validateAgeProof")
    public ResponseEntity<Map<String, Object>> validateAgeProof(@RequestBody Map<String, Object> ageProofValidationRequest) {
        Map<String, Object> response = coverheadService.validateAgeProof(ageProofValidationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validatePremiumTerm")
    public ResponseEntity<Map<String, Object>> validatePremiumTerm(@RequestBody Map<String, Object> premiumTermValidationRequest) {
        Map<String, Object> response = coverheadService.validatePremiumTerm(premiumTermValidationRequest);
        return ResponseEntity.ok(response);
    }
}
