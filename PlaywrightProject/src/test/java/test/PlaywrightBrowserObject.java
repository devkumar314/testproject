package test;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBrowserObject {

	
	 public static void main(String[] args) {
		 
		 Playwright playwright = Playwright.create();
		 BrowserType browserType = playwright.chromium();
		 Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false));
		 BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos")));
		 Page newPage = browserContext.newPage();
		 
		 newPage.navigate("google.com");
		 
		 newPage.close();
		 browserContext.close();
		 browser.close();
		 playwright.close();
		 
	 }
}
