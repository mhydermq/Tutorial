package handlingAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class HandligJavaScriptAlertPopUps extends DriverSetUp {

	static String url = 
			"http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html";

	@Test
	public void alertWindow() throws Exception {
		// fetching the webpage
		driver.get(url);

		// clicking on the button that returns a JavaScript alert pop-up
		driver.findElement(By.xpath("//*[@id='content']/button")).click();
		Thread.sleep(2000);
		// switching to the alert pop-up
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		
		Assert.assertEquals("Press a button!", alertText);
		
		System.out.println(alertText);
		// performing an accept action on the alert
		alert.accept();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id='content']/button")).click();
		Thread.sleep(2000);
		alert.dismiss();
	}
}
