package handlingWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class WindowHandleDemo extends DriverSetUp {

	@Test
	public void handlingMultipleWindows() throws InterruptedException {

		driver.get("https://demoqa.com/browser-windows");
		WebElement ele = driver.findElement(By.id("windowButton"));
		ele.click();
		Thread.sleep(2000);

		// get parent window handle
		String pw = driver.getWindowHandle();
		System.out.println("parent windowHandle/name- " + pw);
		String pageTitle = driver.getTitle();
		System.out.println("pw title - " + pageTitle);

		// get the child windows and store in set of strings
		Set<String> set = driver.getWindowHandles();
		System.out.println("windowHandles are- " + set);

		// iterate child windows using Iterator
		Iterator<String> ite = set.iterator();
		while (ite.hasNext()) {
			String child_window = ite.next();
			if (!pw.equals(child_window)) {
				driver.switchTo().window(child_window);

				// print child window header
				String pageHeader = driver.findElement(By.tagName("h1")).getText();
				System.out.println("cw header - " + pageHeader);
				Assert.assertEquals("This is a sample page", pageHeader);
				driver.close();
			}
		}
		// switch to the parent window
		driver.switchTo().window(pw);
		System.out.println("pw title - " + driver.getTitle());
		System.out.println("parent wnidowHandle- " + pw);
		Assert.assertEquals("DEMOQA", driver.getTitle());
		Thread.sleep(1000);
	}
}
