package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WipAzbjMedUwRepository extends JpaRepository<WipAzbjMedUw, Long> {
    boolean existsByTestNo(Long testNo);
    void deleteByTestNo(Long testNo);
}
