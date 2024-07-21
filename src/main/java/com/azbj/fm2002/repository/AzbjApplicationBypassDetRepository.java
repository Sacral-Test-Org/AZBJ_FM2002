package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.AzbjApplicationBypassDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AzbjApplicationBypassDetRepository extends JpaRepository<AzbjApplicationBypassDet, Long> {
    List<AzbjApplicationBypassDet> findByApplicationNumberAndBypassFlagAndBypassModule(String applicationNumber, String bypassFlag, String bypassModule);
}
