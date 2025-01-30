package extensions;

import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BeforeTestExecutionLogger implements BeforeTestExecutionCallback {

    private static int testCounter = 1;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("----------------------------------------------------");
        System.out.printf("Running Test #%d: %s%n", testCounter++, testName);
        System.out.println("----------------------------------------------------");
    }
}
//test