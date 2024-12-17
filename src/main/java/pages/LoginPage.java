package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static common.Utils.*;

public class LoginPage extends BasePage {

    @FindBy(className = "login_logo")
    WebElement pageTitle;
    @FindBy(id = "user-name")
    WebElement usernameField;
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(className = "error_icon")
    List<WebElement> errorIcon;
    @FindBy(className = "error-message-container")
    WebElement loginErrorMessage;

    private final int EXPECTED_ERROR_ICONS = 2;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public void setUsername(String username) {
        type(usernameField, username);
    }

    public void setPassword(String password) {
        type(passwordField, password);
    }

    public ProductsPage clickLoginButton() {
        click(loginButton);
        return new ProductsPage(driver);
    }

    public boolean isErrorIconDisplayed() {
        return isListSizeEqualToExpectedNumber(errorIcon, EXPECTED_ERROR_ICONS);
    }

    public String getLoginErrorMessage() {
        return getText(loginErrorMessage);
    }

    public ProductsPage fillLoginForm(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
}
