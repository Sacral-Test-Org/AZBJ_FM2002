package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.BbuImageDtlsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BbuImageDtlsService {

    @Autowired
    private BbuImageDtlsRepository bbuImageDtlsRepository;

    public void validateAnswer(String answer) {
        if (answer == null || (!answer.equals("Y") && !answer.equals("N"))) {
            throw new IllegalArgumentException("Invalid answer. Please enter 'Y' for Yes or 'N' for No.");
        }

        if (answer.equals("Y")) {
            // Populate related group question
            bbuImageDtlsRepository.populateRelatedGroupQuestion();
            // Update requirement description with the value of the requirement if Yes
            bbuImageDtlsRepository.updateRequirementDescription("Yes");
        } else if (answer.equals("N")) {
            // Delete related group question
            bbuImageDtlsRepository.deleteRelatedGroupQuestion();
            // Update requirement description with the value of the requirement if No
            bbuImageDtlsRepository.updateRequirementDescription("No");
        }
    }
}
