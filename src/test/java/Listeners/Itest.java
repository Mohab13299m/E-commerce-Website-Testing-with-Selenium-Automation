package Listeners;
// Listener class for logging test execution events using TestNG
import Utilities.LogsUtil;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


/**
 * TestNG listener to log messages for test start, success, and skip events.
 */
public class Itest implements ITestListener {

    /**
     * Called when a test case starts.
     * Logs the start of the test case.
     * @param result The result of the test.
     */
    @Override
    public void onTestStart(ITestResult result) {
        LogsUtil.info("Test Case" + result.getName()+" started");
    }

    /**
     * Called when a test case passes successfully.
     * Logs the success of the test case.
     * @param result The result of the test.
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtil.info("Test Case" + result.getName()+" passed");
    }

    /**
     * Called when a test case is skipped.
     * Logs the skip event of the test case.
     * @param result The result of the test.
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtil.info("Test Case" + result.getName()+" skipped");
    }
}
