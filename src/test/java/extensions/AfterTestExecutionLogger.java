package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class AfterTestExecutionLogger implements TestWatcher {

    private static final String ANSI_CYAN_BOLD = "\u001B[36;1m";
    private static final String ANSI_GREEN_BOLD = "\u001B[32;1m";
    private static final String ANSI_RED_BOLD = "\u001B[31;1m";
    private static final String ANSI_PEACH_BOLD = "\u001B[38;5;214;1m"; // Peach color (from 256-color palette)
    private static final String ANSI_YELLOW_BOLD = "\u001B[33;1m";
    private static final String ANSI_RESET = "\u001B[0m";

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sDISABLED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_PEACH_BOLD, ANSI_RESET);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sSUCCESS%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_GREEN_BOLD, ANSI_RESET);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sABORTED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_YELLOW_BOLD, ANSI_RESET);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        System.out.printf("%sTest result:%s [%sFAILED%s]%n", ANSI_CYAN_BOLD, ANSI_RESET, ANSI_RED_BOLD, ANSI_RESET);
    }
}
