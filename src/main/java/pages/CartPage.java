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
        return isEachStringInListPresentInPage(productName, selectedProductNames);
    }

    public boolean isPriceOfEachSelectedProductInCartCorrect(){
        List<Double> selectedProductPrices = ContextStore.get("selectedProductPrices");
        return isEachDoubleInListPresentInPage(productPrice, selectedProductPrices);
    }

    public boolean isProductInformationInCartCorrect(){
        return isEachSelectedProductPresentInCart() && isPriceOfEachSelectedProductInCartCorrect();
    }

    public CheckoutInformationPage clickCheckoutButton(){
        click(checkoutButton);
        return new CheckoutInformationPage(driver);
    }

    public void clickContinueShoppingButton(){
        click(continueShoppingButton);
    }
}