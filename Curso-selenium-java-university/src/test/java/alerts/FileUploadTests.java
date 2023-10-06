package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTests {
    @Test
    public void testFileUpload(){
        FileUploadPage uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\Florencia Oviedo\\IdeaProjects\\CursoSelenium1\\resources\\chromedriver.exe");
        Assert.assertEquals(uploadPage.getUploadedFiles(),"chromedriver.exe","Uploaded file incorrect");
    }
}
