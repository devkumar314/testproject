package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class GoogleSearchSteps {
	
	WebDriver driver = null;
	
	
	@Given("s browser is open")
	public void s_browser_is_open() {
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

	@Given("user is on google search page")
	public void user_is_on_google_search_page() {
		System.out.println("Inside Step -user is on google search page");
		
		driver.navigate().to("https://google.com");
	}

	@When("user enters a text in search box")
	public void user_enters_a_text_in_search_box() {
		System.out.println("Inside Step - user enters a text in search box");
		
		
		driver.findElement(By.name("q")).sendKeys("Automation testing");
		
	}

	@When("hits enter")
	public void hits_enter() {
		System.out.println("Inside Step - hits enter");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to search result")
	public void user_is_navigated_to_search_result() {
		System.out.println("Inside Step - user is navigated to search result");
		
		driver.getPageSource().contains("Online Courses");
		
		driver.close();
		driver.quit();
	}


}
