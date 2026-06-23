package stepDefinations;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.*;
import pageObject.*;
import io.cucumber.java.en.*;
import pageObject.*;

public class SortFunctionality extends Base{
	Sort sorting;
	@Given("user is on search screen")
	public void user_is_on_search_screen() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("User is on Home Page");
	    try {
	    	
			getDriver().get(this.getUrl());
			getDriver().manage().window().maximize();
			sorting = new Sort(getDriver());
	    	sorting.getSearchBtn().click();
			Thread.sleep(2000);
			
		} catch (Exception ex) {
		}
	}

	@When("user enters {string} and click enter")
	public void user_enters_and_click_enter(String string)  {
	    // Write code here that turns the phrase above into concrete actions
	    try{
	    	sorting.getSearchBar().sendKeys(string);
	    	sorting.getSearchBar().sendKeys(Keys.ENTER);
	    	Thread.sleep(2000);
	    	getDriver().navigate().refresh();
	    	Thread.sleep(2000);
	    	
//	    	sorting.getLinkBtn().click();
	    }catch(Exception ex){
	    	System.out.println("Exception occured");
	    }
	}

	@When("user select sort by")
	public void user_select_sort_by() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		
		Thread.sleep(2000);
	    sorting.getLowBtn().click();
	    Thread.sleep(2000);
	}
	@Then("sort is validated")
	public void sort_is_validated() {
	    // Write code here that turns the phrase above into concrete actions
		WebDriverWait wait= new WebDriverWait(getDriver(),Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='dIb vM c3 fs14']")));
		List<WebElement> price=getDriver().findElements(By.xpath("//div[@class='dIb vM c3 fs14']"));
		List<Integer> Price = new ArrayList<>();
		
		for(WebElement e:price) {
			String prices = e.getText().replace("₹","").replace(",","").trim();
			Price.add(Integer.parseInt(prices));
		}
	    List<Integer> actualPrice=new ArrayList<>(Price);
	    List<Integer> expectedPrice=new ArrayList<>(Price);
	    Collections.sort(expectedPrice);
	    Assert.assertEquals(actualPrice, expectedPrice);
	    System.out.println("Test Case is Passed");
	    
	}
}
