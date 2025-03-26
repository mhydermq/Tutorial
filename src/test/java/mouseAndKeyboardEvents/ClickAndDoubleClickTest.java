package mouseAndKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class ClickAndDoubleClickTest extends DriverSetUp {
    
	//mouse click action
	@Test(description = "mouse click action", enabled = true)
	public void testClick() throws InterruptedException {

		driver.navigate().to("https://www.amazon.in/");
		try {
			Actions action = new Actions(driver);

			//locate the search box
			WebElement elementToType = driver.findElement(By.cssSelector("#twotabsearchtextbox"));

			//search for iphone 
			action.sendKeys(elementToType, "iphone").build().perform();
			WebElement elementToClick = driver.findElement(By.xpath("//input[@value='Go']"));
			Thread.sleep(5000);
			
			//click of the Search Button
			action.click(elementToClick).build().perform();

			Thread.sleep(5000);
			Assert.assertEquals(driver.getTitle(), "Amazon.in : iphone");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
    
	//double click action
	@Test(description = "double Click action", enabled = true)
	public void test_double_click() throws InterruptedException {

		String str_dblClick = "dblClick";

		driver.navigate().to("https://unixpapa.com/js/testmouse.html");
		Thread.sleep(2000);
		try {
			Actions action = new Actions(driver);

			WebElement elem_clear = driver.findElement(By.xpath("//a[.='click here to clear']"));
			Thread.sleep(2000);
			elem_clear.click();
            
			//double click on “click here to test”
			WebElement elem_test_btn = driver.findElement(By.xpath("//a[.='click here to test']"));
			Thread.sleep(2000);
			action.doubleClick(elem_test_btn).build().perform();

			
			 //Search for “dblclick” in the text area, Verify double click action was successful
			WebElement text_area = driver.findElement(By.cssSelector("textarea"));
			String textattr = text_area.getAttribute("value");
			System.out.println(textattr);

			String bodyText = driver.findElement(By.tagName("textarea")).getText();
			Assert.assertFalse(bodyText.contains(str_dblClick), "Text found!");
			System.out.println("Double Click test case successful\n");
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
	  }
	}
}
