package pages;

import context.ContextStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static common.Utils.*;

public class CheckoutConfirmationPage extends BasePage {

    @FindBy(className = "title")
    WebElement pageTitle;
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(className = "inventory_item_name")
    List<WebElement> productName;
    @FindBy(className = "inventory_item_price")
    List<WebElement> productPrice;
    @FindBy(css = "div.summary_info_label:nth-child(1)")
    WebElement paymentInformationTitle;
    @FindBy(css = "div.summary_info_label:nth-child(3)")
    WebElement shippingInformationTitle;
    @FindBy(css = "div.summary_info_label:nth-child(5)")
    WebElement priceTotalTitle;
    @FindBy(className = "summary_subtotal_label")
    WebElement subtotalPrice;
    @FindBy(className = "summary_tax_label")
    WebElement taxAmount;
    @FindBy(className = "summary_total_label")
    WebElement totalPrice;

    private final double TAX_RATE = 0.08;

    public CheckoutConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isEachSelectedProductPresentInCheckout() {
        List<String> selectedProductNames = ContextStore.get("selectedProductNames");
        if (isEachStringInListPresentInPage(productName, selectedProductNames)) {
            System.out.println("Each selected product is present on the checkout confirmation page.");
            return true;
        }
        System.out.println("The selected products are not present on the checkout confirmation page.");
        return false;
    }

    public boolean isPriceOfEachSelectedProductInCheckoutCorrect() {
        List<Double> selectedProductPrices = ContextStore.get("selectedProductPrices");
        if (isEachDoubleInListPresentInPage(productPrice, selectedProductPrices)) {
            System.out.println("The price of each selected product is correct on the checkout confirmation page.");
            return true;
        }
        System.out.println("The prices displayed on the checkout confirmation page are incorrect.");
        return false;
    }

    public String getPaymentInformationTitle() {
        return getText(paymentInformationTitle);
    }

    public String getShippingInformationTitle() {
        return getText(shippingInformationTitle);
    }

    public String getPriceTotalTitle() {
        return getText(priceTotalTitle);
    }

    public boolean isSubtotalCorrect() {
        double subtotalInPage = parsePrice(getText(subtotalPrice));
        double subtotalStored = sumListOfNumbers(ContextStore.get("selectedProductPrices"));
        return isNumberEqualToNumber(subtotalStored, subtotalInPage);
    }

    public boolean isTaxAmountCorrect() {
        double taxAmountInPage = parsePrice(getText(taxAmount));
        double taxCalculated = calculateTaxes(sumListOfNumbers(ContextStore.get("selectedProductPrices")), TAX_RATE);
        return isNumberEqualToNumber(taxCalculated, taxAmountInPage);
    }

    public boolean isTotalCorrect() {
        double totalInPage = parsePrice(getText(totalPrice));
        double totalCalculated = calculateTotalWithTaxes(sumListOfNumbers(ContextStore.get("selectedProductPrices")), TAX_RATE);
        return isNumberEqualToNumber(totalCalculated, totalInPage);
    }

    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}