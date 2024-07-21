package com.project.azbj_fm2002.controller;

import com.project.azbj_fm2002.service.BeneficialOwnershipService;
import com.project.azbj_fm2002.dto.BeneficialOwnerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/beneficial-ownership")
public class BeneficialOwnershipController {

    @Autowired
    private BeneficialOwnershipService beneficialOwnershipService;

    @PostMapping("/save")
    public ResponseEntity<String> saveBeneficialOwnershipDetails(@RequestBody BeneficialOwnershipDTO beneficialOwnershipDTO) {
        try {
            beneficialOwnershipService.saveBeneficialOwnershipDetails(beneficialOwnershipDTO.getContractId(), beneficialOwnershipDTO.getBeneficialOwners());
            return new ResponseEntity<>("Beneficial ownership details saved successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving beneficial ownership details: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
