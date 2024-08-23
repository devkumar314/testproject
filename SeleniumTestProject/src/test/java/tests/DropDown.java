package tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	
	WebDriver driver;
	WebElement dropdown;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		dropdown = driver.findElement(By.id("ID"));
		
	}
	
	@Test
	public void selectDrodown() {
		
		Select select = new Select(dropdown);
		
		select.selectByValue("TEXT");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}