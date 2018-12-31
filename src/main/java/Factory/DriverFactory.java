package Factory;

import org.openqa.selenium.WebDriver;

public interface DriverFactory {

    WebDriver getDriver();
    void setDriver();
}
