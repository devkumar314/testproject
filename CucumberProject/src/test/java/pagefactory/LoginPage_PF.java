package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {

	
	@FindBy(id="user-name")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="login-button")
	WebElement btn_login;
	
	WebDriver webdriver;
	 
	public LoginPage_PF(WebDriver webDriver) {
		this.webdriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void navigateTo(String url) {
		webdriver.navigate().to(url);
	}
	
	public void enterUserName(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void loginValidUser(String username,String password) {
		enterUserName(username);
		enterPassword(password);
		clickLogin();
	}
}
