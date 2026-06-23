package stepDefinations;
import base.Base;


import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObject.*;
public class LoginFunctionality extends Base{
	String otp;
	Login login;
	private static final Logger logger = LogManager.getLogger(LoginFunctionality.class);
	@Given("user is home page")
	public void user_is_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("User is on Home Page");
	    try {
	    	logger.debug("Reached Method");
			getDriver().get(this.getUrl());
			logger.debug("URL Launched");
			getDriver().manage().window().maximize();
			login = new Login(getDriver());
			logger.debug("Window Maximized");
	    	login.getMenBtn().click();
			Thread.sleep(2000);
			
		} catch (Exception ex) {
		}
	}
	@When("click login button")
	public void click_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Actions actions = new Actions(getDriver());
			actions.moveToElement(login.getProfileBtn()).perform();
			login.getSignUpAndInBtn().click();
			Thread.sleep(2000);
		}catch(Exception ex){
			System.out.println("exception was occured");
		}
		
	}
	@When("user enters phone number {string}  and click continue button")
	public void user_enters_phone_number_and_click_continue_button(String string) {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Actions actions = new Actions(getDriver());
			
			login.getPhn().sendKeys(string);
			actions.moveToElement(login.getNextBtn()).perform();
			login.getNextBtn().click();
			Thread.sleep(3000);
		} catch (Exception ex) {
		}
	}
	@Then("otp verification window opens")
	public void otp_verification_window_opens() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
	    
	}
	
	@When("user enters otp")
	public void user_enters_otp() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter OTP");
	    otp=sc.nextLine();
	    login.getOTP().sendKeys(otp);
	    Thread.sleep(2000);
		
		
	}
	@When("click on start shoping button")
	public void click_on_start_shoping_button() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	@Then("user is successfully logged in")
	public void user_is_successfully_logged_in() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		Actions actions = new Actions(getDriver());
		actions.moveToElement(login.getProfileBtn()).perform();
		Thread.sleep(2000);
		Assert.assertTrue(login.getLoginText().getText().contains("Hello"), "Login failure");
		System.out.println("LOGIN SUCCESS");
		Thread.sleep(2000);
	}
}
