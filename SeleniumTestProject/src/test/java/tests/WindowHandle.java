package tests;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	
	//Window A,B,C,D ...switch to C and close
	
	WebDriver driver;
	String toClose = "Facebook";
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		// For demonstration, we will simulate opening a new window by executing JavaScript
		((ChromeDriver) driver).executeScript("window.open('https://mvnrepository.com', '_blank');");
		((ChromeDriver) driver).executeScript("window.open('https://www.fb.com', '_blank');");
		((ChromeDriver) driver).executeScript("window.open('https://YouTube.com', '_blank');");
		
	}
	
	@Test
	public void getWindowHandles() {
		
		Set<String> wHandles = driver.getWindowHandles();
		System.out.println("Total Window Handles : " + wHandles.size());

		for (String wHandle :wHandles){
			driver.switchTo().window(wHandle);
			System.out.println("Windows Handle: " + wHandle);
			System.out.println("Windows Title: " + driver.getTitle());
		}

	}
	
	@Test(dependsOnMethods="getWindowHandles", alwaysRun = true)
	public void closeWindowHandles() throws InterruptedException {
		
		Set<String> wHandles = driver.getWindowHandles();
		
		for (String wHandle :wHandles){
			driver.switchTo().window(wHandle);
			System.out.println("Windows Handle: " + wHandle);
			System.out.println("Windows Title: " + driver.getTitle());
			
			if(driver.getTitle().contains(toClose)) {
				driver.close();
				driver.wait(1000);
			}
		}
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
