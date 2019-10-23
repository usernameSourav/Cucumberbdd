package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import pageObject.HomePage;
import io.cucumber.java.en.And;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

@RunWith(Cucumber.class)
public class stepDefinition {

	public WebDriver driver;
	
	
    @Given("^User is in Greenkart Landing Page$")
    public void user_is_in_greenkart_landing_page() throws Throwable {
    	driver=Base.getDriver();
    }

    @When("^User search for \"([^\"]*)\" in the search box$")
    public void user_search_for_something_in_the_search_box(String strArg1) throws Throwable{
   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	
   HomePage hp=new HomePage(driver);
   hp.getSerach().sendKeys(strArg1);
    	
        
    }

    @Then("^\"([^\"]*)\" results displayed$")
    public void something_results_displayed(String strArg1) throws Throwable {
        //Assert.assertTrue(driver.findElement(By.cssSelector("h4.product-name")).getText().contains(strArg1));
    	WebDriverWait wt=new WebDriverWait(driver,5);
    	wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.product-name")));
    	//System.out.println(driver.findElement(By.xpath("//h4[contains(text(),'Cashews')]")).getText());
    	Thread.sleep(2000);
    	Assert.assertTrue((driver.findElement(By.xpath("//h4[contains(text(),'Cashews')]")).getText().contains(strArg1)));
    	
    }
    @Then("^Verify the selected \"([^\"]*)\" are  displayed in checkout page$")
    public void verify_the_selected_something_are_displayed_in_checkout_page(String strArg1) throws Throwable {
     
    	Assert.assertTrue((driver.findElement(By.xpath("//p[contains(text(),'Water Melon')]")).getText().contains(strArg1)));
    }

    @And("^Added items to cart$")
    public void added_items_to_cart() throws Throwable {
     
    	Thread.sleep(3000);
    	//driver.findElement(By.xpath("//a[@class='increment']")).click();
    
    		driver.findElement(By.cssSelector("a.increment")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//button[contains(text(),'ADD TO ')]")).click();
        
    		
    		
    	}

    @And("^User proceed to Checkout Page$")
    public void user_proceed_to_checkout_page() throws Throwable {
    	Thread.sleep(3000);
     driver.findElement(By.cssSelector("a.cart-icon")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO ')]")).click();
    }
}