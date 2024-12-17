package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;

import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsTests extends Hooks {

    @Test
    public void testCheckTitleOnProductsPage(){
        ProductsPage productsPage = loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);

        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        System.out.println("Products page title is correct");
    }
}
