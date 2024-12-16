package data;

import context.ContextStore;

public class CommonData {

    //User variables
    public static String userStandard = ContextStore.get("std-user");
    public static String userLocked = ContextStore.get("lock-user");
    public static String userProblem = ContextStore.get("prob-user");
    public static String userPerformanceGlitch = ContextStore.get("perf-user");
    public static String userError = ContextStore.get("err-user");
    public static String userVisual = ContextStore.get("vis-user");

    //Password variables
    public static String masterPassword = ContextStore.get("master-password");

    //Links
    public static String urlSauceDemo = ContextStore.get("aut-link");

    //User information
    public static String firstName = ContextStore.get("first-name");
    public static String lastName = ContextStore.get("last-name");
    public static String postalCode = ContextStore.get("postal-code");
}
