package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.BiReportRequest;
import com.azbj.fm2002.dto.GstCalculationRequest;
import com.azbj.fm2002.dto.GstCalculationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface AzbjCoDetailsRepository extends JpaRepository<AzbjCoDetails, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE AzbjCoDetails a SET a.biPdf = :#{#request.biPdf}, a.message = :#{#request.message}, a.status = :#{#request.status}, a.premiumTerm = :#{#request.premiumTerm}, a.benefitTerm = :#{#request.benefitTerm}, a.biNumber = :#{#request.biNumber}, a.quoteId = :#{#request.quoteId}, a.premium = :#{#request.premium}, a.sumAssured = :#{#request.sumAssured} WHERE a.id = :#{#request.id}")
    void updateBiDetails(@Param("request") BiReportRequest request);

    @Query("SELECT a.documentDate FROM AzbjCoDetails a WHERE a.contractId = :contractId")
    Date fetchDocumentDate(@Param("contractId") String contractId);

    @Query("SELECT a.serviceTaxDate FROM AzbjCoDetails a WHERE a.contractId = :contractId AND a.documentDate = :documentDate")
    Date fetchServiceTaxDate(@Param("contractId") String contractId, @Param("documentDate") Date documentDate);

    @Query("SELECT a.postalCode FROM CpAddresses a, CpPartners b WHERE a.addId = b.addId AND b.partId = :insuredPersonId")
    String getPostalCode(@Param("insuredPersonId") String insuredPersonId);

    @Query("SELECT a.agentCode FROM AzbjPolicyAgentsRep a WHERE a.contractId = :contractId AND a.topIndicator = 'Y' AND a.actionCode <> 'D'")
    String getAgentCode(@Param("contractId") String contractId);

    @Query("SELECT a.branchCode FROM AzbjVAgents a WHERE a.referenceCode = :agentCode")
    String getBranchCode(@Param("agentCode") String agentCode);
}
