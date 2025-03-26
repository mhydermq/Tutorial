package interrogation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class VisibilityConditions extends DriverSetUp {

	@Test
	public void testVisibilityConditions() throws InterruptedException {
		String appUrl = "https://google.com";
		driver.get(appUrl);

		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();

		// compare the expected title of the page with the actual title of the page
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("Verification Successful - The correct title is displayed on the web page.");
		} else {
			System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
		}

		// verify if the “Google Search” button is displayed
		boolean googleSearchbuttonPresence = driver.findElement(
				By.xpath("//input[@name='btnI']//following::center/input[1]")).isDisplayed();
		System.out.println(googleSearchbuttonPresence);

		//enter the keyword in the “Google Search” text box
		WebElement searchTextBox = driver.findElement(By.name("q"));
		searchTextBox.clear();
		searchTextBox.sendKeys("Selenium");
			Thread.sleep(100);
		

		// verify that the “Search button” is displayed and enabled
		boolean searchIconPresence = 
				driver.findElement(By.xpath("//input[@class='gNO89b']")).isDisplayed();
		boolean searchIconEnabled = 
				driver.findElement(By.xpath("//input[@class='gNO89b']")).isEnabled();

		if (searchIconPresence == true && searchIconEnabled == true) {
			// click on the search button
			WebElement searchIcon = driver.findElement(By.xpath("//input[@class='gNO89b']"));
			searchIcon.click();
				Thread.sleep(1000);
		}

	}
}