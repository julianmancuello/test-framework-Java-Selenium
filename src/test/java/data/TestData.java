package data;

import context.ContextStore;
import net.bytebuddy.matcher.CollectionOneToOneMatcher;

public class TestData {

    //User variables
    public static final String USER_STANDARD = ContextStore.get("std-user");
    public static final String USER_LOCKED = ContextStore.get("lock-user");
    public static final String USER_PROBLEM = ContextStore.get("prob-user");
    public static final String USER_PERFORMANCE_GLITCH = ContextStore.get("perf-user");
    public static final String USER_ERROR = ContextStore.get("err-user");
    public static final String USER_VISUAL = ContextStore.get("vis-user");

    //Password variables
    public static final String MASTER_PASSWORD = ContextStore.get("master-password");

    //Links
    public static final String URL_SAUCE_DEMO = ContextStore.get("aut-link");

    //User information
    public static final String FIRST_NAME = ContextStore.get("first-name");
    public static final String LAST_NAME = ContextStore.get("last-name");
    public static final String POSTAL_CODE = ContextStore.get("postal-code");

    //--Information on the pages
    //Login page
    public static final String LOGIN_PAGE_TITLE = "Swag Labs";
    public static final String LOGIN_FAILED_MSG = "Epic sadface: Username and password do not match any user in this service";

    //Products page
    public static final String PRODUCTS_PAGE_URL = "https://www.saucedemo.com/inventory.html";
    public static final String PRODUCTS_PAGE_TITLE = "Products";

    //Cart page
    public static final String CART_PAGE_TITLE = "Your Cart";

    //Checkout Information page
    public static final String CHECKOUT_INFO_PAGE_TITLE = "Checkout: Your Information";

    //Checkout Confirmation page
    public static final String CHECKOUT_CONF_PAGE_TITLE = "Checkout: Overview";
    public static final String PAYMENT_INFO_TITLE = "Payment Information:";
    public static final String SHIPPING_INFO_TITLE = "Shipping Information:";
    public static final String PRICE_TOTAL_TITLE = "Price Total";

    //Checkout Complete page
    public static final String CHECKOUT_COMPL_PAGE_TITLE = "Checkout: Complete!";
    public static final String SUCCESSFUL_HEADER = "Thank you for your order!";
    public static final String SUCCESSFUL_MSG = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
    public static final String BACK_HOME_BTN_TEXT = "Back Home";
}
