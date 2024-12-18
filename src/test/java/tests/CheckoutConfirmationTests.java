package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckoutConfirmationPage;
import pages.CheckoutInformationPage;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutConfirmationTests extends Hooks {

    @Test
    public void testCheckTitleOnCheckoutConfirmationPage(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);

        assertEquals(CHECKOUT_CONF_PAGE_TITLE, checkoutConfirmationPage.getPageTitle(), "Checkout Confirmation page title is incorrect");
        System.out.println("Checkout Confirmation page title is correct.");
    }

    @Test
    public void testCheckSubtitleOfConceptsOnCheckoutConfirmationPage(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);

        assertEquals(PAYMENT_INFO_TITLE, checkoutConfirmationPage.getPaymentInformationTitle(), "The subtitle 'Payment Information' is incorrect");
        assertEquals(SHIPPING_INFO_TITLE, checkoutConfirmationPage.getShippingInformationTitle(), "The subtitle 'Shipping Information' is incorrect");
        assertEquals(PRICE_TOTAL_TITLE, checkoutConfirmationPage.getPriceTotalTitle(), "The subtitle 'Price Total' is incorrect");
        System.out.println("The subtitle of the concepts on the Checkout Confirmation page are correct");
    }

    @Test
    public void testProductsAndTheirPricesAreCorrectInCheckout(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);

        assertTrue(checkoutConfirmationPage.isEachSelectedProductPresentInCheckout(), "The selected products are not present on the checkout confirmation page.");
        assertTrue(checkoutConfirmationPage.isPriceOfEachSelectedProductInCheckoutCorrect(), "The prices displayed on the checkout confirmation page are incorrect.");
        System.out.println("The products and prices displayed on the checkout confirmation page are correct.");
    }

    @Test
    public void testCheckValueOfSubtotalTaxAndTotal(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
        productsPage.addToCartNRandomProducts();
        CartPage cartPage = productsPage.clickCart();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckoutButton();
        CheckoutConfirmationPage checkoutConfirmationPage = checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);

        assertTrue(checkoutConfirmationPage.isTheValueOfSubtotalTaxAndTotalCorrect(), "The subtotal, tax and total values displayed on the page do not match the calculated values");
        System.out.println("The subtotal, tax and total values displayed on the page matches the calculated values");
    }
}
