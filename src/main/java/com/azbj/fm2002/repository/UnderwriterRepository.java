package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.Underwriter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnderwriterRepository extends JpaRepository<Underwriter, String> {
    Optional<Underwriter> findUnderwriterById(String underwriterId);
}