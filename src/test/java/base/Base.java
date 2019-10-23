package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriver getDriver() throws IOException {
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\eclipse-workspace"
				+ "\\Cucumberbdd\\src\\test\\java\\base\\data.properties");
    	prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\admin\\Downloads\\Selenium jars\\driver\\Chromedriver.exe");
    	driver = new ChromeDriver();
    	
    	driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		System.out.println("doing git work");
		System.out.println("!!!!!!!!!!hope succesfull!!!!!!!");
		
		System.out.println("!!!!!!!!!! succesfull!!!!!!!");
		System.out.println("!!!!!!!!!!WANNA succesfull!!!!!!!");
		System.out.println("!!!!!!!!!!WILL BE succesfull!!!!!!!");
		
		System.out.println("1st branch i add");
		
		
		return driver;
	}

}
