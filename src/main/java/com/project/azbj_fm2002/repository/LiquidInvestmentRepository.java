package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.LiquidInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiquidInvestmentRepository extends JpaRepository<LiquidInvestment, Long> {
    LiquidInvestment save(LiquidInvestment liquidInvestment);
}