package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.service.MedUwService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/meduw")
public class MedUwController {

    @Autowired
    private MedUwService medUwService;

    @PostMapping("/addTest")
    public ResponseEntity<MedicalTestDTO> addTest(@RequestBody MedicalTestDTO medicalTestDTO) {
        MedicalTestDTO addedTest = medUwService.addTest(medicalTestDTO);
        return ResponseEntity.ok(addedTest);
    }

    @DeleteMapping("/deleteTest/{id}")
    public ResponseEntity<Void> deleteTest(@PathVariable Long id) {
        medUwService.deleteTest(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/validateTest/{id}")
    public ResponseEntity<MedicalTestDTO> validateTest(@PathVariable Long id) {
        MedicalTestDTO validatedTest = medUwService.validateTest(id);
        return ResponseEntity.ok(validatedTest);
    }

    @GetMapping("/accessMedicalsGrid")
    public ResponseEntity<List<MedicalTestDTO>> accessMedicalsGrid() {
        List<MedicalTestDTO> medicalTests = medUwService.accessMedicalsGrid();
        return ResponseEntity.ok(medicalTests);
    }

    @PostMapping("/validateDate")
    public boolean validateDate(@RequestParam Date MU_DATE_RECD, @RequestParam Date OpusDate) {
        return medUwService.validateDate(MU_DATE_RECD, OpusDate);
    }

    @PostMapping("/markAsRetest/{testId}")
    public ResponseEntity<?> markAsRetest(@PathVariable Long testId) {
        boolean result = medUwService.markAsRetest(testId);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/updateDateReceived")
    public void updateDateReceived(@RequestParam String resultReceived) {
        medUwService.updateDateReceived(resultReceived);
    }

    @PostMapping("/validateTestConductedFrom")
    public ValidationResponse validateTestConductedFrom(@RequestParam String agentCode, @RequestParam String testNumber, @RequestParam String testConductedFrom) {
        return medUwService.validateTestConductedFrom(agentCode, testNumber, testConductedFrom);
    }

    @PostMapping("/validateMedicalType")
    public boolean validateMedicalType(@RequestParam String medicalType, @RequestParam boolean isSystemGenerated) {
        return medUwService.validateMedicalType(medicalType, isSystemGenerated);
    }

    @PostMapping("/updateReceiptStatus")
    public ResponseEntity<?> updateReceiptStatus(@RequestParam String receiptStatus) {
        medUwService.updateReceiptStatus(receiptStatus);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validateTest")
    public ValidateTestResponse validateTest(@RequestBody ValidateTestRequest validateTestRequest) {
        return medUwService.validateTest(validateTestRequest);
    }

    @DeleteMapping("/deleteMedicalTest")
    public DeleteMedicalTestResponse deleteMedicalTest(@RequestBody DeleteMedicalTestRequest deleteMedicalTestRequest) {
        return medUwService.deleteMedicalTest(deleteMedicalTestRequest);
    }

    @GetMapping("/getMedicalUnderwritingDetails")
    public List<MedUwResponse> getMedicalUnderwritingDetails() {
        return medUwService.getMedicalUnderwritingDetails();
    }

    @PostMapping("/saveMedicalUnderwritingDetails")
    public void saveMedicalUnderwritingDetails(@RequestBody MedUwRequest medUwRequest) {
        medUwService.saveMedicalUnderwritingDetails(medUwRequest);
    }
}