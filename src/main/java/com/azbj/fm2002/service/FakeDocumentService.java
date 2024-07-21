package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.FakeDocumentRepository;
import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.dto.FakeDocumentDTO;
import com.azbj.fm2002.entity.FakeDocumentEntity;
import com.azbj.fm2002.entity.LovData;
import com.azbj.fm2002.entity.ProofType;
import com.azbj.fm2002.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeDocumentService {

    @Autowired
    private FakeDocumentRepository fakeDocumentRepository;

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    public boolean isDocumentFake(long documentId) {
        return fakeDocumentRepository.checkFakeDocument(documentId);
    }

    public void updateFakeDocumentStatus(FakeDocumentDTO fakeDocumentDTO) {
        fakeDocumentRepository.updateFakeDocumentStatus(fakeDocumentDTO);
    }

    public List<Object> fetchCommentsList() {
        return azbjSystemConstantsRepository.findFakeLovValues();
    }

    public String fetchFakeDocumentValue() {
        return azbjSystemConstantsRepository.findFakeDocumentValue();
    }

    public List<Category> fetchCategoryValues() {
        return azbjSystemConstantsRepository.findBySysType("FAKE_LOV");
    }

    public List<LovData> fetchLovData(String documentCode, String fakeDocumentValue) {
        return fakeDocumentRepository.findLovData(documentCode, fakeDocumentValue);
    }

    public void saveFakeDocument(FakeDocumentDTO fakeDocumentDTO) {
        FakeDocumentEntity entity = new FakeDocumentEntity();
        entity.setPolicyRef(fakeDocumentDTO.getPolicyRef());
        entity.setContractId(fakeDocumentDTO.getContractId());
        entity.setDocumentDesc(fakeDocumentDTO.getDocumentDesc());
        entity.setDocumentType(fakeDocumentDTO.getDocumentType());
        entity.setDocumentCode(fakeDocumentDTO.getDocumentCode());
        entity.setFakeDocument(fakeDocumentDTO.getFakeDocument());
        entity.setInsertUser(fakeDocumentDTO.getInsertUser());
        entity.setInsertDt(fakeDocumentDTO.getInsertDt());
        entity.setComments(fakeDocumentDTO.getComments());
        entity.setBranchCode(fakeDocumentDTO.getBranchCode());
        entity.setHubCode(fakeDocumentDTO.getHubCode());
        entity.setIcCode(fakeDocumentDTO.getIcCode());
        entity.setStmCode(fakeDocumentDTO.getStmCode());
        entity.setFakeMark(fakeDocumentDTO.getFakeMark());
        entity.setDocProofType(fakeDocumentDTO.getDocProofType());
        entity.setCategory(fakeDocumentDTO.getCategory());
        fakeDocumentRepository.save(entity);
    }

    public List<ProofType> getProofTypes(String documentType) {
        return fakeDocumentRepository.findProofTypes(documentType);
    }
}