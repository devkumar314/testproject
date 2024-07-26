package tests.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Common.CSVReader;

import java.util.List;

public class CSVReaderTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @DataProvider(name = "csvDataProvider")
    public Object[][] csvDataProvider() {
        List<List<String>> records = CSVReader.readCSV("files/csvfile.csv");
        Object[][] data = new Object[records.size()][];
        for (int i = 0; i < records.size(); i++) {
            data[i] = records.get(i).toArray();
        }
        return data;
    }

    @Test(dataProvider = "csvDataProvider")
    public void testWithCSVData(String column1, String column2) {
        System.out.println("column1 : " + column1);
        System.out.println("column2 : " + column2);
        // Perform further actions or assertions
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
