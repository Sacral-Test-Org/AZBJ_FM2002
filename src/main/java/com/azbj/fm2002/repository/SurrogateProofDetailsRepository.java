package com.azbj.fm2002.repository;

import com.azbj.fm2002.entity.SurrogateProofDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurrogateProofDetailsRepository extends JpaRepository<SurrogateProofDetailsEntity, Long> {
    SurrogateProofDetailsEntity save(SurrogateProofDetailsEntity surrogateProofDetailsEntity);
}