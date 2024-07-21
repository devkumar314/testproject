package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class AuthenticationStateTest {


  public static void main(String[] args) throws InterruptedException {
	  
	  Playwright playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("state.json")));
      Page page = context.newPage();
      
      System.out.println("Inventory Test");
      page.navigate("https://www.saucedemo.com/inventory.html");
      
      Thread.sleep(5000);
      System.out.println("Cart Test");
      page.navigate("https://www.saucedemo.com/cart.html");
      
      Thread.sleep(5000);
      
      page.close();
      context.close();
      browser.close();
      playwright.close();
    
  	}
}