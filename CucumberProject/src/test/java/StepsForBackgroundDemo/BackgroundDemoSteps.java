package StepsForBackgroundDemo;

import io.cucumber.java.en.*;

public class BackgroundDemoSteps {

	@Given("bk user is on login page")
	public void bk_user_is_on_login_page() {
	    System.out.println("bk_user_is_on_login_page");
	}

	@When("bk user enter username and password")
	public void bk_user_enter_username_and_password() {
		System.out.println("bk_user_enter_username_and_password");
	    
	}

	@When("bk clicks on ligin button")
	public void bk_clicks_on_ligin_button() {
		System.out.println("bk_clicks_on_ligin_button");
	    
	}

	@Then("bk user is navigated to home page")
	public void bk_user_is_navigated_to_home_page() {
		System.out.println("bk_user_is_navigated_to_home_page");
	    
	}

	@Given("bk user is logged in")
	public void bk_user_is_logged_in() {
		System.out.println("bk_user_is_logged_in");
	    
	}

	@When("bk user clicks on welcome link")
	public void bk_user_clicks_on_welcome_link() {
		System.out.println("bk_user_clicks_on_welcome_link");
	    
	}

	@Then("bk logout link is displayed")
	public void bk_logout_link_is_displayed() {
		System.out.println("bk_logout_link_is_displayed");
	    
	}

	@When("bk user clicks on dashboard button")
	public void bk_user_clicks_on_dashboard_button() {
		System.out.println("bk_user_clicks_on_dashboard_button");
	    
	}

	@Then("bk quick launch displayed")
	public void bk_quick_launch_displayed() {
		System.out.println("bk_quick_launch_displayed");
	    
	}

}
