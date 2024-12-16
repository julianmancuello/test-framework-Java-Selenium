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
        assertEquals("Swag Labs", homePage.getPageTitle(), "Home page title is incorrect");
        homePage.setUsername(USER_STANDARD);
        homePage.setPassword(MASTER_PASSWORD);
        ProductsPage productsPage = homePage.clickLoginButton();
        assertEquals("Products", productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("User logged in successfully and is on the products page");
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        assertEquals("Your Cart", cartPage.getPageTitle(), "Cart page title is incorrect");
        System.out.println("User enters the cart page");
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        assertEquals("Checkout: Your Information", checkoutInformationPage.getPageTitle(), "Checkout Information page title is incorrect");
        System.out.println("User enters the checkout information page");
        checkoutInformationPage.setFirstName(FIRST_NAME);
        checkoutInformationPage.setLastName(LAST_NAME);
        checkoutInformationPage.setPostalCode(POSTAL_CODE);
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.clickContinueButton();
        assertEquals("Checkout: Overview", checkoutConfirmationPage.getPageTitle(), "Checkout Confirmation page title is incorrect");
        System.out.println("User enters the checkout confirmation page");
        assertTrue(checkoutConfirmationPage.isEachSelectedProductPresentInCheckout());
        assertTrue(checkoutConfirmationPage.isPriceOfEachSelectedProductInCheckoutCorrect());
        assertEquals("Payment Information:", checkoutConfirmationPage.getPaymentInformationTitle(), "The title 'Payment Information' is incorrect");
        assertEquals("Shipping Information:", checkoutConfirmationPage.getShippingInformationTitle(), "The title 'Shipping Information' is incorrect");
        assertEquals("Price Total", checkoutConfirmationPage.getPriceTotalTitle(), "The title 'Price Total' is incorrect");
        assertTrue(checkoutConfirmationPage.isSubtotalCorrect());
        assertTrue(checkoutConfirmationPage.isTaxAmountCorrect());
        assertTrue(checkoutConfirmationPage.isTotalCorrect());
        CheckoutCompletePage checkoutCompletePage = checkoutConfirmationPage.clickFinishButton();
        assertEquals("Checkout: Complete!", checkoutCompletePage.getPageTitle(), "Checkout Complete page title is incorrect");
        assertTrue(checkoutCompletePage.isGreenTickDisplayed());
        assertEquals("Thank you for your order!", checkoutCompletePage.getSuccessfulHeader(), "Success header is incorrect");
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutCompletePage.getSuccessfulMessage(), "The success message is incorrect");
        System.out.println("Purchase completed successfully");
        checkoutCompletePage.clickBackHomeButton();
        assertEquals("Products", productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("The user is back on the products page");
    }
}
