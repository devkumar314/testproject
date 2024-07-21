package test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class RecordTest {
  public static void main(String[] args) {
    try (Playwright playwright = Playwright.create()) {
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
        .setHeadless(false));
      BrowserContext context = browser.newContext();
      Page page = context.newPage();
      page.navigate("https://www.wikipedia.org/");
      page.getByLabel("Search Wikipedia").click();
      page.getByLabel("Search Wikipedia").fill("Automation");
      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search")).click();
      assertThat(page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Automation").setExact(true)).locator("span")).isVisible();
    }
  }
}