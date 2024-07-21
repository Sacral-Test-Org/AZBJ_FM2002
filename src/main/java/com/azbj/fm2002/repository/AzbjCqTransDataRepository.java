package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AzbjCqTransDataRepository extends CrudRepository<AzbjCqTransData, Long> {
    @Query("SELECT trans_id FROM azbj_cq_trans_data WHERE application_no = TO_CHAR(NVL(:ipVerfNo, :ipSignCardNo))")
    Integer findTransIdByApplicationNo(@Param("ipVerfNo") String ipVerfNo, @Param("ipSignCardNo") String ipSignCardNo);
}
