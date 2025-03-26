package mouseAndKeyboardEvents;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;


public class MouseHoverTest extends DriverSetUp {
	
	@Test(description="Demo of Mouse Hover", priority = 6, enabled = true)
    public void test_mouse_hover() throws InterruptedException {
        
		driver.navigate().to("https://www.lambdatest.com/pricing");
 
        try {
            Actions action = new Actions(driver);
 
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,300)", "");
            WebElement what_are_parallel_tests = driver.findElement(By.xpath("//*[@id='dropdown']/div[1]/div/div[1]/span"));
            Thread.sleep(2000);
            action.moveToElement(what_are_parallel_tests).click().build().perform();
 
            WebElement elem_hover_body = driver.findElement(By.xpath(""));
            Thread.sleep(2000);
            action.moveToElement(elem_hover_body).build().perform();
           
            
            Thread.sleep(2000);
            /* Click on the Link */
            By locator = By.linkText("Calculate how many parallel sessions you need.");
        
 
            /* WebDriverWait wait = new WebDriverWait(web_driver, 5); */
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
 
            String parentWindowHandle = driver.getWindowHandle();
 
            /* Check if the link is clicked by comparing the window title */
            Set<String> allWindowHandles = driver.getWindowHandles();
            Iterator<String> iterator1= allWindowHandles.iterator();
 
            while(iterator1.hasNext())
            {
                String chld_window = iterator1.next();
                if (!parentWindowHandle.equalsIgnoreCase(chld_window)) {
                    driver.switchTo().window(chld_window);
                    System.out.println("Switched to the child window");
                }
            }
 
            System.out.println("Current Window title is: " + driver.getTitle());
            Assert.assertEquals(driver.getTitle(), "Concurrency Calculator For LambdaTest Selenium Automation Gird");
            System.out.println("Mouse Hover test case successful\n");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
