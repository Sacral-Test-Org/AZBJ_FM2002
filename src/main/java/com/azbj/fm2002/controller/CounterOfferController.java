package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.CounterOfferDTO;
import com.azbj.fm2002.dto.CounterOfferRequest;
import com.azbj.fm2002.dto.CounterOfferResponse;
import com.azbj.fm2002.dto.CounterOfferValidationRequest;
import com.azbj.fm2002.dto.CounterOfferValidationResponse;
import com.azbj.fm2002.service.CounterOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/counter-offer")
public class CounterOfferController {

    @Autowired
    private CounterOfferService counterOfferService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateCounterOfferLetter(@RequestBody CounterOfferDTO counterOfferDetails) {
        boolean isGenerated = counterOfferService.processCounterOffer(counterOfferDetails);
        if (isGenerated) {
            return ResponseEntity.ok("Counter offer letter generated successfully.");
        } else {
            return ResponseEntity.status(500).body("Failed to generate counter offer letter.");
        }
    }

    @GetMapping("/product-group-status")
    public ResponseEntity<?> getProductAndGroupStatus(@RequestParam String productId, @RequestParam String groupId) {
        return ResponseEntity.ok(counterOfferService.checkProductAndGroupStatus(productId, groupId));
    }

    @PostMapping("/submit")
    public ResponseEntity<CounterOfferResponse> submitCounterOffer(@RequestBody CounterOfferRequest counterOfferRequest) {
        CounterOfferResponse response = counterOfferService.submitCounterOffer(counterOfferRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/validate")
    public ResponseEntity<CounterOfferValidationResponse> validateCounterOffer(@RequestBody CounterOfferValidationRequest validationRequest) {
        CounterOfferValidationResponse response = counterOfferService.validateCounterOffer(validationRequest);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/modify")
    public ResponseEntity<CounterOfferValidationResponse> modifyCounterOfferType(@RequestParam String selectedOfferType) {
        CounterOfferValidationResponse response = counterOfferService.validateCounterOffer(selectedOfferType);
        return ResponseEntity.ok(response);
    }
}
