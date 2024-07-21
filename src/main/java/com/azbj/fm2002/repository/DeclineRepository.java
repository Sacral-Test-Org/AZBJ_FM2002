package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.DeclineReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeclineRepository extends JpaRepository<DeclineReason, Long> {

    @Query("SELECT b.districtName FROM AzbjStates a, AzbjDistricts b WHERE a.scode = b.scode AND a.stateName = :state")
    List<String> getDistrictNames(@Param("state") String state);

    @Query("UPDATE FormStatus SET status = :status WHERE formId = :formId")
    void updateFormStatus(@Param("formId") String formId, @Param("status") String status);

    @Query("SELECT new com.azbj.fm2002.model.DeclineReason(sc.sysCode, sc.sysDesc) FROM AzbjSystemConstants sc WHERE sc.sysType = 'DECLN_TYPE'")
    List<DeclineReason> findDeclineReasons();
}
