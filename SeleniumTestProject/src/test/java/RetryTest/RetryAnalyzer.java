package RetryTest;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 3; // Maximum number of retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            System.out.println("Retrying test " + result.getName() + " with status " +
                               getResultStatusName(result.getStatus()) +
                               " for the " + (retryCount + 1) + " time(s).");
            retryCount++;
            return true; // Tell TestNG to retry the test
        }
        return false; // Stop retrying after MAX_RETRY_COUNT
    }

    public String getResultStatusName(int status) {
        switch (status) {
            case ITestResult.SUCCESS:
                return "SUCCESS";
            case ITestResult.FAILURE:
                return "FAILURE";
            case ITestResult.SKIP:
                return "SKIP";
            default:
                return "UNKNOWN";
        }
    }
}
