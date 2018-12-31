package BaseSetup;

import Factory.DriverManager;
import org.openqa.selenium.WebDriver;

public class BrowserSetUp {

    DriverManager driverManager = new DriverManager();
    private WebDriver driver;
    private String appUrl = "http://automationpractice.com/";

    public void startBrowser(String appType){
        driver = driverManager.initDriver(appType);
        driver.navigate().to(appUrl);
        driver.manage().window().fullscreen();
    }

    public void closeBrowser(){
        driver.quit();
    }
}
