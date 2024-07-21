package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.RejectedApplicationReasonDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface DocsRepository extends JpaRepository<RejectedApplicationReasonDTO, Long> {

    @Query("SELECT new com.azbj.fm2002.dto.RejectedApplicationReasonDTO(reason) " +
           "FROM azbj_phub_add_req_tracker " +
           "WHERE accept_req = 'N' " +
           "AND application_no = TO_CHAR(NVL(:ipVerfNo, :ipSignCardNo)) " +
           "AND ALTERNATE_REQ = :alternateReq")
    List<RejectedApplicationReasonDTO> findRejectedApplicationReasons(@Param("ipVerfNo") String ipVerfNo, 
                                                                      @Param("ipSignCardNo") String ipSignCardNo, 
                                                                      @Param("alternateReq") String alternateReq);
}
