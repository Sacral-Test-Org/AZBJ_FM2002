package com.project.azbj_fm2002.repository;

import com.project.azbj_fm2002.entity.SolCovers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolCoversRepository extends JpaRepository<SolCovers, Long> {
    // Method to fetch all records from sol_covers section
    List<SolCovers> findAll();

    // Method to save or update a specific record in sol_covers section
    SolCovers save(SolCovers record);

    // Method to update the covers block in the database with new terms
    void updateCovers(Long id, Double benefitTerm, Double premiumTerm);
}
