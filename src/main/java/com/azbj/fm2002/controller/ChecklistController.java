package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ChecklistService;
import com.azbj.fm2002.model.Checklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklist")
public class ChecklistController {

    @Autowired
    private ChecklistService checklistService;

    @GetMapping
    public ResponseEntity<List<Checklist>> getChecklist() {
        List<Checklist> checklist = checklistService.getChecklist();
        return ResponseEntity.ok(checklist);
    }

    @PutMapping
    public ResponseEntity<Checklist> updateChecklist(@RequestBody Checklist checklist) {
        Checklist updatedChecklist = checklistService.updateChecklist(checklist);
        return ResponseEntity.ok(updatedChecklist);
    }

    @PostMapping("/changeStatusToRhobr")
    public ResponseEntity<Void> changeStatusToRhobr(@RequestParam Long requirementId) {
        checklistService.changeStatusToRhobr(requirementId);
        return ResponseEntity.ok().build();
    }
}
