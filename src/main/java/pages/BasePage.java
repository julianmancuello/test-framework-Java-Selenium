package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static common.Utils.*;

public class BasePage {

    protected WebDriver driver;
    private final int STD_TIMEOUT_SEC = 10;
    private final int POLLING_EVERY_MS = 100;

    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FluentWait<WebDriver> fluentWait(){
        return new WebDriverWait(driver, Duration.ofSeconds(STD_TIMEOUT_SEC)).pollingEvery(Duration.ofMillis(POLLING_EVERY_MS));
    }

    public void waitForElementToBeVisible(WebElement webElement){
        fluentWait().until(driver -> webElement.isDisplayed());
    }

    public void customWaitForElement(By locator, int timeoutInMs, int pollingIntervalInMs){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutInMs))
                .pollingEvery(Duration.ofMillis(pollingIntervalInMs))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void click(WebElement webElement){
        waitForElementToBeVisible(webElement);
        webElement.click();
    }

    public void type(WebElement webElement, String text){
        try{
            waitForElementToBeVisible(webElement);
            webElement.sendKeys(text);
            System.out.println("Typed '" + text + "' in the element: " + extractLocatorFromWebElement(webElement));
        }catch(ElementNotInteractableException e){
            throw new ElementNotInteractableException("Cannot interact with element: " + webElement, e);
        }
    }

    public String getText(WebElement webElement){
        try{
            waitForElementToBeVisible(webElement);
            return webElement.getText();
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("Failed to get text for element: " + webElement, e);
        }
    }

    public boolean isDisplayed(WebElement webElement){
        try{
            waitForElementToBeVisible(webElement);
            return webElement.isDisplayed();
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("Could not find element: " + webElement, e);
        }
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
