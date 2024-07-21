package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.SignatureConfidenceService;
import com.azbj.fm2002.model.SignatureConfidence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignatureConfidenceController {

    @Autowired
    private SignatureConfidenceService signatureConfidenceService;

    @GetMapping("/signature-confidence-details")
    public ResponseEntity<List<SignatureConfidence>> getSignatureConfidenceDetails(@RequestParam String applicationNumber) {
        List<SignatureConfidence> signatureConfidenceDetails = signatureConfidenceService.getSignatureConfidenceDetails(applicationNumber);
        return ResponseEntity.ok(signatureConfidenceDetails);
    }

    @GetMapping("/generate-secure-url")
    public ResponseEntity<String> generateSecureUrl(@RequestParam String type, @RequestParam String category, @RequestParam String id) {
        String secureUrl = signatureConfidenceService.generateSecureUrl(type, category, id);
        return ResponseEntity.ok(secureUrl);
    }
}
