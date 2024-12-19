package common;

import hooks.Hooks;
import pages.*;

import static data.TestData.*;

public class CommonSteps extends Hooks {

    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected CheckoutInformationPage checkoutInformationPage;
    protected CheckoutConfirmationPage checkoutConfirmationPage;
    protected CheckoutCompletePage checkoutCompletePage;

    protected ProductsPage loginAndNavigateToProducts() {
        return loginPage.fillLoginForm(USER_STANDARD, MASTER_PASSWORD);
    }

    protected CartPage goToCartAddingProducts() {
        productsPage = loginAndNavigateToProducts();
        productsPage.addToCartNRandomProducts();
        return productsPage.clickCart();
    }

    protected CartPage goToCartWithoutAddingProducts() {
        productsPage = loginAndNavigateToProducts();
        return productsPage.clickCart();
    }

    protected CheckoutInformationPage afterAddingProductsToCartProceedToCheckoutInformation() {
        cartPage = goToCartAddingProducts();
        return cartPage.clickCheckoutButton();
    }

    protected CheckoutConfirmationPage fillInformationFormAndProceedToCheckoutConfirmation() {
        checkoutInformationPage = afterAddingProductsToCartProceedToCheckoutInformation();
        return checkoutInformationPage.fillPersonalInformationForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);
    }

    protected CheckoutCompletePage proceedToCompleteTheCheckout() {
        checkoutConfirmationPage = fillInformationFormAndProceedToCheckoutConfirmation();
        return checkoutConfirmationPage.clickFinishButton();
    }
}
