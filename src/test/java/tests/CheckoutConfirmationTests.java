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
public class CheckoutConfirmationTests extends CommonSteps {

    @BeforeEach
    public void commonStepsForCheckoutConfirmationTests() {
        checkoutConfirmationPage = fillInformationFormAndProceedToCheckoutConfirmation();
    }

    @Test
    @Tag("smoke")
    public void testCheckTitleOnCheckoutConfirmationPage() {
        assertEquals(CHECKOUT_CONF_PAGE_TITLE, checkoutConfirmationPage.getPageTitle(), "Checkout Confirmation page title is incorrect");
        System.out.println("Checkout Confirmation page title is correct.");
    }

    @Test
    @Tag("smoke")
    public void testCheckSubtitleOfConceptsOnCheckoutConfirmationPage() {
        assertEquals(PAYMENT_INFO_TITLE, checkoutConfirmationPage.getPaymentInformationTitle(), "The subtitle 'Payment Information' is incorrect");
        assertEquals(SHIPPING_INFO_TITLE, checkoutConfirmationPage.getShippingInformationTitle(), "The subtitle 'Shipping Information' is incorrect");
        assertEquals(PRICE_TOTAL_TITLE, checkoutConfirmationPage.getPriceTotalTitle(), "The subtitle 'Price Total' is incorrect");
        System.out.println("The subtitle of the concepts on the Checkout Confirmation page are correct");
    }

    @Test
    @Tag("regression")
    public void testProductsInformationDisplayedInCheckoutMatchesWithSelectedProducts() {
        assertTrue(checkoutConfirmationPage.isProductInformationInCheckoutCorrect(), "The products information in the checkout do not match the selected products.");
        System.out.println("The products information in the checkout matches the selected products.");
    }

    @Test
    @Tag("regression")
    public void testCheckValueOfSubtotalTaxAndTotal() {
        assertTrue(checkoutConfirmationPage.isTheValueOfSubtotalTaxAndTotalCorrect(), "The subtotal, tax and total values displayed on the page do not match the calculated values");
        System.out.println("The subtotal, tax and total values displayed on the page matches the calculated values");
    }
}
