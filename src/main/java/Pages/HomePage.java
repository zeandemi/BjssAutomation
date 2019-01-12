package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;
    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[2]/span")
    WebElement blouseQuickImage;
    @FindBy(how = How.XPATH, using = "//*[@id=\"homefeatured\"]/li[2]/div/div[1]/div/a[1]/img")
    WebElement blouseImage;
    @FindBy(how = How.LINK_TEXT, using = "BEST SELLERS")
    WebElement bestSellerView;
    JavascriptExecutor js;
    Actions action;


    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickOnQuickView() throws InterruptedException {
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

    }

}
