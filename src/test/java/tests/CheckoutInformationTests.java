package tests;

import hooks.Hooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutInformationPage;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutInformationTests extends Hooks {

    private CheckoutInformationPage checkoutInformationPage;

    @BeforeEach
    public void commonStepsForCheckoutInformationTests(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        checkoutInformationPage = cartPage.clickCheckoutButton();
    }

    @Test
    public void testCheckTitleOnCheckoutInformationPage(){

        assertEquals(CHECKOUT_INFO_PAGE_TITLE, checkoutInformationPage.getPageTitle(), "Checkout Information page title is incorrect.");
        System.out.println("Checkout Information page title is correct.");
    }
}
