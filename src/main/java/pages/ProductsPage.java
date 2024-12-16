package pages;

import context.ContextStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static common.Utils.*;

public class ProductsPage extends BasePage {

    @FindBy(id = "shopping_cart_container")
    WebElement cartButton;
    @FindBy(className = "title")
    WebElement pageTitle;
    @FindBy(id = "react-burger-menu-btn")
    WebElement menuButton;
    @FindBy(className = "bm-menu")
    WebElement menuPanel;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutButton;
    @FindBy(className = "btn_small")
    List<WebElement> addToCartButton;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;
    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrice;
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    public ProductsPage(WebDriver driver){
        super(driver);
    }

    public String getPageTitle(){
        return getText(pageTitle);
    }

    public void clickMenu(){
        click(menuButton);
    }

    public boolean isMenuOpen(){
        if(isDisplayed(menuPanel)){
            return true;
        }
        System.out.println("The menu is not open");
        return false;
    }

    public boolean isLogoutDisplayed(){
        if(isDisplayed(logoutButton)){
            return true;
        }
        System.out.println("The logout button is not displayed");
        return false;
    }

    public void addToCartNRandomProducts(){
        int quantityOfProducts = generateRandomPositiveInteger(productName.size());
        List<Integer> listOfIndexes = generateRandomListOfIndexes(quantityOfProducts, productName.size(), true);
        List<String> selectedProductNames = new ArrayList<>();
        List<Double> selectedProductPrices = new ArrayList<>();

        for(Integer index : listOfIndexes){
            click(addToCartButton.get(index));
            selectedProductNames.add(getText(productName.get(index)));
            selectedProductPrices.add(parsePrice(getText(productPrice.get(index))));
        }

        ContextStore.put("listOfIndexes", listOfIndexes);
        ContextStore.put("selectedProductNames", selectedProductNames);
        ContextStore.put("selectedProductPrices", selectedProductPrices);
        System.out.println("Quantity of selected products: " + quantityOfProducts);
        System.out.println("List of selected products: " + selectedProductNames);
        System.out.println("Prices of selected products: " + selectedProductPrices);
        System.out.println("Cost of selected products: " + sumListOfNumbers(selectedProductPrices));
    }

    public boolean isAddToCartButtonChangedToRemove(){
        List<Integer> listOfIndexes = ContextStore.get("listOfIndexes");

        for(Integer index : listOfIndexes){
            if(!getText(addToCartButton.get(index)).equals("Remove")){
                System.out.println("The buttons did not change.");
                return false;
            }
        }
        return true;
    }

    public boolean isCartBadgeCountEqualToQuantityOfSelectedProducts(){
        List<Integer> listOfIndexes = ContextStore.get("listOfIndexes");
        int quantityOfProducts = Integer.parseInt(getText(cartBadge));
        if(isNumberEqualToNumber(listOfIndexes.size(), quantityOfProducts)){
            return true;
        }
        System.out.println("The count displayed on the cart badge " + quantityOfProducts + " does not match the calculated quantity of products " + listOfIndexes.size());
        return false;
    }

    public CartPage clickCart(){
        click(cartButton);
        return new CartPage(driver);
    }
}