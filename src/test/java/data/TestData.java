package data;

import context.ContextStore;

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
}
