package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ChecklistRepository;
import com.azbj.fm2002.model.Checklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChecklistService {

    @Autowired
    private ChecklistRepository checklistRepository;

    public List<Checklist> getChecklist() {
        return checklistRepository.findAll();
    }

    public Checklist updateChecklist(Checklist checklist) {
        return checklistRepository.save(checklist);
    }

    public void changeStatusToRhobr(Long id) {
        Checklist checklist = checklistRepository.findById(id).orElseThrow(() -> new RuntimeException("Checklist not found"));
        checklist.setStatus("RHOBR");
        checklistRepository.save(checklist);
    }
}
