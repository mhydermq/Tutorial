package handlingFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;


/**
 * existance of iframes in a web page can be identified in two ways, by
 * Right-click on the specific element and check all the options, if we find
 * optons like this frame, view frame source, or Reload frame, then the web page
 * contains iframes.
 * 
 * if we click on view page source and find iframe tags in page then the page
 * contains iframe.
 * 
 * frames can be identified by an id or name attribute or their index and the
 * focus can be switched to the frame by driver.switchTo().frame() method, the
 * defaultContent() method is used to switch the focus back to the page.
 * 
 * @author hyder
 *
 */

public class HandlingIFrames extends DriverSetUp {

	static String url = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_border2";
	static String Url = "https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit";

	@Test(priority = 0, enabled = true)
	public void handlingIframe() throws InterruptedException {

		driver.get(url);
		Thread.sleep(2000);

		// finding the element using any of locator strategy
		// WebElement iframeElement = driver.findElement(By.tagName("h1"));

		// now using the switch command to switch to main frame.
		driver.switchTo().frame(0);
		System.out.println("frame title: " + driver.switchTo().frame(0).getTitle());

		// Switching back to the main window
		driver.switchTo().defaultContent();
		System.out.println("main window title: "+driver.getTitle());
	}

	
	@Test(priority = 1, enabled = false)
	public void multipleFrames() throws InterruptedException {

		driver.get(Url);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("Total number of iframes are " + iframeElements.size());

		// By executing a java script
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Integer noOfFrames = Integer.parseInt(jse.executeScript("return window.length").toString());
		System.out.println("No. of iframes on the page are " + noOfFrames);
		Thread.sleep(1000);
	}

}
