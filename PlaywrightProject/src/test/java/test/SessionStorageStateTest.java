package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class SessionStorageStateTest {


  public static void main(String[] args) {
	  
	  Playwright playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.saucedemo.com/");
      page.locator("[data-test=\"username\"]").click();
      page.locator("[data-test=\"username\"]").fill("standard_user");
      page.locator("[data-test=\"password\"]").click();
      page.locator("[data-test=\"password\"]").fill("secret_sauce");
      page.locator("[data-test=\"login-button\"]").click();
      assertThat(page.getByText("Swag Labs")).isVisible();
      
      context.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("state.json")));
      
      page.close();
      context.close();
      browser.close();
      playwright.close();
    
  	}
}