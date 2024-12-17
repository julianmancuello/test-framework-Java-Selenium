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

    private final int ERROR_ICONS_DISPLAYED = 2;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return getText(pageTitle);
    }

    public void setUsername(String username){
        type(usernameField, username);
    }

    public void setPassword(String password){
        type(passwordField, password);
    }

    public ProductsPage clickLoginButton(){
        click(loginButton);
        return new ProductsPage(driver);
    }

    public boolean isErrorIconDisplayed(){
        if(isNumberEqualToNumber(errorIcon.size(), ERROR_ICONS_DISPLAYED)){
            return isEachWebElementDisplayed(errorIcon);
        }
        return false;
    }

    public String getLoginErrorMessage(){
        return getText(loginErrorMessage);
    }

    public ProductsPage fillLoginForm(String username, String password){
        setUsername(username);
        setPassword(password);
        return clickLoginButton();
    }
}
