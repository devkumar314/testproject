package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class SauceDemoTracer {


  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      
      context.tracing().start(new Tracing.StartOptions()
    		  .setScreenshots(true)
    		  .setSnapshots(true)
    		  .setSources(true));
      
      Page page = context.newPage();
      page.navigate("https://www.saucedemo.com/");
      page.locator("[data-test=\"username\"]").click();
      page.locator("[data-test=\"username\"]").fill("standard_user");
      page.locator("[data-test=\"password\"]").click();
      page.locator("[data-test=\"password\"]").fill("secret_sauce");
      page.locator("[data-test=\"login-button\"]").click();
      assertThat(page.getByText("Swag Labs")).isVisible();
      
      
      context.tracing().stop(new Tracing.StopOptions()
    		  .setPath(Paths.get("trace.zip")));
      
      //mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="show-trace trace.zip"
      //CLI_Runner.bat "show-trace" "trace.zip"
    }
  }
}