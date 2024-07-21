package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
	
	
	
	private Page page;
	private Locator username_textbox;
	private Locator password_textbox;
	private Locator login_button;

	public LoginPage(Page page) {
		
		this.page = page;
		this.username_textbox = page.getByPlaceholder("Username");
		this.password_textbox = page.getByPlaceholder("Password");
		this.login_button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Login"));
		
	}
	
	public void login(String username, String pass) {
		this.username_textbox.fill(username);
		this.password_textbox.fill(pass);
		this.login_button.click();
	}
	
	public void gotoLoginPage(String url) {
		this.page.navigate(url);
	}
}
