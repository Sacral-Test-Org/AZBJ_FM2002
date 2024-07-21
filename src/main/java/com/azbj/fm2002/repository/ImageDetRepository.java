package com.azbj.fm2002.repository;

import com.azbj.fm2002.model.ImageDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageDetRepository extends JpaRepository<ImageDetails, Long> {

    // Method to fetch all image details
    List<ImageDetails> findAll();

    // Method to fetch image details based on proposal number and image name
    ImageDetails fetchImageDetails(String proposalNumber, String imageName);
}
