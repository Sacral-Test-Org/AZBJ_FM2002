package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.IibDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IibDetailsRepository extends JpaRepository<IibDetails, Long> {

    @Query("SELECT i FROM IibDetails i WHERE i.transactionId = :transactionId ORDER BY i.insertedDate")
    List<IibDetails> findByTransactionId(@Param("transactionId") String transactionId);

    @Query("SELECT c.sysDesc FROM SystemConstants c WHERE c.sysType = :sysType AND c.sysCode = :code")
    String findDescriptionByCode(@Param("sysType") String sysType, @Param("code") String code);
}
