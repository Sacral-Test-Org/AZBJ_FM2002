package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.VerifiedAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/address")
public class VerifiedAddressController {

    @Autowired
    private VerifiedAddressService verifiedAddressService;

    @PostMapping("/verify")
    public ResponseEntity<String> verifyAddress(HttpServletRequest request) {
        try {
            return verifiedAddressService.verifyAddress(request);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error verifying address: " + e.getMessage());
        }
    }
}
