package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.*;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutTests extends Hooks {

    @Test
    public void testCheckoutSuccessful(){
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Home page title is incorrect");
        loginPage.setUsername(USER_STANDARD);
        loginPage.setPassword(MASTER_PASSWORD);
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("User logged in successfully and is on the products page");
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        assertEquals(CART_PAGE_TITLE, cartPage.getPageTitle(), "Cart page title is incorrect");
        System.out.println("User enters the cart page");
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        assertEquals(CHECKOUT_INFO_PAGE_TITLE, checkoutInformationPage.getPageTitle(), "Checkout Information page title is incorrect");
        System.out.println("User enters the checkout information page");
        checkoutInformationPage.setFirstName(FIRST_NAME);
        checkoutInformationPage.setLastName(LAST_NAME);
        checkoutInformationPage.setPostalCode(POSTAL_CODE);
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.clickContinueButton();
        assertEquals(CHECKOUT_CONF_PAGE_TITLE, checkoutConfirmationPage.getPageTitle(), "Checkout Confirmation page title is incorrect");
        System.out.println("User enters the checkout confirmation page");
        assertTrue(checkoutConfirmationPage.isEachSelectedProductPresentInCheckout());
        assertTrue(checkoutConfirmationPage.isPriceOfEachSelectedProductInCheckoutCorrect());
        assertEquals(PAYMENT_INFO_TITLE, checkoutConfirmationPage.getPaymentInformationTitle(), "The title 'Payment Information' is incorrect");
        assertEquals(SHIPPING_INFO_TITLE, checkoutConfirmationPage.getShippingInformationTitle(), "The title 'Shipping Information' is incorrect");
        assertEquals(PRICE_TOTAL_TITLE, checkoutConfirmationPage.getPriceTotalTitle(), "The title 'Price Total' is incorrect");
        assertTrue(checkoutConfirmationPage.isSubtotalCorrect());
        assertTrue(checkoutConfirmationPage.isTaxAmountCorrect());
        assertTrue(checkoutConfirmationPage.isTotalCorrect());
        CheckoutCompletePage checkoutCompletePage = checkoutConfirmationPage.clickFinishButton();
        assertEquals(CHECKOUT_COMPL_PAGE_TITLE, checkoutCompletePage.getPageTitle(), "Checkout Complete page title is incorrect");
        assertTrue(checkoutCompletePage.isGreenTickDisplayed());
        assertEquals(SUCCESSFUL_HEADER, checkoutCompletePage.getSuccessfulHeader(), "Success header is incorrect");
        assertEquals(SUCCESSFUL_MSG, checkoutCompletePage.getSuccessfulMessage(), "The success message is incorrect");
        System.out.println("Purchase completed successfully");
        checkoutCompletePage.clickBackHomeButton();
        assertEquals("Products", productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("The user is back on the products page");
    }
}
