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
    @Parameters({"username","password","size"})
    public void purchase2Items(String username, String password,String size) throws InterruptedException {
        driver = getDriver();
        homePage = new HomePage(driver);
        Assert.assertEquals(driver.getTitle(),"My Store");
        homePage.logIn(username,password).clickOnBlouseQuickView().changeBlouseSize(size).clickOnContinueShoppingTab()
                .clickOnPrintedDressQuickView().viewBasketAndConfirm().clickOnCheckOutTab()
        .clickOnProceedToCheckOutTab().clickOnAddressPageProceedToCheckOut().clickOnShippingPageProceedToCheckOut()
        .clickOnPayByWire().clickOnIConfirmOrder().confirmOrderMessage();



    }
}
