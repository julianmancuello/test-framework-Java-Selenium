package tests;

import common.CommonSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutConfirmationTests extends CommonSteps {

    @BeforeEach
    public void commonStepsForCheckoutConfirmationTests() {
        checkoutConfirmationPage = fillInformationFormAndProceedToCheckoutConfirmation();
    }

    @Test
    public void testCheckTitleOnCheckoutConfirmationPage() {
        assertEquals(CHECKOUT_CONF_PAGE_TITLE, checkoutConfirmationPage.getPageTitle(), "Checkout Confirmation page title is incorrect");
        System.out.println("Checkout Confirmation page title is correct.");
    }

    @Test
    public void testCheckSubtitleOfConceptsOnCheckoutConfirmationPage() {
        assertEquals(PAYMENT_INFO_TITLE, checkoutConfirmationPage.getPaymentInformationTitle(), "The subtitle 'Payment Information' is incorrect");
        assertEquals(SHIPPING_INFO_TITLE, checkoutConfirmationPage.getShippingInformationTitle(), "The subtitle 'Shipping Information' is incorrect");
        assertEquals(PRICE_TOTAL_TITLE, checkoutConfirmationPage.getPriceTotalTitle(), "The subtitle 'Price Total' is incorrect");
        System.out.println("The subtitle of the concepts on the Checkout Confirmation page are correct");
    }

    @Test
    public void testProductsInformationDisplayedInCheckoutMatchesWithSelectedProducts() {
        assertTrue(checkoutConfirmationPage.isProductInformationInCheckoutCorrect(), "The products information in the checkout do not match the selected products.");
        System.out.println("The products information in the checkout matches the selected products.");
    }

    @Test
    public void testCheckValueOfSubtotalTaxAndTotal() {
        assertTrue(checkoutConfirmationPage.isTheValueOfSubtotalTaxAndTotalCorrect(), "The subtotal, tax and total values displayed on the page do not match the calculated values");
        System.out.println("The subtotal, tax and total values displayed on the page matches the calculated values");
    }
}
