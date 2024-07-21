package com.azbj.fm2002.repository;

import com.azbj.fm2002.dto.RevisedOfferDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AzbjRevisedOfferRepository extends JpaRepository<RevisedOfferDetailsDTO, Long> {
    List<RevisedOfferDetailsDTO> findAll();
}