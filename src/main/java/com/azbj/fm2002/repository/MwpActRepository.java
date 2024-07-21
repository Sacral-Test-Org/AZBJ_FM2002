package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.BeneficiaryTrusteeInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface MwpActRepository extends JpaRepository<BeneficiaryTrusteeInfo, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM BeneficiaryTrusteeInfo b WHERE b.contractId = :contractId")
    void deleteByContractId(@Param("contractId") String contractId);

    @Override
    <S extends BeneficiaryTrusteeInfo> S save(S entity);

    @Query("SELECT o.opusDate FROM OpusDate o")
    Date getOpusDate();
}
