package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FcfLoadingDetailsRepository extends JpaRepository<FcfLoadingDetails, Long> {
    void deleteByMemberId(String memberId);
}
