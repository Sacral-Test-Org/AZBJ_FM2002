package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.BeneficiaryTrusteeInfo;
import com.azbj.fm2002.dto.DobValidationRequest;
import com.azbj.fm2002.dto.DobValidationResponse;
import com.azbj.fm2002.service.MwpActService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mwp-act")
public class MwpActController {

    @Autowired
    private MwpActService mwpActService;

    @PostMapping("/save-beneficiary-trustee-info")
    public ResponseEntity<String> saveBeneficiaryTrusteeInfo(@RequestBody BeneficiaryTrusteeInfo info) {
        if (info.getBeneficiaryName() == null) {
            return ResponseEntity.badRequest().body("At least one beneficiary is mandatory");
        }
        if (info.getTrusteeName() == null) {
            return ResponseEntity.badRequest().body("At least one Trustee is mandatory");
        }
        if (info.getWitnessName() == null) {
            return ResponseEntity.badRequest().body("Witness name cannot be null");
        }
        mwpActService.saveBeneficiaryTrusteeInfo(info);
        return ResponseEntity.ok("Saved Successfully");
    }

    @PostMapping("/validate-dob")
    public ResponseEntity<DobValidationResponse> validateDOB(@RequestBody DobValidationRequest request) {
        DobValidationResponse response = mwpActService.validateDOB(request);
        return ResponseEntity.ok(response);
    }
}
