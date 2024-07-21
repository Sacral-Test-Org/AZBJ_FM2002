package com.azbj.fm2002.service;

import com.azbj.fm2002.repository.AzbjCqTransDataRepository;
import com.azbj.fm2002.repository.AzbjSystemConstantsRepository;
import com.azbj.fm2002.repository.ImageDetRepository;
import com.azbj.fm2002.dto.ImageTransferRequest;
import com.azbj.fm2002.dto.ImageTransferResponse;
import com.azbj.fm2002.model.ImageDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageDetService {

    @Autowired
    private AzbjCqTransDataRepository azbjCqTransDataRepository;

    @Autowired
    private AzbjSystemConstantsRepository azbjSystemConstantsRepository;

    @Autowired
    private ImageDetRepository imageDetRepository;

    public String getWebSalesProposalUrl(String applicationNo) {
        Integer transId = null;
        try {
            transId = azbjCqTransDataRepository.findTransIdByApplicationNo(applicationNo);
            if (transId == null) {
                transId = 0;
            }
        } catch (Exception e) {
            transId = null;
        }

        String sysDesc = azbjSystemConstantsRepository.findSysDescBySysTypeAndSysCode("WEB_SALES", "PROPOSAL");
        if (sysDesc != null && transId != null) {
            return sysDesc + transId;
        }
        return null;
    }

    public List<ImageDetails> fetchImageDetails() {
        return imageDetRepository.findAll();
    }

    public ImageTransferResponse transferImage(ImageTransferRequest request) {
        List<ImageDetails> imageDetails = fetchImageDetails();
        // Implement the image transfer logic here
        // For now, we will return a dummy response
        ImageTransferResponse response = new ImageTransferResponse();
        response.setStatus("Success");
        return response;
    }
}
