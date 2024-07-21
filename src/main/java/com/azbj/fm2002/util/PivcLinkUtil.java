package com.azbj.fm2002.util;

public class PivcLinkUtil {
    private static final String BASE_URL = "https://short.url/";
    private static final String PIVC_CONSTANT = "BALICVIDEO_PIVC";

    public static String generateLink(String applicationNumber) {
        String systemTypeIdentifier = applicationNumber + "_VIDEOPIVC";
        return BASE_URL + systemTypeIdentifier + "?type=" + PIVC_CONSTANT;
    }
}