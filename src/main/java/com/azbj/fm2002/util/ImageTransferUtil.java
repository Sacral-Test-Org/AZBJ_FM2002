package com.azbj.fm2002.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ImageTransferUtil {
    private static final Logger logger = LogManager.getLogger(ImageTransferUtil.class);

    public static boolean validateImage(String imagePath) {
        File imageFile = new File(imagePath);
        if (!imageFile.exists() || imageFile.length() == 0) {
            logger.error("Image is corrupted. Cannot load image");
            return false;
        }
        return true;
    }

    public static void transferImage(String sourcePath, String destinationPath) {
        Path source = Paths.get(sourcePath);
        Path destination = Paths.get(destinationPath);
        try {
            Files.createDirectories(destination.getParent());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            logger.info("Image transferred from " + sourcePath + " to " + destinationPath);
        } catch (IOException e) {
            logger.error("Error transferring image from " + sourcePath + " to " + destinationPath, e);
        }
    }
}
