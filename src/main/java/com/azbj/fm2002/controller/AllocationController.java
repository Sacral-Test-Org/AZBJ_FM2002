package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AllocationService;
import com.azbj.fm2002.service.DiscountValidationService;
import com.azbj.fm2002.model.FundDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/allocation")
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    @Autowired
    private DiscountValidationService discountValidationService;

    @PostMapping("/populateAllocation")
    public ResponseEntity<String> populateAllocation() {
        String result = allocationService.populateAllocation();
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/deleteFund/{fundId}")
    public ResponseEntity<Void> deleteFund(@PathVariable String fundId) {
        allocationService.deleteFund(fundId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validateDiscountType")
    public ResponseEntity<Boolean> validateDiscountType(@RequestParam String discountType) {
        boolean isValid = discountValidationService.validateDiscountType(discountType);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/getFundDetails")
    public ResponseEntity<List<FundDetails>> getFundDetails(@RequestParam String portfolioStrategy, @RequestParam String productId) {
        List<FundDetails> fundDetails = allocationService.getFundDetails(portfolioStrategy, productId);
        return ResponseEntity.ok(fundDetails);
    }

    @PostMapping("/populateFunds")
    public ResponseEntity<List<FundDetails>> populateFunds(@RequestParam String portfolioStrategy, @RequestParam int productId) {
        List<FundDetails> fundDetails = allocationService.populateFunds(portfolioStrategy, productId);
        return ResponseEntity.ok(fundDetails);
    }

    @PostMapping("/autoPopulateFunds")
    public ResponseEntity<Void> autoPopulateFunds(@RequestParam int productId, @RequestParam String portfolioStrategy) {
        allocationService.autoPopulateFunds(productId, portfolioStrategy);
        return ResponseEntity.noContent().build();
    }
}
