package handlingAjax;

import java.time.Duration;

/**
 * When we perform any action on Ajax controls, using Wait commands 
 * will not work as the page is not actually refreshed here. Pausing 
 * the test execution using threads for a certain period of time is 
 * also not a good approach as webelement might appear later or earlier 
 * than the stipulated period of time depending on the system’s 
 * responsiveness, load or other uncontrolled factors of the moment, 
 * leads to test failures.The best approach would be to wait for the 
 * required element in a dynamic period and then continue the test 
 * execution as soon as the element is found/visible.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class AjaxExample extends DriverSetUp {

	private static String URL = "http://demos.telerik.com/aspnet-ajax/"
			+ "ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx";

	WebDriverWait wait;

	@Test
	public void test_AjaxExample() {
		driver.navigate().to(URL);
		
		/* Wait for grid to appear */
		By container = By.cssSelector(".demo-container");
		wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		wait.until(ExpectedConditions.presenceOfElementLocated(container));

		/* Get the text before performing an ajax call */
		WebElement noDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		String textBeforeAjaxCall = noDatesTextElement.getText().trim();
		System.out.println("textBeforeAjaxCall" + textBeforeAjaxCall);

		/* Click on the date */
		driver.findElement(By.linkText("1")).click();

		/* Wait for loader to disappear */
		By loader = By.className("raDiv");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		/* Get the text after ajax call */
		WebElement selectedDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
		String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
		System.out.println("textAfterAjaxCall: " + textAfterAjaxCall);

		/* Verify both texts before ajax call and after ajax call text. */
		Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);

		String expectedTextAfterAjaxCall = "Monday, May 1, 2023";

		/* Verify expected text with text updated after ajax call */
		Assert.assertEquals(textAfterAjaxCall, expectedTextAfterAjaxCall);
	}

}
