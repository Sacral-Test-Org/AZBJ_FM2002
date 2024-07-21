package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.CoversService;
import com.azbj.fm2002.dto.BenefitTermDTO;
import com.azbj.fm2002.dto.PremiumCalculationRequest;
import com.azbj.fm2002.dto.PremiumCalculationResponse;
import com.azbj.fm2002.dto.EntryAgeCalculationRequest;
import com.azbj.fm2002.dto.EntryAgeCalculationResponse;
import com.azbj.fm2002.dto.CoversHealthDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/covers")
public class CoversController {

    @Autowired
    private CoversService coversService;

    @PostMapping("/manageInsuranceCoverDetails")
    public void manageInsuranceCoverDetails() {
        coversService.manageInsuranceCoverDetails();
    }

    @PostMapping("/updateFormStatusControl")
    public void updateFormStatusControl(@RequestParam String globalLoadingFlag) {
        coversService.updateFormStatusControl(globalLoadingFlag);
    }

    @PostMapping("/validateAndTrackChanges")
    public ResponseEntity<?> validateAndTrackChanges(@RequestParam double frequencyOfOccurrenceAmount) {
        boolean result = coversService.validateAndTrackChanges(frequencyOfOccurrenceAmount);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/validateAndStorePremiumTerm")
    public ResponseEntity<String> validateAndStorePremiumTerm(@RequestParam int productID, @RequestParam int premiumTerm) {
        coversService.validateProductID(productID);
        coversService.storePremiumTerm(premiumTerm);
        return ResponseEntity.ok("Premium term stored successfully");
    }

    @PostMapping("/updateFormStatus")
    public ResponseEntity<String> updateFormStatus() {
        coversService.updateFormStatus();
        return ResponseEntity.ok("Form status updated to 'Y'");
    }

    @PostMapping("/setPremiumTerm")
    public ResponseEntity<String> setPremiumTerm(@RequestParam int benefitTerm) {
        coversService.setPremiumTerm(benefitTerm);
        return ResponseEntity.ok("Premium term set to benefit term");
    }

    @PostMapping("/validateEntryAge")
    public boolean validateEntryAge(@RequestParam int entryAge) {
        return coversService.validateEntryAge(entryAge);
    }

    @PostMapping("/calculateTerms")
    public Map<String, Integer> calculateTerms(@RequestParam int entryAge, @RequestParam String packageCode) {
        return coversService.calculateTerms(entryAge, packageCode);
    }

    @GetMapping("/getReasonsForCounterOffers")
    public List<String> getReasonsForCounterOffers() {
        return coversService.fetchReasonsForCounterOffers();
    }

    @GetMapping("/getPackageDetails")
    public Object getPackageDetails(@RequestParam String productId, @RequestParam String receiptDate) {
        return coversService.fetchPackageDetails(productId, receiptDate);
    }

    @PostMapping("/submitPolicyDetails")
    public Object submitPolicyDetails(@RequestBody Object policyDetails) {
        return coversService.submitPolicyDetails(policyDetails);
    }

    @PostMapping("/validateAndAdjustBenefitTerm")
    public PremiumCalculationResponse validateAndAdjustBenefitTerm(@RequestBody BenefitTermDTO benefitTermDTO) {
        boolean isValid = coversService.validateBenefitTerm(benefitTermDTO.getBenefitTerm());
        if (isValid) {
            int premiumTerm = coversService.adjustPremiumTerm(benefitTermDTO.getBenefitTerm());
            return new PremiumCalculationResponse(premiumTerm);
        }
        return new PremiumCalculationResponse(0);
    }

    @PostMapping("/calculateEntryAge")
    public EntryAgeCalculationResponse calculateEntryAge(@RequestBody EntryAgeCalculationRequest request) {
        return coversService.calculateEntryAge(request);
    }

    @PostMapping("/validateBookingFrequency")
    public boolean validateBookingFrequency(@RequestParam String bookingFrequency) {
        return coversService.validateBookingFrequency(bookingFrequency);
    }

    @PostMapping("/calculatePremium")
    public PremiumCalculationResponse calculatePremium(@RequestBody PremiumCalculationRequest request) {
        return coversService.calculatePremium(request);
    }

    @DeleteMapping("/deleteCover")
    public void deleteCover(@RequestParam String coverId) {
        coversService.deleteCover(coverId);
    }

    @PostMapping("/savePayoutFrequency")
    public ResponseEntity<Void> savePayoutFrequency(@RequestParam String frequency) {
        coversService.savePayoutFrequency(frequency);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/updateLoanDisbursedDate")
    public void updateLoanDisbursedDate(@RequestParam String loanDisbursedDate) {
        coversService.updateLoanDisbursedDate(loanDisbursedDate);
    }

    @GetMapping("/getCoverDetails")
    public List<CoversHealthDTO> getCoverDetails(@RequestParam Long productId) {
        return coversService.getCoverDetails(productId);
    }

    @PostMapping("/saveCoverDetails")
    public CoversHealthDTO saveCoverDetails(@RequestBody CoversHealthDTO coversHealthDTO) {
        return coversService.saveCoverDetails(coversHealthDTO);
    }
}
