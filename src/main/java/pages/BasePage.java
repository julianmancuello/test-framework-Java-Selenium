package pages;

import context.ContextStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BasePage {

    @FindBy(className = "title")
    WebElement stdPageTitle;

    protected WebDriver driver;
    private final int STD_TIMEOUT_SEC = Integer.parseInt(ContextStore.get("std-timeout-sec"));
    private final int POLLING_EVERY_MS = Integer.parseInt(ContextStore.get("polling-every-ms"));

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public FluentWait<WebDriver> fluentWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(STD_TIMEOUT_SEC)).pollingEvery(Duration.ofMillis(POLLING_EVERY_MS));
    }

    public void waitForElementToBeVisible(WebElement webElement) {
        fluentWait().until(driver -> webElement.isDisplayed());
    }

    public void customWaitForElement(By locator, int timeoutInMs, int pollingIntervalInMs) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(timeoutInMs))
                .pollingEvery(Duration.ofMillis(pollingIntervalInMs))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void click(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        webElement.click();
    }

    public void type(WebElement webElement, String text) {
        waitForElementToBeVisible(webElement);
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        return webElement.getText();
    }

    public boolean isDisplayed(WebElement webElement) {
        waitForElementToBeVisible(webElement);
        return webElement.isDisplayed();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return getText(stdPageTitle);
    }
}
