package RetryTest;

import org.testng.annotations.Test;

public class MyTestClass {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test1() {
        // Test logic that might fail and need retries
        // For demonstration purposes, let's simulate a failing test
        System.out.println("Executing test1");
        assert false; // Simulating test failure
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void test2() {
        // Another test that might fail and need retries
        System.out.println("Executing test2");
        assert true; // Simulating a passing test
    }
}
