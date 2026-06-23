package pageObject;
import org.openqa.selenium.*;
public class Login {
	WebDriver driver;
	By signUpAndInBtn=By.xpath("//a[@class='br4 cF fs12 ls5 p8 tdN ttU bgRedgrad skpTrSngUp']");
	By ProfileBtn=By.xpath("//div[@class='dTc cuP taC vM w80 mainCategory bdb4T an-profile']");
	By phnNo=By.id("emph");
	By NextBtn=By.xpath("//div[@class='mb10 pR']");
	By MenBtn=By.xpath("//div[@id='shopMen']");
	By OTP=By.xpath("//input[@id='otp']");
	By submitBtn=By.xpath("//input[@id='modify_for_ctob']");
	By loginText=By.xpath("//div[@class='dT']");
	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSignUpAndInBtn() {
		return driver.findElement(signUpAndInBtn);
	}
	public WebElement getProfileBtn() {
		return driver.findElement(ProfileBtn);
	}
	public WebElement getPhn() {
		return driver.findElement(this.phnNo);
	}
	
	public WebElement getOTP() {
		return driver.findElement(this.OTP);
	}
	
	public WebElement getMenBtn() {
		return driver.findElement(MenBtn);
	}
	
	public WebElement getNextBtn() {
		return driver.findElement(this.NextBtn);
	}
	
	public WebElement getSubmitBtn() {
		return driver.findElement(submitBtn);
	}
	public WebElement getLoginText() {
		return driver.findElement(this.loginText);
	}
	

}
