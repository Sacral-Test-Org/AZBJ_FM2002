package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.Cover;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoversHealthRepository extends JpaRepository<Cover, Long> {

    Cover findCoverById(Long id);

    Cover findNextCover(Long id);

    void updateCover(Cover cover);
}
