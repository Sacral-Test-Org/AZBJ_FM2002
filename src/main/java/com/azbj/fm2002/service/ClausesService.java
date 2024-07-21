package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.model.Clause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClausesService {

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    public List<Clause> getClauses(List<String> currentRecordSet) {
        try {
            return azbjSystemConstantsRepository.findClauses(currentRecordSet);
        } catch (Exception e) {
            // Log the error and rethrow or handle it as needed
            throw new RuntimeException("Error retrieving clauses", e);
        }
    }
}
