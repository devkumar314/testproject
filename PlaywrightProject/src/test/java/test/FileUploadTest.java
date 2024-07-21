package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator.SetInputFilesOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FileUploadTest {


  public static void main(String[] args) throws InterruptedException {
	  
	  Playwright playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      
      System.out.println("Inventory Test");
      page.navigate("https://www.saucedemo.com/inventory.html");
      
      //1 - Single simple way
      page.locator("#upload").setInputFiles(Paths.get("test.jpg"));
      
      //2 - Multiple files with timeout
      //SetInputFilesOptions fileOptions = new SetInputFilesOptions();
      //fileOptions.setTimeout(5000);
      //page.locator("#upload").setInputFiles(Paths.get("test.jpg"), fileOptions);
      
      //Multiple files at a time
      //page.locator("#upload").setInputFiles(new Path[] {Paths.get("test1.jpg"), Paths.get("test2.jpg"), Paths.get("test3.jpg")});
      
      
      page.close();
      context.close();
      browser.close();
      playwright.close();
    
  	}
}