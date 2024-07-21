package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.FormData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AzbjRpErrAppRepository extends JpaRepository<FormData, Long> {
    
    default void saveFormData(FormData formData) {
        save(formData);
    }
}
