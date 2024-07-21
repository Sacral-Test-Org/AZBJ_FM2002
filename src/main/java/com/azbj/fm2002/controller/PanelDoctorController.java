package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.PanelDoctorService;
import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.exception.DoctorSignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/panel-doctor")
public class PanelDoctorController {

    @Autowired
    private PanelDoctorService panelDoctorService;

    @GetMapping("/validate-doctor-code")
    public DoctorDetails validateDoctorCode(@RequestParam String doctorCode) {
        return panelDoctorService.validateDoctorCode(doctorCode);
    }

    @DeleteMapping("/delete-doctor")
    public void deleteDoctor(@RequestParam String doctorCode) {
        panelDoctorService.deleteDoctor(doctorCode);
    }

    @PostMapping("/populate-doctor-panel")
    public DoctorPanelData populateDoctorPanel() {
        return panelDoctorService.populateDoctorPanel();
    }

    @GetMapping("/view-images")
    public List<ImageData> viewImages(@RequestParam String doctorCode) {
        return panelDoctorService.viewImages(doctorCode);
    }

    @GetMapping("/opus-date")
    public String getOpusDate() {
        return panelDoctorService.getOpusDate();
    }

    @PostMapping("/validate-date-received")
    public boolean validateDateReceived(@RequestParam String dateReceived) {
        return panelDoctorService.validateDateReceived(dateReceived);
    }

    @PostMapping("/validate-doctor-code-scrutiny")
    public DoctorCodeValidationResponse validateDoctorCode(@RequestParam String lifeType, @RequestParam String testCode, @RequestParam String applicationNo) {
        return panelDoctorService.validateDoctorCode(lifeType, testCode, applicationNo);
    }

    @GetMapping("/doctor-names")
    public List<Doctor> getDoctorNames() {
        return panelDoctorService.fetchDoctorNames();
    }

    @PostMapping("/validate-test-code")
    public PanelDoctorValidationResponse validateTestCode(@RequestBody PanelDoctorValidationRequest request) {
        return panelDoctorService.validateTestCode(request);
    }

    @DeleteMapping("/delete-doctor-record")
    public ResponseEntity<String> deleteDoctorRecord(@RequestParam String doctorCode, @RequestParam String testCode) {
        boolean isDeleted = panelDoctorService.checkPaymentStatusAndDelete(doctorCode, testCode);
        if (isDeleted) {
            return ResponseEntity.ok("Doctor record deleted successfully.");
        } else {
            return ResponseEntity.status(400).body("Payment made to doctor. You cannot delete the record.");
        }
    }

    @GetMapping("/doctor-details")
    public ResponseEntity<List<DoctorDetailsDTO>> getDoctorDetails(@RequestParam String policyRef) {
        List<DoctorDetailsDTO> doctorDetails = panelDoctorService.fetchDoctorDetails(policyRef);
        return ResponseEntity.ok(doctorDetails);
    }

    @PostMapping("/verify-doctor-signature")
    public ResponseEntity<DoctorSignatureDTO> verifyDoctorSignature(@RequestParam String doctorCode) {
        try {
            DoctorSignatureDTO signature = panelDoctorService.verifyDoctorSignature(doctorCode);
            return ResponseEntity.ok(signature);
        } catch (DoctorSignatureException e) {
            return ResponseEntity.status(400).body(null);
        }
    }

    @GetMapping("/client-names")
    public ResponseEntity<List<DoctorClientNamesResponse>> getClientNamesByDoctorCode(@RequestParam String doctorCode) {
        List<DoctorClientNamesResponse> clientNames = panelDoctorService.fetchClientNames(doctorCode);
        return ResponseEntity.ok(clientNames);
    }
}