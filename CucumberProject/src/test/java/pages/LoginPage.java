package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver webdriver;
	By txt_username = By.id("user-name");
	By txt_password = By.id("password");
	By btn_login = By.id("login-button");
	
	public LoginPage(WebDriver webDriver) {
		this.webdriver = webDriver;
	}
	
	public void navigateTo(String url) {
		webdriver.navigate().to(url);
	}
	
	public void enterUserName(String username) {
		webdriver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		webdriver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogin() {
		webdriver.findElement(btn_login).click();
	}
	
	public void loginValidUser(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickLogin();
	}
	
}
