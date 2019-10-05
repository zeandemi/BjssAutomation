package Pages;


import Utility.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;

public class AuthenticationPage {

    private final WebDriver driver;

    @FindBy(how = How.XPATH, using = "//*[@id=\"email\"]")
    WebElement emailAddressElement;

    @FindBy(how = How.XPATH, using = "//*[@id=\"passwd\"]")
    WebElement passwordElement;

    @FindBy(how = How.XPATH, using = "//*[@id=\"SubmitLogin\"]")
    WebElement submitElement;

    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/h1")
    WebElement authPageElement;

    public AuthenticationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        Wait.untilPageLoadComplete(driver);
    }

    public AccountPage signIn(String emailAddress, String password) throws InterruptedException {
        Thread.sleep(2000);
        emailAddressElement.sendKeys(emailAddress);
        passwordElement.sendKeys(password);
        submitElement.click();
        Wait.untilJqueryIsDone(driver);
        return new AccountPage(driver);
    }

    public AuthenticationPage verifyAuthenticationPageTitle() {
        String actualMessage = authPageElement.getText();
        String expectedMessage = "AUTHENTICATION";
        AssertJUnit.assertEquals(actualMessage,expectedMessage);
        return new AuthenticationPage(driver);
    }
}
