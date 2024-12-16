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
    public static final String LOGIN_PAGE_TITLE = ContextStore.get("login-page-title");
    public static final String LOGIN_FAILED_MSG = ContextStore.get("login-failed-msg");

    //Products page
    public static final String PRODUCTS_PAGE_TITLE = ContextStore.get("products-page-title");

    //Cart page
    public static final String CART_PAGE_TITLE = ContextStore.get("cart-page-title");

    //Checkout Information page
    public static final String CHECKOUT_INFO_PAGE_TITLE = ContextStore.get("checkout-info-page-title");

    //Checkout Confirmation page
    public static final String CHECKOUT_CONF_PAGE_TITLE = ContextStore.get("checkout-conf-page-title");
    public static final String PAYMENT_INFO_TITLE = ContextStore.get("payment-information-title");
    public static final String SHIPPING_INFO_TITLE = ContextStore.get("shipping-information-title");
    public static final String PRICE_TOTAL_TITLE = ContextStore.get("price-total-title");

    //Checkout Complete page
    public static final String CHECKOUT_COMPL_PAGE_TITLE = ContextStore.get("checkout-compl-page-title");
    public static final String SUCCESSFUL_HEADER = ContextStore.get("successful-header");
    public static final String SUCCESSFUL_MSG = ContextStore.get("successful-msg");
    public static final String BACK_HOME_BTN_TEXT = ContextStore.get("back-home-btn-text");
}
