package com.azbj.fm2002.dto;

public class VideoDetailsDTO {
    private String applicationNumber;
    private String videoURL;

    public VideoDetailsDTO() {}

    public VideoDetailsDTO(String applicationNumber, String videoURL) {
        this.applicationNumber = applicationNumber;
        this.videoURL = videoURL;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }
}
