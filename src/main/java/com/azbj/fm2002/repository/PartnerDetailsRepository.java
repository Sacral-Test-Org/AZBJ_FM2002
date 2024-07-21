package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.PartnerDetailsDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PartnerDetailsRepository extends JpaRepository<PartnerDetailsDTO, Long> {

    @Query("SELECT new com.azbj.fm2002.dto.PartnerDetailsDTO(d.gender, d.age, d.testNo, d.updDate) " +
           "FROM AZBJ_DOCT_CUST_DETAILS d " +
           "WHERE d.userId = :doctorCode " +
           "AND d.clientName = :partnerName " +
           "AND d.applicationNo = TO_CHAR(NVL(:applicationNumber, :applicationNumber))")
    PartnerDetailsDTO getPartnerDetails(@Param("partnerName") String partnerName,
                                        @Param("doctorCode") String doctorCode,
                                        @Param("applicationNumber") String applicationNumber);
}
