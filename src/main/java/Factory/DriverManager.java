package Factory;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    DriverFactory driverFactory;
    private WebDriver driver;

    public WebDriver initDriver(String appDriver) {

        if ("chrome".equals(appDriver)) {
            driverFactory = new ChromeDriverFactory();
            driverFactory.setDriver();
            driver = driverFactory.getDriver();

        } else if ("firefox".equals(appDriver)) {
            driverFactory = new FireFoxDriverFactory();
            driverFactory.setDriver();
            driver = driverFactory.getDriver();

        }
        return driver;
    }

}
