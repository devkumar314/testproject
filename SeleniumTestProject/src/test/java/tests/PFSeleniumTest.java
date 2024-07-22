package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.*;

import pages.LoginPagePF;
import pages.LoginPagePOM;

public class PFSeleniumTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
	
		String sPath = System.getProperty("user.dir");
		System.out.println("Project path is - " +sPath);
		
		System.setProperty("webdriver.chrome.driver", sPath + "/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
	
	}
	
	@Test
	public void navigateTo() {
		
		driver.navigate().to("https://www.saucedemo.com/");
	
	}
	
	@Test(dependsOnMethods="navigateTo")
	public void login() {
	
		System.out.println("Inside Step - login");
		
		LoginPagePF loginPagePF = new LoginPagePF(driver);
		
		loginPagePF.enterUserName("standard_user");
		loginPagePF.enterPassword("password");
		loginPagePF.clickLogin();
		
	}
	
	@Test(dependsOnMethods="login")
	public void verifyLogin() throws InterruptedException {
		
		Thread.sleep(1000);
		driver.getPageSource().contains("Products");
	
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();	
	}
	
	

}


