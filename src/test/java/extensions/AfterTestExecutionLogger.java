package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

import static extensions.ReportFormat.*;

public class AfterTestExecutionLogger implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.printf("%sTest result:%s [%sDISABLED%s]%n", CYAN_BOLD, RESET, YELLOW_BOLD, RESET);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.printf("%sTest result:%s [%sSUCCESS%s]%n", CYAN_BOLD, RESET, GREEN_BOLD, RESET);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.printf("%sTest result:%s [%sABORTED%s]%n", CYAN_BOLD, RESET, PEACH_BOLD, RESET);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.printf("%sTest result:%s [%sFAILED%s]%n", CYAN_BOLD, RESET, RED_BOLD, RESET);
    }
}