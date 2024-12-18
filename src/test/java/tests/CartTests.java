package tests;

import hooks.Hooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTests extends Hooks {

    private ProductsPage productsPage;

    @BeforeEach
    public void commonStepsForProductsTests(){
        productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
    }

    @Test
    public void testCheckTitleOnCartPage(){
        CartPage cartPage = productsPage.clickCart();

        assertEquals(CART_PAGE_TITLE, cartPage.getPageTitle(), "Cart page title is incorrect.");
        System.out.println("Cart page title is correct.");
    }

    @Test
    public void testProductsInformationDisplayedInCartMatchesWithSelectedProducts(){
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();

        assertTrue(cartPage.isProductInformationInCartCorrect(), "The products information in the cart do not match the selected products.");
        System.out.println("The products information in the cart matches the selected products.");
    }

    @Test
    public void testContinueShoppingFromCart(){
        CartPage cartPage = productsPage.clickCart();
        cartPage.clickContinueShoppingButton();

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "It was not possible to return to the Products page.");
        System.out.println("The user returned to the Products page and can continue shopping.");
    }
}
