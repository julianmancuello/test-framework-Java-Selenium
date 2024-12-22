package tests;

import common.CommonSteps;
import extensions.AfterTestExecutionLogger;
import extensions.BeforeTestExecutionLogger;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static common.Utils.generateRandomAlphanumericString;
import static data.TestData.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith({BeforeTestExecutionLogger.class, AfterTestExecutionLogger.class})
public class LoginTests extends CommonSteps {

    @Test
    @Tag("smoke")
    public void testCheckTitleOnLoginPage() {
        assertEquals(LOGIN_PAGE_TITLE, loginPage.getPageTitle(), "Login page title is incorrect");
        System.out.println("Login page title is correct");
    }

    @Test
    @Tag("regression")
    public void testLoginSuccessfulWithValidCredentials() {
        loginPage.loginUser(USER_STANDARD, MASTER_PASSWORD);

        assertEquals(PRODUCTS_PAGE_URL, loginPage.getCurrentUrl(), "Login failed, user was unable to log in");
        System.out.println("User has successfully logged in");
    }

    @Test
    @Tag("smoke")
    public void testLoginAttemptWithInvalidCredentialsDisplaysErrorIconsAndMessage() {
        loginPage.loginUser(generateRandomAlphanumericString(10, 15), generateRandomAlphanumericString(10, 20));

        assertTrue(loginPage.isErrorIconCountEqualToExpectedQuantity(), "Error icons are not displayed");
        assertEquals(LOGIN_FAILED_MSG, loginPage.getLoginErrorMessage(), "Error message do not match");
        System.out.println("Login attempt failed as expected. Error icons and error message are displayed.");
    }
}