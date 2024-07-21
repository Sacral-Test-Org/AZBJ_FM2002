package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ReinsurerSelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReinsurerSelectionController {

    @Autowired
    private ReinsurerSelectionService reinsurerSelectionService;

    @DeleteMapping("/reinsurer/{recordId}")
    public ResponseEntity<Void> deleteRecord(@PathVariable Long recordId) {
        reinsurerSelectionService.deleteRecord(recordId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/reinsurer/codes")
    public List<String> getReinsurerCodes(@RequestParam String reinsuranceType, 
                                          @RequestParam String productId, 
                                          @RequestParam String coverCode) {
        return reinsurerSelectionService.getReinsurerCodes(reinsuranceType, productId, coverCode);
    }
}
