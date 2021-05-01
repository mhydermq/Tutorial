package handlingAjax;


/**
 * When we perform any action on Ajax controls, using Wait commands 
 * will not work as the page is not actually refreshed here. Pausing 
 * the test execution using threads for a certain period of time is 
 * also not a good approach as web element might appear later or earlier 
 * than the stipulated period of time depending on the system’s 
 * responsiveness, load or other uncontrolled factors of the moment, 
 * leads to test failures.The best approach would be to wait for the 
 * required element in a dynamic period and then continue the test 
 * execution as soon as the element is found/visible.
*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AjaxExample {		
		private String URL = "http://demos.telerik.com/aspnet-ajax/"+
	                                  "ajax/examples/loadingpanel/explicitshowhide/defaultcs.aspx";
		
		WebDriver driver;
		WebDriverWait wait;
		
		@BeforeClass
		public void setUp() {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.navigate().to(URL);
		}
		
		@Test
		public void test_AjaxExample() {
			/*Wait for grid to appear*/
			By container = By.cssSelector(".demo-container");
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.presenceOfElementLocated(container));
			
			/*Get the text before performing an ajax call*/
			WebElement noDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
			String textBeforeAjaxCall = noDatesTextElement.getText().trim();
			
			/*Click on the date*/
			driver.findElement(By.linkText("1")).click();
		
			/*Wait for loader to disappear */
			By loader = By.className("raDiv");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
			
			/*Get the text after ajax call*/
			WebElement selectedDatesTextElement = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
			wait.until(ExpectedConditions.visibilityOf(selectedDatesTextElement));
			String textAfterAjaxCall = selectedDatesTextElement.getText().trim();
			
			/*Verify both texts before ajax call and after ajax call text.*/
			Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);
			
			String expectedTextAfterAjaxCall = "Thursday, January 01, 2015";
			
			/*Verify expected text with text updated after ajax call*/
			Assert.assertEquals(textAfterAjaxCall, expectedTextAfterAjaxCall);
		}

}


