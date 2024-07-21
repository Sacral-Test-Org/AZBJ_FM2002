package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.IncompleteProposalDetailsRepository;
import com.azbj.fm2002.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IncompleteProposalDetailsService {

    @Autowired
    private IncompleteProposalDetailsRepository repository;

    public List<Record> fetchExistingRecords() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            return handleError(e);
        }
    }

    private List<Record> handleError(Exception error) {
        // Log the error (implementation of logging is assumed to be done elsewhere)
        System.err.println("Error fetching records: " + error.getMessage());
        // Return an empty list or handle as per business requirement
        return List.of();
    }
}