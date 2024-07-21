package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.model.PolicyRisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRiskRepository extends JpaRepository<PolicyRisk, Long> {
    PolicyRisk save(PolicyRisk policyRisk);
}