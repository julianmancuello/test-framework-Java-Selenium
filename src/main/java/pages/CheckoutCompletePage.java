package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

    @FindBy(className = "title")
    WebElement pageTitle;
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

    public String getPageTitle(){
        return getText(pageTitle);
    }

    public boolean isGreenTickDisplayed(){
        if(isDisplayed(greenTick)){
            return true;
        }
        System.out.println("The green tick is not displayed");
        return false;
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