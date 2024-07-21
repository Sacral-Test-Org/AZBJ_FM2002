package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ControlService;
import com.azbj.fm2002.dto.ControlItem;
import com.azbj.fm2002.dto.HoAllocationListDTO;
import com.azbj.fm2002.dto.ScrutinyFailureRequest;
import com.azbj.fm2002.dto.ScrutinyFailureResponse;
import com.azbj.fm2002.dto.SurrogateProofDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/control")
public class ControlController {

    @Autowired
    private ControlService controlService;

    @GetMapping("/items")
    public List<ControlItem> getControlItems() {
        return controlService.getControlItems();
    }

    @PostMapping("/items")
    public void saveControlItems(@RequestBody List<ControlItem> controlItems) {
        controlService.saveControlItems(controlItems);
    }

    @PostMapping("/populate-auto-reinsurance")
    public void populateAutoReinsurance() {
        controlService.populateAutoReinsurance();
    }

    @PostMapping("/update-form-status")
    public void updateFormStatus(@RequestParam String formId, @RequestParam String status) {
        controlService.updateFormStatus(formId, status);
    }

    @GetMapping("/rejection-reasons")
    public List<String> getRejectionReasons() {
        return controlService.fetchRejectionReasons();
    }

    @GetMapping("/ho-allocation-list")
    public List<HoAllocationListDTO> getHoAllocationList() {
        return controlService.fetchHoAllocationList();
    }

    @PostMapping("/validate-ho-allocation-list")
    public boolean validateHoAllocationList(@RequestParam String selectedValue) {
        return controlService.validateHoAllocationList(selectedValue);
    }

    @PostMapping("/initiate-reinsurance-process")
    public ResponseEntity<String> initiateReinsuranceProcess() {
        return controlService.initiateReinsuranceProcess();
    }

    @GetMapping("/doctor-codes")
    public List<String> getDoctorCodes() {
        return controlService.fetchDoctorCodes();
    }

    @GetMapping("/generate-bi-link")
    public ResponseEntity<String> generateBILink() {
        String biLink = controlService.getBILink();
        return ResponseEntity.ok(biLink);
    }

    @DeleteMapping("/delete-related-records")
    public void deleteRelatedRecords(@RequestParam String contractId) {
        controlService.deleteRelatedRecords(contractId);
    }

    @PostMapping("/validate-application-number")
    public ScrutinyFailureResponse validateApplicationNumber(@RequestBody ScrutinyFailureRequest request) {
        return controlService.validateApplicationNumber(request);
    }

    @PostMapping("/manage-surrogate-proof-details")
    public ResponseEntity<String> manageSurrogateProofDetails(@RequestBody SurrogateProofDetailsDTO detailsDTO) {
        return controlService.manageSurrogateProofDetails(detailsDTO);
    }
}