package com.azbj.fm2002.controller;

import com.azbj.fm2002.service.ImageDetService;
import com.azbj.fm2002.dto.ImageTransferRequest;
import com.azbj.fm2002.dto.ImageTransferResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/image-det")
public class ImageDetController {

    @Autowired
    private ImageDetService imageDetService;

    @GetMapping("/web-sales-proposal-url")
    public String getWebSalesProposalUrl() {
        return imageDetService.getWebSalesProposalUrl();
    }

    @GetMapping("/image-details")
    public List<ImageDetails> getImageDetails() {
        return imageDetService.fetchImageDetails();
    }

    @PostMapping("/transfer-image")
    public ResponseEntity<ImageTransferResponse> transferImage(@RequestBody ImageTransferRequest request) {
        ImageTransferResponse response = imageDetService.transferImage(request);
        return ResponseEntity.ok(response);
    }
}
