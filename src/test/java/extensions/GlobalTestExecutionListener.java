package extensions;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static extensions.ReportFormat.*;

public class GlobalTestExecutionListener extends SummaryGeneratingListener implements TestExecutionListener {

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        super.executionFinished(testIdentifier, testExecutionResult);
    }

    @Override
    public void testPlanExecutionFinished(TestPlan testPlan) {
        super.testPlanExecutionFinished(testPlan);

        TestExecutionSummary summary = this.getSummary();

        System.out.println(PINK_BOLD + "\n---------------------------------------------------");
        System.out.println("---------- Global Test Execution Summary ----------" + RESET);
        System.out.printf(BOLD + "Tests executed: %d%n" + RESET, summary.getTestsStartedCount());
        System.out.printf(GREEN_BOLD + "Tests successful: %d%n" + RESET, summary.getTestsSucceededCount());
        System.out.printf(RED_BOLD + "Tests failed: %d%n" + RESET, summary.getTestsFailedCount());
        System.out.printf(PEACH_BOLD + "Tests aborted: %d%n" + RESET, summary.getTestsAbortedCount());
        System.out.printf(YELLOW_BOLD + "Tests disabled: %d%n" + RESET, summary.getTestsSkippedCount());
        System.out.println(PINK_BOLD + "---------------------------------------------------" + RESET);
    }
}
