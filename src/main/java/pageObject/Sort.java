package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sort {
	WebDriver driver;
	By SearchBtn=By.xpath("//a[@class=\"vM pR dB\" and @href=\"/search\"]");
	By SearchBar=By.xpath("//input[@class='srcInpu bd0 bgF br0 bs fs12 srch_height wp100']");
	By LinkBtn=By.xpath("//div[@class='srcInpuSub dTc vM w48 pR hcurP']");
	By LowBtn=By.xpath("//div[@class='dIb vM wsN' and text()='Low Price']");
	public Sort(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getLinkBtn() {
		return driver.findElement(LinkBtn);
	}

	public WebElement getSearchBtn() {
		
		return driver.findElement(SearchBtn);
	}
	public WebElement getSearchBar() {
		return driver.findElement(SearchBar);
	}
	public WebElement getLowBtn() {
		return driver.findElement(LowBtn);
	}
	
}