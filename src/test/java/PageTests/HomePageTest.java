package PageTests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    WebDriver driver;

    @Test
    public void verifyHomePage() throws InterruptedException {
        driver = getDriver();
        homePage = new HomePage(driver);
        homePage.clickOnQuickView();
        Assert.assertEquals(driver.getTitle(),"My Store");


    }
}
