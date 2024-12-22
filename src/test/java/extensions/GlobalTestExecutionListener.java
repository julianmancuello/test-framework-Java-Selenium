package extensions;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class GlobalTestExecutionListener extends SummaryGeneratingListener implements TestExecutionListener {

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        super.executionFinished(testIdentifier, testExecutionResult);
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        super.testPlanExecutionFinished(testPlan);

        TestExecutionSummary summary = this.getSummary();

        System.out.println("---------------------------------------------------");
        System.out.println("---------- Global Test Execution Summary ----------");
        System.out.printf("Tests executed: %d%n", summary.getTestsStartedCount());
        System.out.printf("Tests successful: %d%n", summary.getTestsSucceededCount());
        System.out.printf("Tests failed: %d%n", summary.getTestsFailedCount());
        System.out.printf("Tests aborted: %d%n", summary.getTestsAbortedCount());
        System.out.printf("Tests disabled: %d%n", summary.getTestsSkippedCount());
        System.out.println("---------------------------------------------------");
    }
}
