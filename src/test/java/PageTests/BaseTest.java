package PageTests;

import BaseSetup.BrowserSetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest {

    BrowserSetUp browserSetUp = new BrowserSetUp();
    public  static WebDriver driver;

    @BeforeTest
    @Parameters({"appType"})
    public void startBrowser(String appType){
        driver = browserSetUp.startBrowser(appType);
    }

    @AfterTest
    public void quitBrowser(){
        browserSetUp.closeBrowser();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
