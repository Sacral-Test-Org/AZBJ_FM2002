package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.FakeDocumentService;
import com.azbj.fm2002.dto.FakeDocumentDTO;
import com.azbj.fm2002.model.Category;
import com.azbj.fm2002.model.LovData;
import com.azbj.fm2002.model.ProofType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fake-document")
public class FakeDocumentController {

    @Autowired
    private FakeDocumentService fakeDocumentService;

    @GetMapping("/verify/{documentId}")
    public boolean verifyFakeDocument(@PathVariable("documentId") Long documentId) {
        return fakeDocumentService.isDocumentFake(documentId);
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateFakeDocumentStatus(@RequestBody FakeDocumentDTO fakeDocumentDTO) {
        fakeDocumentService.updateFakeDocumentStatus(fakeDocumentDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/comments-list")
    public List<Object> getCommentsList() {
        return fakeDocumentService.fetchCommentsList();
    }

    @GetMapping("/fake-document-value")
    public String getFakeDocumentValue() {
        return fakeDocumentService.fetchFakeDocumentValue();
    }

    @GetMapping("/category-values")
    public List<Category> getCategoryValues() {
        return fakeDocumentService.fetchCategoryValues();
    }

    @GetMapping("/lov-data")
    public List<LovData> getLovData(@RequestParam("documentCode") String documentCode, @RequestParam("fakeDocumentValue") String fakeDocumentValue) {
        return fakeDocumentService.fetchLovData(documentCode, fakeDocumentValue);
    }

    @PostMapping("/save")
    public void saveFakeDocument(@RequestBody FakeDocumentDTO fakeDocumentDTO) {
        fakeDocumentService.saveFakeDocument(fakeDocumentDTO);
    }

    @GetMapping("/proof-types")
    public List<ProofType> getProofTypes(@RequestParam("documentType") String documentType) {
        return fakeDocumentService.getProofTypes(documentType);
    }
}
