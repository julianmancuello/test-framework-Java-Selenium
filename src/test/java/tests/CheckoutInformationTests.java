package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutInformationTests extends Hooks {

    @Test
    public void testCheckTitleOnCheckoutInformationPage(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();

        assertEquals(CHECKOUT_INFO_PAGE_TITLE, checkoutInformationPage.getPageTitle(), "Checkout Information page title is incorrect.");
        System.out.println("Checkout Information page title is correct.");
    }
}
