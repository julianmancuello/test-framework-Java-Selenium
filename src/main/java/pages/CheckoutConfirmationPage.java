package pages;

import context.ContextStore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static common.Utils.*;

public class CheckoutConfirmationPage extends BasePage {

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

    public boolean isEachSelectedProductPresentInCheckout() {
        List<String> selectedProductNames = ContextStore.get("selectedProductNames");
        return isEachStringInListPresentInPage(productName, selectedProductNames);
    }

    public boolean isPriceOfEachSelectedProductInCheckoutCorrect() {
        List<Double> selectedProductPrices = ContextStore.get("selectedProductPrices");
        return isEachDoubleInListPresentInPage(productPrice, selectedProductPrices);
    }

    public boolean isProductInformationInCheckoutCorrect() {
        return isEachSelectedProductPresentInCheckout() && isPriceOfEachSelectedProductInCheckoutCorrect();
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

    public boolean isTheValueOfSubtotalTaxAndTotalCorrect() {
        return isSubtotalCorrect() && isTaxAmountCorrect() && isTotalCorrect();
    }

    public CheckoutCompletePage clickFinishButton() {
        click(finishButton);
        return new CheckoutCompletePage(driver);
    }
}