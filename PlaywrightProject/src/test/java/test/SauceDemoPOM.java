package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Test;

import pages.LoginPage;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SauceDemoPOM {

	static LoginPage loginPage;

	@Test
	public void SauceDemoPOM() throws InterruptedException {
	    try (Playwright playwright = Playwright.create()) {
	      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
	        .setHeadless(false));
	      BrowserContext context = browser.newContext();
	      Page page = context.newPage();
	    
	      loginPage = new LoginPage(page);
	      loginPage.gotoLoginPage("https://www.saucedemo.com/");
	      loginPage.login("standard_user", "secret_sauce");
	      
	      Thread.sleep(5000);
	      
	      assertThat(page.getByText("Swag Labs")).isVisible();
	    }
  }
}