package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.entity.SolCoverhead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SolCoverheadRepository extends JpaRepository<SolCoverhead, Long> {

    @Query("SELECT s.sumAssured FROM SolCoverhead s WHERE s.sumAssured IS NOT NULL")
    Double findSumAssured();

    @Query("SELECT s.solutionName FROM SolCoverhead s WHERE s.solutionName IS NOT NULL")
    String findSolutionName();

    @Query("SELECT s FROM SolCoverhead s")
    List<SolCoverhead> findAll();

    @Query("SELECT new map((:vestingAge - (YEAR(:dateOfBirth) - YEAR(CURRENT_DATE))) as benefitTerm, " +
            "CASE WHEN :bookingFrequency != '01' THEN (:vestingAge - (YEAR(:dateOfBirth) - YEAR(CURRENT_DATE))) ELSE 0 END as premiumTerm) " +
            "FROM SolCoverhead s WHERE s.productDefinition LIKE :productDefinition AND s.pensionFlag > 0")
    List<Object> findRelevantData(String productDefinition, int pensionFlag, String bookingFrequency, Date dateOfBirth, int vestingAge);

    @Query("SELECT s.discountType FROM SolCoverhead s WHERE s.productId NOT IN (269, 335, 337, 341, 343, 345) " +
            "AND s.agentCode LIKE (SELECT c.charValue FROM SystemConstants c WHERE c.sysType = 'DISCOUNT' AND c.sysCode = 'DISCOUNT_AGENT')")
    String findDiscountType();

    @Query("DELETE FROM AzbjBeneficiaryTrusteeRep a WHERE a.contractId = :contractId")
    void deleteByContractId(String contractId);
}
