package baseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

public class DriverSetUp {

	/**
	 * members of the same class,subclasses and classses 
	 * fromm same package have access. protected member 
	 * is not accessible to classes form other package
	 */

	protected static WebDriver driver;

	@BeforeTest
	public void driverSetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
