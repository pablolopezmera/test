package com.ec.virtualcoin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil {

    private static Logger _logger = LoggerFactory.getLogger(FileUtil.class.getName());
    
    public String generateRoute(String screenName, ImageType imageType , String defaultFolder, String extension) {
        StringBuilder builder = new StringBuilder();
        builder.append(defaultFolder);
        builder.append(File.separator);
        builder.append(screenName);
        builder.append(File.separator);
        builder.append(imageType.name());
        builder.append(extension);
        return builder.toString()   ;
    }
    
    public void copyFile(String source, String target) throws IOException {
        Path sourceFilePath = Paths.get(source);
        Path targetFilePath = Paths.get(target);
        _logger.info(String.format("copiar: %s %s", source, target));
        Files.copy(sourceFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
    }
    
    public String getFileExtension(String source) {
        return source.substring(source.lastIndexOf("."));
    }

    public void createPendingFolders(String fullPath) {
        String folderPath = fullPath.substring(0, fullPath.lastIndexOf(File.separator));
        File file = new File(folderPath);
        file.mkdirs();
    }

}
