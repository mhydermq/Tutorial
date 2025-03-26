package mouseAndKeyboardEvents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

/**
 * Slider movement using moveByOffset
 */

public class MoveByOffsetTest extends DriverSetUp{
	
	@Test(description="Demo of MoveByOffset (ClickAndHold)", priority = 4, enabled = true)
    public void test_clickhold_move_by_offset() throws InterruptedException {
        
		driver.navigate().to("https://jqueryui.com/slider/");
        try{
            Actions action = new Actions(driver);
            driver.switchTo().frame(0);
            WebElement elem_slider = driver.findElement(By.cssSelector(".ui-slider-handle"));
            Thread.sleep(2000);
            action.clickAndHold(elem_slider).moveByOffset(40,0).release().perform();
 
            System.out.println("Drag & Drop test case successful\n");
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
