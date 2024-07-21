package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.SomDetails;
import com.azbj.fm2002.model.HubInchargeDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SomDetailsRepository extends JpaRepository<SomDetails, Long> {

    @Query("SELECT s FROM SomDetails s WHERE s.hub = (SELECT substr(t.receivedUser, 1, 3) FROM PhubTracker t WHERE t.applicationNo = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)))")
    List<SomDetails> findSomDetails();

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM SomDetails s WHERE s.flag = 'Y'")
    boolean validateFlag();

    @Query("UPDATE Proposal p SET p.status = 'FR-AR', p.action = 'F' WHERE p.id = :proposalId")
    void updateProposalStatus(Long proposalId);

    @Query("SELECT new com.azbj.fm2002.model.HubInchargeDetailsDTO(h.hubInchargeOpusId, h.hubInchargeName) FROM SomHubMapping h, PhubTracker t WHERE h.branchCode = t.branchCode AND t.applicationNo = TO_CHAR(NVL(:insuredPersonIpVerfNo, :insuredPersonIpSignCardNo)) AND NVL(h.activeFlag, 'Y') = 'Y'")
    HubInchargeDetailsDTO findHubInchargeDetails(String branchCode, String applicationNo);
}
