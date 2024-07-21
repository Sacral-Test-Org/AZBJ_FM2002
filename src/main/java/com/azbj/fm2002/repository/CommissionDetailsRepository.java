package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.CommissionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommissionDetailsRepository extends JpaRepository<CommissionDetails, Long> {
    CommissionDetails findCommissionDetailsByAgentCode(String agentCode);
}