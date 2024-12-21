package extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class TestExecutionLogger implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

    private static int testCounter = 1;

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        System.out.println("----------------------------------------------------");
        System.out.printf("Ejecutando Test #%d: %s%n", testCounter++, testName);
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        String testName = context.getDisplayName();
        boolean testSuccessful = context.getExecutionException().isEmpty();
        String status = testSuccessful ? "SUCCESS" : "FAILED";
        System.out.printf("Resultado del Test: %s [%s]%n", testName, status);
    }
}
