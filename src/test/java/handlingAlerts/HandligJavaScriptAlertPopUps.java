package handlingAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandligJavaScriptAlertPopUps {
	
	public class AlertInterface {
		
		
		@Test
		public void alertWindow() throws Exception{
			//driver setup
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			//fetching the webpage
			driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
			
			//clicking on the button that returns a JavaScript alert pop-up
			driver.findElement(By.xpath("//*[@id='content']/button")).click();
			Thread.sleep(3000);
			//switching to the alert pop-up
			Alert alert = driver.switchTo().alert();
			String print = alert.getText();
			System.out.println(print);
			//performing an accept action on the alert
			alert.accept();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id='content']/button")).click();
			Thread.sleep(3000);
			alert.dismiss();
			driver.quit();
		}
	}
	
	

}
