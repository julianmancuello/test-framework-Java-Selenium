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
    public void addProductToCart(){
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Home page title is incorrect");
        loginPage.setUsername(USER_STANDARD);
        loginPage.setPassword(MASTER_PASSWORD);
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("User logged in successfully and is on the products page");
        productsPage.addToCartNRandomProducts();
        assertTrue(productsPage.isAddToCartButtonChangedToRemove());
        assertTrue(productsPage.isCartBadgeCountEqualToQuantityOfSelectedProducts());
        CartPage cartPage = productsPage.clickCart();
        assertEquals(CART_PAGE_TITLE, cartPage.getPageTitle(), "Cart page title is incorrect.");
        System.out.println("User enters the cart page");
        assertTrue(cartPage.isEachSelectedProductPresentInCart());
        assertTrue(cartPage.isPriceOfEachSelectedProductInCartCorrect());
        System.out.println("Everything was successfully added to the cart");
        cartPage.clickContinueShoppingButton();
        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("The user is back on the products page");
    }
}
