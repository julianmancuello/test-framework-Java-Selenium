package tests;

import common.CommonSteps;
import extensions.TestExecutionLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static data.TestData.CART_PAGE_TITLE;
import static data.TestData.PRODUCTS_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(TestExecutionLogger.class)
public class CartTests extends CommonSteps {

    @Test
    public void testCheckTitleOnCartPage() {
        cartPage = goToCartWithoutAddingProducts();

        assertEquals(CART_PAGE_TITLE, cartPage.getPageTitle(), "Cart page title is incorrect.");
        System.out.println("Cart page title is correct.");
    }

    @Test
    public void testProductsInformationDisplayedInCartMatchesWithSelectedProducts() {
        cartPage = goToCartAddingProducts();

        assertTrue(cartPage.isProductInformationInCartCorrect(), "The products information in the cart do not match the selected products.");
        System.out.println("The products information in the cart matches the selected products.");
    }

    @Test
    public void testContinueShoppingFromCart() {
        cartPage = goToCartWithoutAddingProducts();
        cartPage.clickContinueShoppingButton();

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "It was not possible to return to the Products page.");
        System.out.println("The user returned to the Products page and can continue shopping.");
    }
}
