package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.AmlService;
import com.azbj.fm2002.dto.AmlDetailsDTO;
import com.azbj.fm2002.dto.AmlValidationRequest;
import com.azbj.fm2002.dto.AmlValidationResponse;
import com.azbj.fm2002.dto.PanDetailsDTO;
import com.azbj.fm2002.dto.ValidationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/aml")
public class AmlController {

    @Autowired
    private AmlService amlService;

    @GetMapping("/proof-types")
    public ResponseEntity<List<String>> fetchProofTypes() {
        List<String> proofTypes = amlService.fetchProofTypes();
        return ResponseEntity.ok(proofTypes);
    }

    @GetMapping("/proof-descriptions")
    public ResponseEntity<List<String>> fetchProofDescriptions() {
        List<String> proofDescriptions = amlService.fetchProofDescriptions();
        return ResponseEntity.ok(proofDescriptions);
    }

    @PostMapping("/populate-aml-details")
    public ResponseEntity<List<AmlDetailsDTO>> populateAmlDetails() {
        List<AmlDetailsDTO> amlDetails = amlService.populateAmlDetails();
        return ResponseEntity.ok(amlDetails);
    }

    @GetMapping("/document-type")
    public ResponseEntity<String> getDocumentType() {
        String documentType = amlService.fetchDocumentType();
        return ResponseEntity.ok(documentType);
    }

    @GetMapping("/chk-edit-aml")
    public ResponseEntity<String> getChkEditAml() {
        String chkEditAml = amlService.fetchChkEditAml();
        return ResponseEntity.ok(chkEditAml);
    }

    @PostMapping("/validate-aml-details")
    public ResponseEntity<AmlValidationResponse> validateAmlDetails(@RequestBody AmlValidationRequest request) {
        AmlValidationResponse response = amlService.validateAmlDetails(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/populate-aml-details")
    public ResponseEntity<List<AmlDetailsDTO>> populateAmlDetails() {
        List<AmlDetailsDTO> amlDetails = amlService.populateAmlDetails();
        return ResponseEntity.ok(amlDetails);
    }

    @GetMapping("/chk-edit-aml-status")
    public ResponseEntity<String> getChkEditAmlStatus() {
        String status = amlService.getChkEditAmlStatus();
        return ResponseEntity.ok(status);
    }

    @PostMapping("/validate-document-id")
    public ResponseEntity<ValidationResponse> validateDocumentId(@RequestBody String documentId) {
        ValidationResponse response = amlService.validateDocumentId(documentId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/pan-details")
    public ResponseEntity<List<PanDetailsDTO>> getPanDetails() {
        List<PanDetailsDTO> panDetails = amlService.getPanDetails();
        return ResponseEntity.ok(panDetails);
    }
}
