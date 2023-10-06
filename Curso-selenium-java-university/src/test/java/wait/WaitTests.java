package wait;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;
import pages.DynamicLoadingPage;

public class WaitTests extends BaseTests {

    /*@Test
    public void testWaitUntilHidden(){
        DynamicLoadingExample1Page loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStar();
        Assert.assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text incorrect");

    }*/

    @Test
    public void testWaitExample2(){
        DynamicLoadingExample2Page loadingPage2 = homePage.clickDynamicLoading().clickExample2();
        loadingPage2.clickStart();
        Assert.assertEquals(loadingPage2.getLoadedText(),"Hello World!","Loadead text incorrect");
    }
}
