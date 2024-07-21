package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.SpouseFinancialDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpouseFinancialDetailsRepository extends JpaRepository<SpouseFinancialDetails, Long> {
    
    @Override
    <S extends SpouseFinancialDetails> S save(S spouseFinancialDetails);
}
