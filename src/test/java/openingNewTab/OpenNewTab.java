package openingNewTab;

import java.util.ArrayList;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

/**
 * open a new tab in the same browser
 * driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
 * 
 * switch to it to be able to work with the newly opened tab ArrayList<String>
 * tabs = new ArrayList<String> (driver.getWindowHandles());
 * driver.switchTo().window(tabs.get(0));
 *
 */

public class OpenNewTab extends DriverSetUp {

	@Test
	public void testTAB() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		// Assert.assertEquals(null, driver.getTitle());
		System.out.println("page title_landingPage: " + driver.getTitle());

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com/");
		// Assert.assertEquals(null, driver.getTitle());
		System.out.println("page title_newTab: " + driver.getTitle());
		Thread.sleep(1000);

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());

		// switched to landing page
		driver.switchTo().window(tabs.get(0));
		System.out.println("landingPage: " + driver.getTitle());
		Thread.sleep(1000);

	}

}
