package com.ec.virtualcoin.test;

import org.junit.Assert;
import org.junit.Test;

import com.ec.virtualcoin.FileUtil;
import com.ec.virtualcoin.ImageType;

public class FileUtilTest {
    
    @Test
    public void shouldGeneratePath() {
        FileUtil fileUtil = new FileUtil();
        String screenName = "test";
        String defaultFolder = "/usr/local";
        String extension = ".png";
        String path = fileUtil.generateRoute(screenName, ImageType.ANVERSO, defaultFolder, extension);
        Assert.assertEquals("/usr/local/test/ANVERSO.png", path);
    }

    @Test
    public void shouldCreateFolders() {
        FileUtil fileUtil = new FileUtil();
        fileUtil.createPendingFolders("/home/pablo/profile/tenga/ANVERSO.jpg");
    }

    @Test
    public void shouldExtractExtensionFile() {
        String string = "/home/pablo/profile/test/ANVERSO.png";
        FileUtil fileUtil = new FileUtil();
        String fileExtension = fileUtil.getFileExtension(string);
        Assert.assertEquals(".png", fileExtension);
    }

}
