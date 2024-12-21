package tests;

import common.CommonSteps;
import extensions.TestExecutionLogger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static data.TestData.CHECKOUT_INFO_PAGE_TITLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestExecutionLogger.class)
public class CheckoutInformationTests extends CommonSteps {

    @BeforeEach
    public void commonStepsForCheckoutInformationTests() {
        checkoutInformationPage = afterAddingProductsToCartProceedToCheckoutInformation();
    }

    @Test
    public void testCheckTitleOnCheckoutInformationPage() {
        assertEquals(CHECKOUT_INFO_PAGE_TITLE, checkoutInformationPage.getPageTitle(), "Checkout Information page title is incorrect.");
        System.out.println("Checkout Information page title is correct.");
    }
}
