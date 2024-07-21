package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.PreviousPolicyDetailsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface PolicyDetailsRepository extends JpaRepository<PreviousPolicyDetailsDTO, Long> {

    @Query(value = "SELECT AZBJ_PK0_ACC.GET_POLICY_REF (A.CONTRACT_ID) AS POLICY_REF, B.NAME, C.CONTRACT_STATUS AS STATUS, D.REQUEST_REASON, D.USER_COMMENT " +
            "FROM OCP_INTERESTED_PARTIES A, CP_PARTNERS B, OCP_POLICY_VERSIONS C, AZBJ_COMPLAINTS D " +
            "WHERE A.PARTNER_ID = :customerId " +
            "AND A.PARTNER_ID = B.PART_ID " +
            "AND A.CONTRACT_ID = C.CONTRACT_ID " +
            "AND A.CONTRACT_ID = D.POLICY_REF ", nativeQuery = true)
    List<PreviousPolicyDetailsDTO> findPreviousPolicyDetails(@Param("customerId") String customerId);
}
