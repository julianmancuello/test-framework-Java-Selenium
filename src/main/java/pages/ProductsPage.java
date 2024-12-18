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
    }

    public boolean isAddToCartButtonChangedToRemove(){
        List<Integer> listOfIndexes = ContextStore.get("listOfIndexes");

        for(Integer index : listOfIndexes){
            if(!getText(addToCartButton.get(index)).equals("Remove")){
                return false;
            }
        }
        return true;
    }

    public boolean isCartBadgeCountEqualToQuantityOfSelectedProducts(){
        List<Integer> listOfIndexes = ContextStore.get("listOfIndexes");
        int quantityOfProducts = Integer.parseInt(getText(cartBadge));
        return isNumberEqualToNumber(listOfIndexes.size(), quantityOfProducts);
    }

    public CartPage clickCart(){
        click(cartButton);
        return new CartPage(driver);
    }
}