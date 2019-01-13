package Pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class HomePage {

    private final WebDriver driver;
    @FindBy(how = How.CLASS_NAME, using = "login")
    WebElement signIn;
    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[2]/span")
    WebElement blouseQuickImage;
    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
    WebElement blouseImage;
    @FindBy(how = How.LINK_TEXT, using = "BEST SELLERS")
    WebElement bestSellerView;
    JavascriptExecutor js;
    Actions action;
    AuthenticationPage authenticationPage;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage logIn(String username, String password) throws InterruptedException {
        authenticationPage = clickSignIn();
        authenticationPage.verifyAuthenticationPageTitle().signIn(username,password).verifyAccountPageTitle().clickOnReturnToHomeButtom();
        return this;
    }


    public AuthenticationPage clickSignIn(){
        signIn.click();
        return new AuthenticationPage(driver);
    }

    public HomePage clickOnQuickView() throws InterruptedException {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", bestSellerView);
        Thread.sleep(3000);
        action = new Actions(driver);
        action.moveToElement(blouseImage).perform();
        Thread.sleep(3000);
        action.moveToElement(blouseQuickImage).perform();
        Thread.sleep(2000);
        try {
            if (blouseQuickImage.isDisplayed() && blouseQuickImage.isEnabled()) {
                blouseQuickImage.click();
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;

    }

    public HomePage changeBlouseSize() {
        switchHandle();

        return this;
    }

    private void switchHandle() {
        boolean p = true;
        String parentHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            if (handle.equals(parentHandle)) {
                Assert.assertTrue(p);
            } else {
                driver.getWindowHandle();
            }
        }
    }

}
