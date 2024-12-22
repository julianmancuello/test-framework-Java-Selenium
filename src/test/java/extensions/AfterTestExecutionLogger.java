package extensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class AfterTestExecutionLogger implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test result: [DISABLED]");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test result: [SUCCESS]");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test result: [ABORTED]");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test result: [FAILED]");
    }
}