package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.InsuredPersonRiskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalicRiskRepository extends JpaRepository<InsuredPersonRiskData, Long> {

    @Query("SELECT COUNT(r) FROM InsuredPersonRiskData r WHERE r.section = 'BALIC_RISK'")
    int countRecords();

    @Query("UPDATE InsuredPersonRiskData r SET r.riskData = :riskData WHERE r.id = :id AND r.section = 'BALIC_RISK'")
    void updateRiskData(@Param("id") Long id, @Param("riskData") String riskData);
}
