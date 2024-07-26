package tests.Utils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.YamlReader;

import java.util.List;
import java.util.Map;

public class YamlReaderTest {

    @DataProvider(name = "yamlDataProvider")
    public Object[][] provideData() {
        List<Map<String, Object>> data = YamlReader.readYaml("testdata.yaml");
        Object[][] result = new Object[data.size()][2]; // Adjust size as needed

        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> entry = data.get(i);
            result[i][0] = entry.get("input");
            result[i][1] = entry.get("expected");
        }
        return result;
    }

    @Test(dataProvider = "yamlDataProvider")
    public void testMethod(String input, String expected) {
        System.out.println("Input: " + input);
        System.out.println("Expected: " + expected);
        // Your test logic here
        // assertEquals(actual, expected);
    }
}

