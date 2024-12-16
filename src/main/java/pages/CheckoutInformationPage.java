package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInformationPage extends BasePage {

    @FindBy(className = "title")
    WebElement pageTitle;
    @FindBy(id = "first-name")
    WebElement firstNameField;
    @FindBy(id = "last-name")
    WebElement lastNameField;
    @FindBy(id = "postal-code")
    WebElement postalCodeField;
    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutInformationPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return getText(pageTitle);
    }

    public void setFirstName(String firstName){
        type(firstNameField, firstName);
    }

    public void setLastName(String lastName){
        type(lastNameField, lastName);
    }

    public void setPostalCode(String postalCode){
        type(postalCodeField, postalCode);
    }

    public CheckoutConfirmationPage clickContinueButton(){
        click(continueButton);
        return new CheckoutConfirmationPage(driver);
    }
}