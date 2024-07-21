package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.PolicyHolderRiskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalicRiskPhRepository extends JpaRepository<PolicyHolderRiskData, Long> {

    @Query("SELECT COUNT(p) FROM PolicyHolderRiskData p")
    int countRecords();

    @Query("UPDATE PolicyHolderRiskData p SET p.riskData = :riskData WHERE p.id = :id")
    void updateRiskData(@Param("id") Long id, @Param("riskData") String riskData);
}
