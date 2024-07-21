package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.SolSsoFundValidationRequest;
import com.azbj.fm2002.dto.SolSsoFundValidationResponse;
import com.azbj.fm2002.service.SolSsoFundService;
import com.azbj.fm2002.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SolSsoFundController {

    @Autowired
    private SolSsoFundService solSsoFundService;

    @PostMapping("/validateApportionment")
    public ResponseEntity<SolSsoFundValidationResponse> validateApportionment(@RequestBody SolSsoFundValidationRequest request) {
        SolSsoFundValidationResponse response = solSsoFundService.validateApportionment(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getFunds")
    public ResponseEntity<List<Fund>> getFunds(@RequestParam String productId, @RequestParam String dateRange, @RequestParam String coverCode) {
        List<Fund> funds = solSsoFundService.fetchFunds(productId, dateRange, coverCode);
        return ResponseEntity.ok(funds);
    }
}
