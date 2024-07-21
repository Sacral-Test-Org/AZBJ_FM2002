package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.FurtherReqService;
import com.azbj.fm2002.dto.WNrFurDTO;
import com.azbj.fm2002.dto.IncomeTaxDeclarationRequest;
import com.azbj.fm2002.dto.IncomeTaxDeclarationResponse;
import com.azbj.fm2002.dto.ReceiptStatusValidationRequest;
import com.azbj.fm2002.dto.ReceiptStatusValidationResponse;
import com.azbj.fm2002.dto.FurtherReqDTO;
import com.azbj.fm2002.dto.FurtherReqResponse;
import com.azbj.fm2002.dto.LOVData;
import com.azbj.fm2002.dto.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/further-req")
public class FurtherReqController {

    @Autowired
    private FurtherReqService furtherReqService;

    @PostMapping("/save")
    public ResponseEntity<?> saveFormData(@RequestBody Object formData) {
        furtherReqService.saveFormData(formData);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-field-status/{fieldName}")
    public ResponseEntity<Boolean> checkFieldStatus(@PathVariable String fieldName) {
        boolean status = furtherReqService.checkFieldStatus(fieldName);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/validate-request-number/{requestNumber}")
    public ResponseEntity<Boolean> validateRequestNumber(@PathVariable String requestNumber) {
        boolean isValid = furtherReqService.validateRequestNumber(requestNumber);
        return ResponseEntity.ok(isValid);
    }

    @GetMapping("/current-date")
    public ResponseEntity<Date> getCurrentDate() {
        Date currentDate = furtherReqService.fetchCurrentDate();
        return ResponseEntity.ok(currentDate);
    }

    @GetMapping("/external-date")
    public ResponseEntity<Date> getExternalDate() {
        Date externalDate = furtherReqService.fetchExternalDate();
        return ResponseEntity.ok(externalDate);
    }

    @GetMapping("/req-no-data")
    public ResponseEntity<List<ReqNoDTO>> getReqNoData() {
        List<ReqNoDTO> reqNoData = furtherReqService.fetchReqNoData();
        return ResponseEntity.ok(reqNoData);
    }

    @PostMapping("/handle-fr-res-recd-change")
    public ResponseEntity<String> handleFRResRecdChange(@RequestBody WNrFurDTO wNrFurDTO) {
        String response = furtherReqService.validateFRResRecd(wNrFurDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handle-key-down")
    public ResponseEntity<String> handleKeyDown(@RequestBody WNrFurDTO wNrFurDTO) {
        String response = furtherReqService.processKeyDown(wNrFurDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handle-key-up")
    public ResponseEntity<String> handleKeyUp(@RequestBody WNrFurDTO wNrFurDTO) {
        String response = furtherReqService.processKeyUp(wNrFurDTO);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/check-and-populate-frar-details")
    public ResponseEntity<?> checkAndPopulateFrarDetails() {
        furtherReqService.checkAndPopulateFrarDetails();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lov-data")
    public ResponseEntity<List<String>> getLOVData() {
        List<String> lovData = furtherReqService.fetchLOVData();
        return ResponseEntity.ok(lovData);
    }

    @GetMapping("/rcu-requirements/{applicationNo}")
    public ResponseEntity<List<Requirement>> getRcuRequirements(@PathVariable String applicationNo) {
        List<Requirement> requirements = furtherReqService.fetchRcuRequirements(applicationNo);
        return ResponseEntity.ok(requirements);
    }

    @PostMapping("/set-ip-type-and-validate")
    public ResponseEntity<Void> setIpTypeAndValidate(@RequestParam int productId, @RequestParam boolean isSamePerson) {
        furtherReqService.validateIpType(productId, isSamePerson);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/specific-date")
    public ResponseEntity<Date> getSpecificDate() {
        Date specificDate = furtherReqService.getSpecificDate();
        return ResponseEntity.ok(specificDate);
    }

    @GetMapping("/check-global-condition")
    public ResponseEntity<Boolean> checkGlobalCondition() {
        boolean conditionMet = furtherReqService.checkGlobalCondition();
        return ResponseEntity.ok(conditionMet);
    }

    @PostMapping("/set-lov")
    public ResponseEntity<Void> setLOV(@RequestParam boolean flag) {
        furtherReqService.setLOV(flag);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-fields")
    public ResponseEntity<Void> resetFields() {
        furtherReqService.resetFields();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/lov-values")
    public ResponseEntity<List<LOV>> getLOVValues(@RequestParam String phonePeFlag) {
        List<LOV> lovValues = furtherReqService.fetchLOVValues(phonePeFlag);
        return ResponseEntity.ok(lovValues);
    }

    @GetMapping("/further-requirements")
    public ResponseEntity<List<FurtherRequirement>> getFurtherRequirements() {
        List<FurtherRequirement> furtherRequirements = furtherReqService.fetchFurtherRequirements();
        return ResponseEntity.ok(furtherRequirements);
    }

    @PostMapping("/validate-requirement")
    public ResponseEntity<Boolean> validateRequirement(@RequestParam Long requirementId) {
        boolean isValid = furtherReqService.validateRequirement(requirementId);
        return ResponseEntity.ok(isValid);
    }

    @DeleteMapping("/delete-requirement")
    public ResponseEntity<Void> deleteRequirement(@RequestParam Long requirementId) {
        furtherReqService.deleteRequirement(requirementId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/validate-receipt-status")
    public ResponseEntity<ReceiptStatusValidationResponse> validateReceiptStatus(@RequestBody ReceiptStatusValidationRequest request) {
        ReceiptStatusValidationResponse response = furtherReqService.validateReceiptStatus(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/process-declaration")
    public ResponseEntity<IncomeTaxDeclarationResponse> processDeclaration(@RequestBody IncomeTaxDeclarationRequest request) {
        IncomeTaxDeclarationResponse response = furtherReqService.processDeclaration(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-test-requirement")
    public ResponseEntity<FurtherReqDTO> addTestRequirement(@RequestBody FurtherReqDTO testRequirement) {
        FurtherReqDTO response = furtherReqService.addTestRequirement(testRequirement);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-test-requirement")
    public ResponseEntity<Void> deleteTestRequirement(@RequestParam Long testId) {
        furtherReqService.deleteTestRequirement(testId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/test-requirements")
    public ResponseEntity<List<FurtherReqDTO>> getTestRequirements() {
        List<FurtherReqDTO> testRequirements = furtherReqService.getTestRequirements();
        return ResponseEntity.ok(testRequirements);
    }

    @GetMapping("/validate-test-number")
    public ResponseEntity<Boolean> validateTestNumber(@RequestParam String testNumber) {
        boolean isValid = furtherReqService.validateTestNumber(testNumber);
        return ResponseEntity.ok(isValid);
    }

    @PostMapping("/mark-as-received")
    public ResponseEntity<FurtherReqDTO> markAsReceived(@RequestParam Long testId) {
        FurtherReqDTO response = furtherReqService.markAsReceived(testId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/handle-mwp-act-checkbox-change")
    public ResponseEntity<Void> handleMwpActCheckboxChange(HttpServletRequest request) {
        String maritalStatus = request.getParameter("maritalStatus");
        boolean isChecked = Boolean.parseBoolean(request.getParameter("isChecked"));

        if (isChecked) {
            boolean isValidMaritalStatus = furtherReqService.checkMaritalStatus(maritalStatus);
            if (isValidMaritalStatus) {
                furtherReqService.navigateToFurtherReqBlock();
                furtherReqService.createOrUpdateRecord("M470", "MWP ADDENDUM", new Date(), "USER CALLED");
            } else {
                return ResponseEntity.badRequest().build();
            }
        } else {
            furtherReqService.navigateToFurtherReqBlock();
            furtherReqService.deleteRecord("M470");
        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/lov-data")
    public ResponseEntity<List<any[]>> getLOVData() {
        List<any[]> lovData = furtherReqService.fetchLOVData();
        return ResponseEntity.ok(lovData);
    }

    @GetMapping("/further-requirements")
    public ResponseEntity<List<FurtherRequirement>> getFurtherRequirements() {
        List<FurtherRequirement> furtherRequirements = furtherReqService.fetchFurtherRequirements();
        return ResponseEntity.ok(furtherRequirements);
    }

    @DeleteMapping("/delete-requirement/{testNo}")
    public ResponseEntity<Void> deleteRequirement(@PathVariable Long testNo) {
        furtherReqService.deleteRequirement(testNo);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/synchronize-records")
    public ResponseEntity<Void> synchronizeRecords() {
        furtherReqService.synchronizeRecords();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/further-requirements")
    public ResponseEntity<List<FurtherReqResponse>> getFurtherRequirements() {
        List<FurtherReqResponse> furtherRequirements = furtherReqService.getFurtherRequirements();
        return ResponseEntity.ok(furtherRequirements);
    }

    @GetMapping("/lov-data")
    public ResponseEntity<List<LOVData>> getLOVData() {
        List<LOVData> lovData = furtherReqService.fetchLOVData();
        return ResponseEntity.ok(lovData);
    }
}
