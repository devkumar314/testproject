package tests.Utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @DataProvider(name = "simpleDataProvider")
    public Object[][] provideData() {
        return new Object[][] {
            { "input1", "expected1" },
            { "input2", "expected2" }
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void testMethod(String input, String expected) {
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        // Your test logic here
        // assertEquals(actual, expected);
    }
}