package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.FinancialUnderwriting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialUnderwritingRepository extends JpaRepository<FinancialUnderwriting, Long> {
    FinancialUnderwriting save(FinancialUnderwriting financialUnderwriting);
}