package Factory;

import Factory.DriversManager.ChromeDriverManager;
import Factory.DriversManager.DriverManager;
import Factory.DriversManager.FireFoxDriverManager;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverFactoryManager {
    DriverManager driverFactory;
    private WebDriver driver;
    private String remoteUrl = "http://localhost:4444/wd/hub";

    public DriverManager initDriver(String driverType) throws MalformedURLException {
        switch (driverType){
            case "Chrome":
                driverFactory = new ChromeDriverManager(remoteUrl);
                driverFactory.setDriver();
                break;
            case "Firefox":
                driverFactory = new FireFoxDriverManager(remoteUrl);
                driverFactory.setDriver();
                break;
        }
        return driverFactory;
    }

    public WebDriver getDriver(){
        driver = driverFactory.getDriver();
        return driver;
    }

}
