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
        System.out.println("Cart page title is correct.");
    }

    @Test
    public void testProductsAndTheirPricesAddedToCartCorrectly(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();

        assertTrue(cartPage.isEachSelectedProductPresentInCart(), "The selected products are not present on the cart page.");
        assertTrue(cartPage.isPriceOfEachSelectedProductInCartCorrect(), "The prices displayed on the cart page are incorrect.");
        System.out.println("Products were added to the cart successfully.");
    }

    @Test
    public void testContinueShoppingFromCart(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        CartPage cartPage = productsPage.clickCart();
        cartPage.clickContinueShoppingButton();

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "It was not possible to return to the Products page.");
        System.out.println("The user returned to the Products page and can continue shopping.");
    }
}
