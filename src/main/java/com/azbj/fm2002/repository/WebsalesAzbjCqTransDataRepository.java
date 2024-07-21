package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WebsalesAzbjCqTransDataRepository extends CrudRepository<WebsalesAzbjCqTransData, Long> {

    @Query("SELECT var30 FROM websales.azbj_cq_trans_data WHERE application_no = TO_CHAR(NVL(:applicationNo, :applicationNo))")
    String getEmployeeCode(@Param("applicationNo") String applicationNo);
}
