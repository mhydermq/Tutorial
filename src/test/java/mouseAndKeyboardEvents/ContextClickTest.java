package mouseAndKeyboardEvents;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

/*
 * Go to http://medialize.github.io/jQuery-contextMenu/demo.html
 * Locate the element “right click me”
 * Right click on the element located in Step(2)
 * Select the item “paste” in the Context Menu
 * Assert if the required item in the Context Menu is not clicked
 * 
 */

public class ContextClickTest extends DriverSetUp {
	
	@Test(description="Context Click", enabled = true)
    public void test_context_click() throws InterruptedException {
        
		driver.navigate().to("http://medialize.github.io/jQuery-contextMenu/demo.html");
 
        try {
            Actions action = new Actions(driver);
 
            By locator = By.xpath("/html/body/div/section/div/div/div/p/span");
 
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            WebElement element = driver.findElement(locator);
            action.contextClick(element).build().perform();
 
            WebElement element_edit = driver.findElement(By.xpath
                    ("/html/body/ul/li[4]/span"));
 
            Thread.sleep(5000);
            element_edit.click();
 
            Alert alert = driver.switchTo().alert();
            String textEdit = alert.getText();
            System.out.println(textEdit);
            Assert.assertEquals(textEdit, "clicked: paste", "Context Click successful");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }    

}
