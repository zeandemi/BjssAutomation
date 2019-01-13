package PageTests;

import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    HomePage homePage;
    WebDriver driver;

    @Test
    @Parameters({"username","password"})
    public void purchase2Items(String username, String password) throws InterruptedException {
        driver = getDriver();
        homePage = new HomePage(driver);
        homePage.logIn(username,password).clickOnQuickView();
        Assert.assertEquals(driver.getTitle(),"My Store");


    }
}
