package StepDefinitions.LoginDemoSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class LoginDemoSteps {
	
	WebDriver driver = null;
	
	
	@Given("ld browser is open")
	public void ld_browser_is_open() {
		System.out.println("Inside Step - browser is open");
		
		//System.setProperty("webdriver.chrome.driver", "D:/$GIT/testproject/CucumberProject/src/test/resources/drivers/chromedriver.exe");
		
		String sPath = System.getProperty("user.dir");
		System.out.println("Project path is - " +sPath);
		
		System.setProperty("webdriver.chrome.driver", sPath + "/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}

	@Given("ld user is on login page")
	public void ld_user_is_on_login_page() {
		System.out.println("Inside Step -user is on Login page");
		
		driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("^ld user enters (.*) and (.*)$")
	public void ld_user_enters_username_and_password(String username, String password) {
		System.out.println("Inside Step - user enters username and password");
		
		System.out.println("Username - "+ username + " ,Password - " + password);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
	}

	@When("ld user clicks on login")
	public void ld_user_clicks_on_login() throws InterruptedException {
		System.out.println("Inside Step - user clicks on login");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(5000);
	}

	@Then("ld user is navigated to home page")
	public void ld_user_is_navigated_to_home_page() {
		System.out.println("Inside Step - user is navigated to home page");
		
		driver.getPageSource().contains("Products");
		
		//driver.close();
		driver.quit();
	}


}
