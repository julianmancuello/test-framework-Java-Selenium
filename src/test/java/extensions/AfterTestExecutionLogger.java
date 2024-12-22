package extensions;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static extensions.ReportFormat.*;

public class AfterTestExecutionLogger implements TestWatcher, BeforeAllCallback, AfterAllCallback {

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
        System.out.printf("%sTest result:%s [%sDISABLED%s]%n", CYAN_BOLD, RESET, YELLOW_BOLD, RESET);
        testsExecuted++;
        testsDisabled++;
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sSUCCESS%s]%n", CYAN_BOLD, RESET, GREEN_BOLD, RESET);
        testsExecuted++;
        testsSuccessful++;
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sABORTED%s]%n", CYAN_BOLD, RESET, PEACH_BOLD, RESET);
        testsExecuted++;
        testsAborted++;
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sFAILED%s]%n", CYAN_BOLD, RESET, RED_BOLD, RESET);
        testsExecuted++;
        testsFailed++;
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println(BOLD + "\n----- Class Test Execution Summary -----");
        System.out.printf("Tests executed: %d%n", testsExecuted);
        System.out.printf("Tests successful: %d%n", testsSuccessful);
        System.out.printf("Tests failed: %d%n", testsFailed);
        System.out.printf("Tests aborted: %d%n", testsAborted);
        System.out.printf("Tests disabled: %d%n", testsDisabled);
        System.out.println("----------------------------------------" + RESET);
    }
}
