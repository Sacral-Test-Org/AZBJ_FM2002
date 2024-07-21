package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.FamilyHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyHistService {

    @Autowired
    private FamilyHistRepository familyHistRepository;

    private static final String CN_WIP_CONTINUE = "T";

    public void deleteMember(Long memberId, String controlFlag) {
        if (controlFlag.equals(CN_WIP_CONTINUE)) {
            // Attempt to find the member in the WIP_AZBJ_POLICY_FAMILY_REP table using the current record number
            boolean memberExists = familyHistRepository.existsById(memberId);
            if (!memberExists) {
                throw new RuntimeException("Member not found in the extension table.");
            }
            // Delete the member from the WIP_AZBJ_POLICY_FAMILY_REP table
            familyHistRepository.deleteById(memberId);
        }
        // Directly delete the record from the family history block
        familyHistRepository.deleteById(memberId);
    }
}
