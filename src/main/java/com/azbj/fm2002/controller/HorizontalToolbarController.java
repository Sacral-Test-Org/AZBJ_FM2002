package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.*;
import com.azbj.fm2002.service.HorizontalToolbarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/horizontal-toolbar")
public class HorizontalToolbarController {

    @Autowired
    private HorizontalToolbarService horizontalToolbarService;

    @DeleteMapping("/delete-record")
    public DeleteRecordResponse deleteRecord(@RequestBody DeleteRecordRequest request) {
        return horizontalToolbarService.deleteRecord(request);
    }

    @GetMapping("/check-help")
    public void checkHelp() {
        horizontalToolbarService.checkHelpContext();
    }

    @GetMapping("/validate-exit")
    public ResponseEntity<ExitValidationResponse> validateExit() {
        ExitValidationResponse response = horizontalToolbarService.validateExit();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/save-changes")
    public SaveChangesResponse saveChanges(@RequestBody SaveChangesRequest request) {
        return horizontalToolbarService.saveChanges(request);
    }

    @PostMapping("/enable-commit-form-button")
    public void enableCommitFormButton() {
        horizontalToolbarService.enableCommitFormButton();
    }
}