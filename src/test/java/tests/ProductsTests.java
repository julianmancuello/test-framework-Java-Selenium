package tests;

import hooks.Hooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductsTests extends Hooks {

    private ProductsPage productsPage;

    @BeforeEach
    public void commonStepsForProductsTests(){
        productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
    }

    @Test
    public void testCheckTitleOnProductsPage(){

        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("Products page title is correct");
    }

    @Test
    public void testAddToCartButtonChangesToRemoveAfterAddingProductToCart(){
        productsPage.addToCartNRandomProducts();

        assertTrue(productsPage.isAddToCartButtonChangedToRemove(), "The buttons did not change to 'Remove'.");
        System.out.println("The buttons changed to 'Remove'.");
    }

    @Test
    public void testCartBadgeCountDisplaysTheCorrectQuantityOfSelectedProducts(){
        productsPage.addToCartNRandomProducts();

        assertTrue(productsPage.isCartBadgeCountEqualToQuantityOfSelectedProducts(), "The count displayed on the cart badge does not match the quantity of selected products");
        System.out.println("The count displayed on the cart badge matches the quantity of selected products");
    }
}
