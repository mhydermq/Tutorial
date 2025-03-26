package webelementMethods;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class FontTypeSizeColor extends DriverSetUp {

	@Test
	public void fontTest() throws InterruptedException {

		driver.get("https://www.wikipedia.org/");
		Thread.sleep(1000);

		String fontStyle = driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong"))
				.getCssValue("font-style");
		System.out.println("fontType: " + fontStyle);

		String fontSize = driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong"))
				.getCssValue("font-size");
		System.out.println("fontSize: " + fontSize);

		String fontColor = driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong"))
				.getCssValue("color");
		System.out.println("fontColor: " + fontColor);

		String backGroundColor = driver.findElement(By.xpath("//*[@id='js-link-box-en']/strong"))
				.getCssValue("background-color");
		System.out.println("backGroundColor: " + backGroundColor);

	}

}
