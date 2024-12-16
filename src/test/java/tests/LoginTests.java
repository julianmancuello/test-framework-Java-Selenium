package tests;

import hooks.Hooks;
import org.junit.jupiter.api.Test;
import pages.ProductsPage;

import static common.Utils.*;
import static data.CommonData.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTests extends Hooks {

    @Test
    public void testLoginSuccessful(){
        assertEquals("Swag Labs", homePage.getPageTitle(), "Home page title is incorrect");
        homePage.setUsername(userStandard);
        homePage.setPassword(masterPassword);
        ProductsPage productsPage = homePage.clickLoginButton();
        assertEquals("Products", productsPage.getPageTitle(), "Products page title is incorrect");
        productsPage.clickMenu();
        assertTrue(productsPage.isMenuOpen());
        assertTrue(productsPage.isLogoutDisplayed());
        System.out.println("User logged in successfully and is on the products page");
    }

    @Test
    public void testLoginFailed(){
        assertEquals("Swag Labs", homePage.getPageTitle(), "Home page title is incorrect");
        homePage.setUsername(generateRandomAlphanumericString(10, 15));
        homePage.setPassword(generateRandomAlphanumericString(10, 20));
        homePage.clickLoginButton();

        assertTrue(homePage.isErrorIconDisplayed(), "Error icons are not displayed");
        assertEquals("Epic sadface: Username and password do not match any user in this service", homePage.getLoginErrorMessage(), "Error messages do not match");
        System.out.println("Login attempt failed as expected. User could not log in.");
    }
}
