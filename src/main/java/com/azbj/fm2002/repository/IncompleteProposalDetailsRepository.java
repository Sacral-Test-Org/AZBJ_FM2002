package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.IncompleteProposalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncompleteProposalDetailsRepository extends JpaRepository<IncompleteProposalDetails, Long> {
    // Method to fetch all existing records from the database
    List<IncompleteProposalDetails> findAll();
}
