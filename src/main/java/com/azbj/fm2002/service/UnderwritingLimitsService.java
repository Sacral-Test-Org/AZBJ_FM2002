package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.UnderwritingLimitsRepository;
import com.azbj.fm2002.entity.UnderwritingLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UnderwritingLimitsService {

    @Autowired
    private UnderwritingLimitsRepository underwritingLimitsRepository;

    public List<UnderwritingLimit> getUnderwritingLimits(String userId) {
        try {
            return underwritingLimitsRepository.findByUserId(userId);
        } catch (Exception e) {
            // Log the error and rethrow or handle it as needed
            throw new RuntimeException("Error retrieving underwriting limits", e);
        }
    }
}
