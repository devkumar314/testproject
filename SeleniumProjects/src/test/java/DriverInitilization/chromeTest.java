package DriverInitilization;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import common.GenericFunc;


public class chromeTest extends GenericFunc{
	
	WebDriver driver;

	@Test(priority=1)
	public void seleniumDriverTest() {

		//Setting system properties of ChromeDriver 
		System.setProperty("webdriver.chrome.driver", "C:\\eclipse-workspace\\Resources\\chromedriver.exe");

		//Creating an object of ChromeDriver
		driver = new ChromeDriver();
	}
	
	@Test(enabled=false)
	public void addCapabilitiesTest() {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("username", "<cloudUsername>");
		dc.setCapability("password", "<cloudPassword>");
		dc.setCapability("projectName", "<cloudProject>"); //only required if your user has several projects assigned to it. Otherwise, exclude this capability.
		//dc.setCapability("accessKey", "<accessKey>"); // can be use instead of username,password and project.
		dc.setCapability("generateReport", true);
		dc.setCapability("testName", "<testName>");
		dc.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
		dc.setCapability(CapabilityType.BROWSER_VERSION, "126.0");
		dc.setCapability(CapabilityType.BROWSER_NAME, "chrome");
		dc.setCapability("newCommandTimeout", 500);
		dc.setCapability("newSessionWaitTimeout", 500);
		dc.setCapability("agentName", "<agentName>");
		dc.setCapability("maxScreenshotInterval", 10);
		//dc.setCapability("seleniumScreenshot", true);
		dc.setCapability("reportType", "video");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL(cloudurl + "/wd/hub/"), dc);
	}
	
	@Test(priority=2)
	public void verifyTest() {
		//launching the specified URL 
		driver.get("https://bstackdemo.com/");
		
		// Check the title
        Assert.assertTrue(driver.getTitle().matches("StackDemo"));

        // Save the text of the product for later verify
        String productOnScreenText = driver.findElement(By.xpath("//*[@id=\"1\"]/p")).getText();
        // Click on add to cart button
        driver.findElement(By.xpath("//*[@id=\"1\"]/div[4]")).click();

        // See if the cart is opened or not
        Assert.assertTrue(driver.findElement(By.cssSelector(".float\\-cart__content")).isDisplayed());

        // Check the product inside the cart is same as of the main page
        String productOnCartText = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[2]/div[2]/div[2]/div/div[3]/p[1]")).getText();
        Assert.assertEquals(productOnScreenText, productOnCartText);
        
        System.out.println(sum(3,2));
	}
	
	public int sum(int a, int b) {
		return a - b;
	}
	
	@AfterTest(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}

