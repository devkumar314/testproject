package tests.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseTest {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testDatabaseAndWeb() throws SQLException {
        // Example Selenium operations
        driver.get("http://example.com");
        driver.findElement(By.id("inputField")).sendKeys("test");

        // Database operations
        try (Connection connection = DatabaseUtils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table WHERE condition")) {

            while (resultSet.next()) {
                String data = resultSet.getString("your_column");
                System.out.println("Database Data: " + data);
                // Perform assertions or checks based on the data
            }
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
