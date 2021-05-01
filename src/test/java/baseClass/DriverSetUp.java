package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetUp {
	
   /**members of the same class,subclasses and classses 
    * fromm same package have access, protected member 
    * is not accessible to classes form other package
    */
	
	protected WebDriver driver;
	
	@BeforeTest
	public void driverSetup() {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	