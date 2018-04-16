package com.ec.virtualcoin.identification;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.liferay.portal.kernel.util.PropsUtil;

public class FileUtil {

    private static Logger _logger = LoggerFactory.getLogger(FileUtil.class.getName());
    
    private DateUtil dateUtil = new DateUtil();
    
    public String generateRoute(String screenName, ImageType imageType , String defaultFolder, String extension) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
        StringBuilder builder = new StringBuilder();
        builder.append(defaultFolder);
        builder.append(File.separator);
        builder.append(screenName);
        builder.append(File.separator);
        builder.append(imageType.name());
        builder.append(".");
        builder.append(df.format(dateUtil.getNow()));
        builder.append(extension);
        return builder.toString();
    }
    
    public void copyFile(String source, String target) throws IOException {
        Path sourceFilePath = Paths.get(source);
        Path targetFilePath = Paths.get(target);
        _logger.info(String.format("copiar: %s %s", source, target));
        Files.copy(sourceFilePath, targetFilePath, StandardCopyOption.REPLACE_EXISTING);
    }
    
    public String getFileExtension(String source) {
        int lastIndexOf = source.lastIndexOf(".");
        return lastIndexOf > 0?source.substring(lastIndexOf):"";
    }

    public void createPendingFolders(String fullPath) {
        String folderPath = fullPath.substring(0, fullPath.lastIndexOf(File.separator));
        File file = new File(folderPath);
        file.mkdirs();
    }

    public String getImageAbsolutePath() {
        return PropsUtil.get("image.hook.file.system.root.dir");
    }

}
