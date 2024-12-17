package pages;

import context.ContextStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static common.Utils.*;

public class CartPage extends BasePage {

    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;
    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrice;
    @FindBy(id = "checkout")
    WebElement checkoutButton;
    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    public CartPage(WebDriver driver){
        super(driver);
    }

    public boolean isEachSelectedProductPresentInCart(){
        List<String> selectedProductNames = ContextStore.get("selectedProductNames");
        if(isEachStringInListPresentInPage(productName, selectedProductNames)){
            System.out.println("Each selected product is present on the cart page.");
            return true;
        }
        System.out.println("The selected products are not present on the cart page.");
        return false;
    }

    public boolean isPriceOfEachSelectedProductInCartCorrect(){
        List<Double> selectedProductPrices = ContextStore.get("selectedProductPrices");
        if(isEachDoubleInListPresentInPage(productPrice, selectedProductPrices)){
            System.out.println("The price of each selected product is correct on the cart page.");
            return true;
        }
        System.out.println("The prices displayed on the cart page are incorrect.");
        return false;
    }

    public CheckoutInformationPage clickCheckoutButton(){
        click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }

    public void clickContinueShoppingButton(){
        click(continueShoppingButton);
    }
}