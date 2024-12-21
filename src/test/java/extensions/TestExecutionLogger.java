package extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExecutionLogger implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN_BOLD = "\u001B[1;32m";
    private static final String ANSI_RED_BOLD = "\u001B[1;31m";
    private static final String ANSI_CYAN_BOLD = "\u001B[1;36m";

    private static int testCounter = 1;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("----------------------------------------------------");
        System.out.printf(ANSI_CYAN_BOLD + "Ejecutando Test #%d: %s%n" + ANSI_RESET, testCounter++, testName);
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        boolean testSuccessful = context.getExecutionException().isEmpty();
        String status = testSuccessful ? ANSI_GREEN_BOLD + "SUCCESS" + ANSI_RESET : ANSI_RED_BOLD + "FAILED" + ANSI_RESET;
        System.out.printf("Resultado del Test: %s [%s]%n", testName, status);
    }
}
