package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

//JavascriptExecutor to generate alert in selenium 
//https://www.software-testing-tutorials-automation.com/2014/01/

public class GenerateAlert extends DriverSetUp{
	
	@Test
	public void generateAlert() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("alert('start execution');");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

}
