package Factory.Drivers;

import org.openqa.selenium.WebDriver;

public interface DriverManager {

    WebDriver getDriver();
    void setDriver();
}