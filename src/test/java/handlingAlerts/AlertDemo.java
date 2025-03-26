package handlingAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class AlertDemo extends DriverSetUp {

	@Test
	public void testAlert() throws NoAlertPresentException, InterruptedException {

		// Alert Message handling
		driver.get("http://demo.guru99.com/test/delete_customer.php");

		driver.findElement(By.name("cusid")).sendKeys("53920");
		driver.findElement(By.name("submit")).submit();

		// Switching to Alert
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		String alertMessage = driver.switchTo().alert().getText();
         
		// printing alert message
		System.out.println(alertMessage);
		Thread.sleep(1000);

		// accept/dismiss alert
		// alert.accept();
		alert.dismiss();
		Thread.sleep(1000);
	}

}
