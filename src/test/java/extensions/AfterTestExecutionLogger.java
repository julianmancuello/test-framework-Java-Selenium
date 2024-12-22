package extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class AfterTestExecutionLogger implements TestWatcher, BeforeAllCallback, AfterAllCallback {

    private static final String ANSI_CYAN_BOLD = "\u001B[36;1m";
    private static final String ANSI_GREEN_BOLD = "\u001B[32;1m";
    private static final String ANSI_RED_BOLD = "\u001B[31;1m";
    private static final String ANSI_PEACH_BOLD = "\u001B[38;5;214;1m";
    private static final String ANSI_YELLOW_BOLD = "\u001B[33;1m";
    private static final String ANSI_RESET = "\u001B[0m";

    private static int testsExecuted = 0;
    private static int testsSuccessful = 0;
    private static int testsFailed = 0;
    private static int testsAborted = 0;
    private static int testsDisabled = 0;

    @Override
    public void beforeAll(ExtensionContext context) {
        testsExecuted = 0;
        testsSuccessful = 0;
        testsFailed = 0;
        testsAborted = 0;
        testsDisabled = 0;
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sDISABLED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_PEACH_BOLD, ANSI_RESET);
        testsExecuted++;
        testsDisabled++;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sSUCCESS%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_GREEN_BOLD, ANSI_RESET);
        testsExecuted++;
        testsSuccessful++;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sABORTED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_YELLOW_BOLD, ANSI_RESET);
        testsExecuted++;
        testsAborted++;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sFAILED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_RED_BOLD, ANSI_RESET);
        testsExecuted++;
        testsFailed++;
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("\n----- Class Test Execution Summary -----");
        System.out.printf("Tests executed: %d%n", testsExecuted);
        System.out.printf("Tests successful: %d%n", testsSuccessful);
        System.out.printf("Tests failed: %d%n", testsFailed);
        System.out.printf("Tests aborted: %d%n", testsAborted);
        System.out.printf("Tests disabled: %d%n", testsDisabled);
        System.out.println("----------------------------------");
    }
}
