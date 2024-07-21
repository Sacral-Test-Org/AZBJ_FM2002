package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.SpouseFinancialDetailsDTO;
import com.azbj.fm2002.dto.ProofTypeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpouseDetailsRepository extends JpaRepository<SpouseFinancialDetailsDTO, Long> {

    // Save spouse financial details
    SpouseFinancialDetailsDTO save(SpouseFinancialDetailsDTO spouseFinancialDetailsDTO);

    // Find spouse financial details by ID
    SpouseFinancialDetailsDTO findById(Long id);

    // Fetch all proof types
    List<ProofTypeDTO> findAll();

    // Save proof type
    void save(ProofTypeDTO proofType);

    // Fetch all proof types as strings
    List<String> findAllProofTypes();

    // Save proof type as string
    void saveProofType(String proofType);

    // Save calculated net profit
    void saveNetProfit(double netProfit);
}
