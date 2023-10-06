package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import com.google.common.io.Files;
import java.time.Duration;

public class BaseTests {

    private EventFiringWebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        goHome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);

        //driver.manage().window().fullscreen();
        //driver.manage().window().setSize(new Dimension(375,667));
        //System.out.println(driver.getTitle());
        //driver.quit();
        //List<WebElement> links = driver.findElements(By.tagName("a"));
        //System.out.println(links.size());
        //WebElement inputLink = driver.findElement(By.linkText("Inputs"));
        //inputLink.click();
        //WebElement shift = driver.findElement(By.linkText("Shifting Content"));
        //shift.click();
        //driver.findElement(By.linkText("Example 1: Menu Element")).click();
        //List<WebElement> lis = driver.findElements(By.tagName("li"));
        //System.out.println(lis.size());

    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }


    //@AfterClass
    //public void tearDown(){
        //driver.quit();
    //}

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            //System.out.println("Screenshot taken:" + screeshot.getAbsolutePath());
            try{
                Files.move(screenshot,new File("resources/screenshots/"+result.getName()+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }

}
