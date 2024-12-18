package tests;

import common.CommonSteps;
import org.junit.jupiter.api.Test;

import static common.Utils.generateRandomAlphanumericString;
import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends CommonSteps {

    @Test
    public void testCheckTitleOnLoginPage() {
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Login page title is incorrect");
        System.out.println("Login page title is correct");
    }

    @Test
    public void testLoginSuccessfulWithValidCredentials() {
        loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "Login failed, user was unable to log in");
        System.out.println("User has successfully logged in");
    }

    @Test
    public void testLoginAttemptWithInvalidCredentialsDisplaysErrorIconsAndMessage() {
        loginPage.fillLoginForm(generateRandomAlphanumericString(10, 15), generateRandomAlphanumericString(10, 20));

        assertTrue(loginPage.isErrorIconCountEqualToExpectedQuantity(), "Error icons are not displayed");
        assertEquals(LOGIN_FAILED_MSG, loginPage.getLoginErrorMessage(), "Error message do not match");
        System.out.println("Login attempt failed as expected. Error icons and error message are displayed.");
    }
}