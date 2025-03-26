package handlingFrame;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class NestedAndIframes extends DriverSetUp {

	static String url = "https://the-internet.herokuapp.com/nested_frames";
	static String Url = "https://the-internet.herokuapp.com/iframe";

	@Test(priority = 0, enabled = true)
	public void handlingNestedframe() throws InterruptedException {

		driver.get(url);
		Thread.sleep(2000);

		driver.switchTo().frame("frame-top");
		List<WebElement> nestedFrames = driver.findElements(By.tagName("frame"));
		System.out.println("no of nested frames: " + nestedFrames.size());
		Assert.assertEquals(3, nestedFrames.size());

		driver.switchTo().frame("frame-right");
		WebElement rightFrame = driver.findElement(By.tagName("body"));
		String rightFrameText = rightFrame.getText();
		System.out.println("rightFrameText: " + rightFrameText);
		Assert.assertEquals("RIGHT", rightFrameText);

		driver.switchTo().defaultContent();
		List<WebElement> frameSet = driver.findElements(By.tagName("frame"));
		System.out.println("no of frame set:" + frameSet.size());
		Assert.assertEquals(2, frameSet.size());

		driver.switchTo().frame("frame-bottom");
		WebElement frame_bottom = driver.findElement(By.tagName("body"));
		System.out.println("bottom frame text: " + frame_bottom.getText());
		Assert.assertEquals("BOTTOM", frame_bottom.getText());

		driver.switchTo().defaultContent();

	}

	@Test(priority = 1, enabled = true)
	public void testIframe() throws InterruptedException {

		driver.get(Url);

		// By finding all the web elements using iframe tag
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("number of iframes are " + iframeElements.size());

		driver.switchTo().frame("mce_0_ifr");
		WebElement textArea = driver.findElement(By.xpath("//*[@id='tinymce']/p"));
		textArea.clear();
		textArea.sendKeys("Hello World!");

		Thread.sleep(1000);

		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		Assert.assertEquals("Hello World!", text);


	}

}
