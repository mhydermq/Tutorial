package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

//JavascriptExecutor to generate alert in selenium 

public class GenerateAlert extends DriverSetUp {

	@Test
	public void generateAlert() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("alert('start execution');");
		Thread.sleep(2000);
		String textOnAlert=driver.switchTo().alert().getText();
		System.out.println(textOnAlert);
		Assert.assertEquals("start execution",textOnAlert);
		driver.switchTo().alert().accept();
		
	}

}
