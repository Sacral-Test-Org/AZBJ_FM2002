package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.Checklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<Checklist, Long> {

    @Override
    List<Checklist> findAll();

    @Override
    <S extends Checklist> S save(S entity);

    @Transactional
    @Modifying
    @Query("UPDATE Checklist c SET c.status = 'RHOBR' WHERE c.id = :id")
    void updateStatusToRHOBR(Long id);
}
