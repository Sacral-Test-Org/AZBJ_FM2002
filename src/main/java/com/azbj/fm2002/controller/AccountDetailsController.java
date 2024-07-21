package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AccountDetailsService;
import com.azbj.fm2002.model.BankDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountDetailsController {

    @Autowired
    private AccountDetailsService accountDetailsService;

    @GetMapping("/api/bank-details")
    public ResponseEntity<BankDetails> getBankDetails(@RequestParam String ifscCode) {
        BankDetails bankDetails = accountDetailsService.fetchBankDetails(ifscCode);
        if (bankDetails != null) {
            return ResponseEntity.ok(bankDetails);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
