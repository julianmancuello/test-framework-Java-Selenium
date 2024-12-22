package extensions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static extensions.ReportFormat.*;

public class BeforeTestExecutionLogger implements BeforeTestExecutionCallback {

    private static int testCounter = 1;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("----------------------------------------------------");
        System.out.printf(MAGENTA_BOLD + "Running Test #%d: %s%n" + RESET, testCounter++, testName);
        System.out.println("----------------------------------------------------");
    }
}
