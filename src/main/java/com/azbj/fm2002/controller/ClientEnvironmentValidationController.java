package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ClientEnvironmentValidationService;
import com.azbj.fm2002.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client-environment")
public class ClientEnvironmentValidationController {

    @Autowired
    private ClientEnvironmentValidationService validationService;

    @GetMapping("/validate-partner-references")
    public ResponseEntity<ClientEnvironmentValidationResponse> validatePartnerReferences() {
        return validationService.validatePartnerReferences();
    }

    @PostMapping("/validate-policy")
    public ValidationResponse validatePolicy(@RequestBody ValidationRequest request) {
        return validationService.validatePolicy(request);
    }

    @PostMapping("/save-only")
    public SaveOnlyResponse saveOnly(@RequestBody SaveOnlyRequest request) {
        return validationService.saveOnly(request);
    }

    @GetMapping("/reason-for-manual/{applicationNumber}")
    public ManualCasePushDTO reasonForManual(@PathVariable String applicationNumber) {
        return validationService.checkTransactionsAndRetrieveMessages(applicationNumber);
    }
}
