package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.ReinsurerSelectionRepository;
import com.azbj.fm2002.model.ReinsurerCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReinsurerSelectionService {

    @Autowired
    private ReinsurerSelectionRepository reinsurerSelectionRepository;

    public void deleteRecord(Long recordId) {
        reinsurerSelectionRepository.deleteById(recordId);
    }

    public List<ReinsurerCode> getReinsurerCodes(String reinsuranceType, String productId, String coverCode) {
        return reinsurerSelectionRepository.findReinsurerCodes(reinsuranceType, productId, coverCode);
    }
}
