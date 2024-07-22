package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePF {
	
	@FindBy(id="user-name")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="login-button")
	WebElement btn_login;
	
	WebDriver driver;
	
	
	public LoginPagePF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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
	
	

}
