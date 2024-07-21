package com.azbj.fm2002.controller;

import com.azbj.fm2002.dto.SaveReasonDTO;
import com.azbj.fm2002.dto.SeniorUnderwriterDTO;
import com.azbj.fm2002.service.SaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/save")
public class SaveController {

    @Autowired
    private SaveService saveService;

    @GetMapping("/selected-action")
    public String getSelectedAction() {
        return saveService.getSelectedAction();
    }

    @PostMapping("/selected-action")
    public void setSelectedAction(@RequestParam String action) {
        saveService.setSelectedAction(action);
    }

    @GetMapping("/senior-underwriters")
    public List<SeniorUnderwriterDTO> getSeniorUnderwriters() {
        return saveService.fetchSeniorUnderwriters();
    }

    @PostMapping("/update-status")
    public void updateStatus(@RequestParam String action) {
        saveService.updateStatus(action);
    }

    @PostMapping("/save-reason")
    public ResponseEntity<String> saveReason(@RequestBody SaveReasonDTO saveReasonDTO) {
        String response = saveService.saveReason(saveReasonDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get-reason/{id}")
    public ResponseEntity<SaveReasonDTO> getReason(@PathVariable Long id) {
        SaveReasonDTO reason = saveService.getReason(id);
        return ResponseEntity.ok(reason);
    }

    @PostMapping("/handle-exit")
    public void handleExitButton() {
        try {
            saveService.setFlag();
        } catch (Exception e) {
            saveService.handleException(e);
        }
    }
}
