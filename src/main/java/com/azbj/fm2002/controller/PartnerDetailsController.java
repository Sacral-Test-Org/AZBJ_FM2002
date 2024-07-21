package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PartnerDetailsService;
import com.azbj.fm2002.dto.PartnerDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerDetailsController {

    @Autowired
    private PartnerDetailsService partnerDetailsService;

    @GetMapping("/partner-details")
    public ResponseEntity<PartnerDetailsDTO> getPartnerDetails(@RequestParam String partnerName) {
        PartnerDetailsDTO partnerDetails = partnerDetailsService.fetchPartnerDetails(partnerName);
        return ResponseEntity.ok(partnerDetails);
    }
}
