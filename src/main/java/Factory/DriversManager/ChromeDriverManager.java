package Factory.DriversManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements DriverManager {

    WebDriver driver;
    private String driverPath = "C:\\Users\\oades\\proj\\BjssAutomation\\drivers\\";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        this.driver = driver;
    }
}
