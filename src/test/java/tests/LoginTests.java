package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;

import static common.Utils.*;
import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTests extends Hooks {

    @Test
    public void testLoginSuccessful(){
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Login page title is incorrect");
        loginPage.setUsername(USER_STANDARD);
        loginPage.setPassword(MASTER_PASSWORD);
        ProductsPage productsPage = loginPage.clickLoginButton();
        assertEquals(PRODUCTS_PAGE_TITLE, productsPage.getPageTitle(), "Products page title is incorrect");
        productsPage.clickMenu();
        assertTrue(productsPage.isMenuOpen());
        assertTrue(productsPage.isLogoutDisplayed());
        System.out.println("User logged in successfully and is on the products page");
    }

    @Test
    public void testLoginFailed(){
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Login page title is incorrect");
        loginPage.setUsername(generateRandomAlphanumericString(10, 15));
        loginPage.setPassword(generateRandomAlphanumericString(10, 20));
        loginPage.clickLoginButton();

        assertTrue(loginPage.isErrorIconDisplayed(), "Error icons are not displayed");
        assertEquals(LOGIN_FAILED_MSG, loginPage.getLoginErrorMessage(), "Error messages do not match");
        System.out.println("Login attempt failed as expected. User could not log in.");
    }
}
