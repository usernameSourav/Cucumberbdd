package stepDefinitions;


import base.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends Base{
	
	@Before()
	public void beforeTest() {
		
	}
	@After("@seleniumTest")
	public void afterTest() {
		
		driver.close();
	}

}
