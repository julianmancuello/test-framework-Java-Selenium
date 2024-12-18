package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTests extends Hooks {

    @Test
    public void testCheckTitleOnCartPage(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        CartPage cartPage = productsPage.clickCart();

        assertEquals(CART_PAGE_TITLE, cartPage.getPageTitle(), "Cart page title is incorrect.");
        System.out.println("Cart page title is correct");
    }

    @Test
    public void addProductToCart(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);

        productsPage.addToCartNRandomProducts();


        CartPage cartPage = productsPage.clickCart();

        System.out.println("User enters the cart page");
        assertTrue(cartPage.isEachSelectedProductPresentInCart());
        assertTrue(cartPage.isPriceOfEachSelectedProductInCartCorrect());
        System.out.println("Everything was successfully added to the cart");
        cartPage.clickContinueShoppingButton();
        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("The user is back on the products page");
    }
}
