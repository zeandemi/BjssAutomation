package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"center_column\"]/div/p/strong")
    WebElement confirmationMessage;

    public OrderConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void confirmOrderMessage(){
        String expectedMessage = "Your order on My Store is complete.";
        String actualMessage = confirmationMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }


}
