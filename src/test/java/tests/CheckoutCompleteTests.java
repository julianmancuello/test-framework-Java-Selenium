package tests;

import hooks.Hooks;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutCompleteTests extends Hooks {

    private CheckoutCompletePage checkoutCompletePage;

    @BeforeEach
    public void commonStepsForCheckoutCompleteTests(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        checkoutCompletePage = checkoutConfirmationPage.clickFinishButton();
    }

    @Test
    public void testCheckTitleOnCheckoutCompletePage(){

        assertEquals(CHECKOUT_COMPL_PAGE_TITLE, checkoutCompletePage.getPageTitle(), "Checkout Complete page title is incorrect");
        System.out.println("Checkout Complete page title is correct.");
    }

    @Test
    public void testGreenTickIsDisplayedAfterCheckout(){

        assertTrue(checkoutCompletePage.isGreenTickDisplayed(), "The green tick is not displayed after the checkout");
        System.out.println("The green tick is displayed after the checkout");
    }

    @Test
    public void testTextsDisplayedAfterCheckoutAreAsExpected(){

        assertEquals(SUCCESSFUL_HEADER, checkoutCompletePage.getSuccessfulHeader(), "Success header is incorrect");
        assertEquals(SUCCESSFUL_MSG, checkoutCompletePage.getSuccessfulMessage(), "The success message is incorrect");
        System.out.println("The texts displayed after the checkout are correct");
    }

    @Test
    public void testCompleteCheckoutSuccessfully(){

        assertEquals(CHECKOUT_COMPL_PAGE_URL, checkoutCompletePage.getCurrentUrl(), "Error: Purchase not completed");
        System.out.println("Purchase completed successfully");
    }

    @Test
    public void testBackHomeFromCheckoutCompletePage(){
        checkoutCompletePage.clickBackHomeButton();

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "The user was unable to return to the Products Page.");
        System.out.println("The user is back on the Products Page");
    }
}
