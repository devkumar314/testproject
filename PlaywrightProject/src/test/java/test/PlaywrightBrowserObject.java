package test;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBrowserObject {

	
	 public static void main(String[] args) throws InterruptedException {
		 
		 Playwright playwright = Playwright.create();
		 BrowserType browserType = playwright.chromium();
		 Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
		 BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos")));
		 Page newPage = browserContext.newPage();
		 
		 newPage.navigate("https://google.com");
		 Thread.sleep(5000);
		 
		 newPage.close();
		 browserContext.close();
		 browser.close();
		 playwright.close();
		 
	 }
}
