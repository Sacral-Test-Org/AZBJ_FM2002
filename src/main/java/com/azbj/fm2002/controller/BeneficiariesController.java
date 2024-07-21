package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.BeneficiariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/beneficiaries")
public class BeneficiariesController {

    @Autowired
    private BeneficiariesService beneficiariesService;

    @PostMapping("/saveGender")
    public void saveGender(@RequestParam String gender) {
        beneficiariesService.saveGender(gender);
    }

    @GetMapping("/getGender")
    public String getGender() {
        return beneficiariesService.getGender();
    }

    @DeleteMapping("/deleteNominee")
    public ResponseEntity<Void> deleteNominee(@RequestParam Long nomineeId) {
        beneficiariesService.deleteNominee(nomineeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getNomineeDetails")
    public ResponseEntity<List<String>> getNomineeDetails() {
        List<String> nomineeDetails = beneficiariesService.fetchNomineeDetails();
        return ResponseEntity.ok(nomineeDetails);
    }

    @PostMapping("/validateDOB")
    public boolean validateDOB(@RequestParam Date dateOfBirth) {
        return beneficiariesService.validateDOB(dateOfBirth);
    }

    @GetMapping("/getNomineeDetailsByAppAndProposal")
    public List<NomineeDetails> getNomineeDetails(@RequestParam String applicationNo, @RequestParam String proposalNo) {
        return beneficiariesService.fetchNomineeDetails(applicationNo, proposalNo);
    }

    @PostMapping("/saveNomineeDetails")
    public void saveNomineeDetails(@RequestBody List<NomineeDetails> nomineeDetails) {
        beneficiariesService.saveNomineeDetails(nomineeDetails);
    }

    @PostMapping("/validateAppointeeName")
    public boolean validateAppointeeName(@RequestParam String appointeeName) {
        return beneficiariesService.validateAppointeeName(appointeeName);
    }

    @GetMapping("/getBeneficiaryTrusteeRecords")
    public List<BeneficiaryTrusteeDTO> getBeneficiaryTrusteeRecords(@RequestParam String contractId) {
        return beneficiariesService.retrieveBeneficiaryTrusteeRecords(contractId);
    }

    @PostMapping("/saveBeneficialOwnerRecord")
    public ValidationResponse saveBeneficialOwnerRecord(@RequestBody BeneficialOwner beneficialOwner) {
        return beneficiariesService.validateBeneficialOwnerRecord(beneficialOwner);
    }
}
