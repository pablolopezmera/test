package com.ec.virtualcoin.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.Whitebox;

import com.ec.virtualcoin.common.ImageType;
import com.ec.virtualcoin.identification.DateUtil;
import com.ec.virtualcoin.identification.FileUtil;

public class FileUtilTest {
    
    @Test
    public void shouldGeneratePath() {
        Calendar now = new GregorianCalendar();
        now.set(Calendar.YEAR, 2018);
        now.set(Calendar.MONTH, 3);
        now.set(Calendar.DATE, 12);
        now.set(Calendar.MINUTE, 50);
        now.set(Calendar.SECOND, 18);
        
        FileUtil fileUtil = new FileUtil();
        
        DateUtil dateUtil = Mockito.mock(DateUtil.class);
        Mockito.when(dateUtil.getNow()).thenReturn(now.getTime());
        Whitebox.setInternalState(fileUtil, "dateUtil", dateUtil);

        String screenName = "test";
        String defaultFolder = "/usr/local";
        String extension = "jpg";
        String path = fileUtil.generateRoute(screenName, ImageType.ANVERSO, defaultFolder, extension);
        Assert.assertEquals("/usr/local/test/ANVERSO.2018-04-12-50-18.jpg", path);
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
        Assert.assertEquals("png", fileExtension);
    }
    
}
