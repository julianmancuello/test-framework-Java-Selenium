package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "pony_express")
    WebElement greenTick;
    @FindBy(className = "complete-header")
    WebElement successfulHeader;
    @FindBy(className = "complete-text")
    WebElement successfulMessage;
    @FindBy(id = "back-to-products")
    WebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver){
        super(driver);
    }

    public boolean isGreenTickDisplayed(){
        return isDisplayed(greenTick);
    }

    public String getSuccessfulHeader(){
        return getText(successfulHeader);
    }

    public String getSuccessfulMessage(){
        return getText(successfulMessage);
    }

    public void clickBackHomeButton(){
        click(backHomeButton);
    }
}