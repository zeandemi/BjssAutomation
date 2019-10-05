package BaseSetup;

import Factory.DriverFactoryManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSetUp {

    private WebDriver driver;
    private DriverFactoryManager driverFactoryManager;
    private String appUrl = "http://automationpractice.com/";

    public WebDriver startBrowser(String driverType){
        driverFactoryManager = new DriverFactoryManager();
        driverFactoryManager.initDriver(driverType);
        driver = driverFactoryManager.getDriver();
        driver.navigate().to(appUrl);
        driver.manage().window().fullscreen();
        return driver;
    }

    public void closeBrowser(){
        driver.quit();

    }
}
