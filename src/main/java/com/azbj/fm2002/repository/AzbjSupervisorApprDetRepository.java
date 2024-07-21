package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface AzbjSupervisorApprDetRepository extends JpaRepository<AzbjSupervisorApprDet, Long> {

    @Query("SELECT COUNT(a) FROM AzbjSupervisorApprDet a WHERE a.applicationNumber = :applicationNumber AND a.panIssuanceDate <> :panIssuanceDate")
    long countByApplicationNumberAndPanIssuanceDateNot(@Param("applicationNumber") String applicationNumber, @Param("panIssuanceDate") Date panIssuanceDate);
}
