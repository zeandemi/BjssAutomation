package Factory;

import Factory.DriversManager.ChromeDriverManager;
import Factory.DriversManager.DriverManager;
import Factory.DriversManager.FireFoxDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverFactoryManager {
    DriverManager driverFactory;
    private WebDriver driver;

    public DriverManager initDriver(String appDriver) {
        switch (appDriver){
            case "Chrome":
                driverFactory = new ChromeDriverManager();
                driverFactory.setDriver();
                break;
            case "Firefox":
                driverFactory = new FireFoxDriverManager();
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
