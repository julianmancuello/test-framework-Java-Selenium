package tests;

import common.CommonSteps;
import extensions.AfterTestExecutionLogger;
import extensions.BeforeTestExecutionLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({BeforeTestExecutionLogger.class, AfterTestExecutionLogger.class})
public class CheckoutCompleteTests extends CommonSteps {

    @BeforeEach
    public void commonStepsForCheckoutCompleteTests() {
        checkoutCompletePage = proceedToCompleteTheCheckout();
    }

    @Test
    @Tag("smoke")
    public void testCheckTitleOnCheckoutCompletePage() {
        assertEquals(CHECKOUT_COMPL_PAGE_TITLE, checkoutCompletePage.getPageTitle(), "Checkout Complete page title is incorrect");
        System.out.println("Checkout Complete page title is correct.");
    }

    @Test
    @Tag("smoke")
    public void testGreenTickIsDisplayedAfterCheckout() {
        assertTrue(checkoutCompletePage.isGreenTickDisplayed(), "The green tick is not displayed after the checkout");
        System.out.println("The green tick is displayed after the checkout");
    }

    @Test
    @Tag("smoke")
    public void testTextsDisplayedAfterCheckoutAreAsExpected() {
        assertEquals(SUCCESSFUL_HEADER, checkoutCompletePage.getSuccessfulHeader(), "Success header is incorrect");
        assertEquals(SUCCESSFUL_MSG, checkoutCompletePage.getSuccessfulMessage(), "The success message is incorrect");
        System.out.println("The texts displayed after the checkout are correct");
    }

    @Test
    @Tag("regression")
    public void testCompleteCheckoutSuccessfully() {
        assertEquals(CHECKOUT_COMPL_PAGE_URL, checkoutCompletePage.getCurrentUrl(), "Error: Purchase not completed");
        System.out.println("Purchase completed successfully");
    }

    @Test
    @Tag("regression")
    public void testBackHomeFromCheckoutCompletePage() {
        checkoutCompletePage.clickBackHomeButton();

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "The user was unable to return to the Products Page.");
        System.out.println("The user is back on the Products Page");
    }
}
