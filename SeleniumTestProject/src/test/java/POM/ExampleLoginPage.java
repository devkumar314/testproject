package POM;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExampleLoginPage {
	
	
	@FindBy(id="user-name")
	WebElement txtUserName;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="login-button")
	WebElement btnLoginButton;
	
	WebDriver driver;
	String url;
	
	public ExampleLoginPage(){
		DriverFactory driverF = new DriverFactory();
		driver = driverF.initDriver();
		url = driverF.getProperty("url");
		PageFactory.initElements(driver, this);
	}
	
	public ExampleLoginPage navigateURL() {
		System.out.println(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.navigate().to("url");
		String url1= "https://www.saucedemo.com";
		driver.get(url1);
		return this;
	}
	
	public ExampleLoginPage enterUserName(String uname) {
		
		//txtUserName.sendKeys(uname);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
		element.sendKeys(uname);
		
		return this;
	}
	
	public ExampleLoginPage enterPassword(String pass) {
		txtPassword.sendKeys(pass);
		
		txtPassword.getScreenshotAs(OutputType.FILE);
		return this;
	}
	
	public ExampleLoginPage clickLogin() {
		//btnLoginButton.click();
		
		Wait<WebDriver> fluentWait= new FluentWait<WebDriver>(driver)
									.withTimeout(Duration.ofSeconds(30))
									.pollingEvery(Duration.ofSeconds(30))
									.ignoring(org.openqa.selenium.NoSuchElementException.class);
		WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(By.id("user-name")));
		element.click();
		
		return this;
	}
	
	public void close() {
		driver.quit();	
	}
	

}
