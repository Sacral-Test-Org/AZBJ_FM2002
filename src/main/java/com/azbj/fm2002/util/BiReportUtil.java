package com.azbj.fm2002.util;

import com.azbj.fm2002.dto.BiReportRequest;
import com.azbj.fm2002.dto.BiReportResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Component
public class BiReportUtil {

    private static final Logger logger = LogManager.getLogger(BiReportUtil.class);

    @Value("${nvest.api.url}")
    private String nvestApiUrl;

    private final RestTemplate restTemplate;

    public BiReportUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BiReportResponse generateBiReport(BiReportRequest request) {
        logger.info("Generating BI report for request: {}", request);
        BiReportResponse response = new BiReportResponse();
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Content-Type", "application/json");
            HttpEntity<BiReportRequest> entity = new HttpEntity<>(request, headers);

            ResponseEntity<BiReportResponse> apiResponse = restTemplate.exchange(
                    nvestApiUrl,
                    HttpMethod.POST,
                    entity,
                    BiReportResponse.class
            );

            if (apiResponse.getStatusCode().is2xxSuccessful() && apiResponse.getBody() != null) {
                response = apiResponse.getBody();
                logger.info("BI report generated successfully: {}", response);
            } else {
                logger.warn("Failed to generate BI report. Response: {}", apiResponse);
            }
        } catch (Exception e) {
            logger.error("Error occurred while generating BI report", e);
        }
        return response;
    }
}
