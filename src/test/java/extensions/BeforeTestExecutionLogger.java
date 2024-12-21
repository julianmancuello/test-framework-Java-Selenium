package extensions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeTestExecutionLogger implements BeforeTestExecutionCallback {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_MAGENTA_BOLD = "\u001B[1;35m";

    private static int testCounter = 1;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("----------------------------------------------------");
        System.out.printf(ANSI_MAGENTA_BOLD + "Running Test #%d: %s%n" + ANSI_RESET, testCounter++, testName);
        System.out.println("----------------------------------------------------");
    }
}
