package com.azbj.fm2002.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildCoverDetailsRepository extends JpaRepository<ChildCoverDetails, Long> {
    void deleteById(Long recordId);
}
