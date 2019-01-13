package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1")
    WebElement myAccountPageElement;

    @FindBy(how = How.XPATH, using = "//*[@id=\"columns\"]/div[1]/a/i")
    WebElement homeElement;

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage clickOnReturnToHomeButtom() {
        homeElement.click();
        return new HomePage(driver);
    }

    public AccountPage verifyAccountPageTitle() throws InterruptedException {
        Thread.sleep(2000);
        String actualMessage = myAccountPageElement.getText();
        String expectedMessage = "MY ACCOUNT";
        Assert.assertEquals(actualMessage, expectedMessage);
        return new AccountPage(driver);
    }
}
