// Listener class for logging before and after invocation of test methods using TestNG
package Listeners;

import Utilities.LogsUtil;
import Utilities.Utility;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.io.IOException;

import static DriverFactory.driverFactory.getDriver;
/**
 * TestNG listener to log messages before and after each test method invocation.
 */
public class InvokedMethod implements IInvokedMethodListener {

    /**
     * Called after each test method is invoked.
     * Logs the completion of the method.
     * @param method The invoked method.
     * @param testResult The result of the test.
     */
    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(testResult.getStatus() == ITestResult.FAILURE) {
            try {
                LogsUtil.info("Test Case" + testResult.getName()+" failed");
                Utility.takeScreenshots(getDriver(),testResult.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
