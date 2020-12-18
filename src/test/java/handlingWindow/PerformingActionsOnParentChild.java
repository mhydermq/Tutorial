package handlingWindow;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * performing some actions on the Browserstack website.
 * 
 * Use the javascriptexecutor to scroll down through a page.
 * 
 * Find the element using XPath and send keys (which is of 
 * the form string) to that particular element location.
 * 
 * Declare the web element Link to click on a particular link 
 * on the page. In this case, the link must open in a new window.
 * 
 * Get the window handles of all the windows and print them in a 
 * sequential manner.
 * 
 * Switch to the parent window and check if the title matches. 
 * If it does, scroll down the page using the javascriptexecutor.
 * 
 * Find another element on the web page using the element locator 
 * and specify the position of the new window.
 * 
 * Switch back to the parent window and scroll down through the page.
 * @author hyder
 *
 */

public class PerformingActionsOnParentChild {
	public static void main(String[] args) throws Exception{ 
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver(); 
	driver.get("https://www.browserstack.com/"); 
	String title = driver.getTitle(); System.out.println(title);

	JavascriptExecutor js = (JavascriptExecutor) driver; 
	driver.findElement(By.xpath("//span[contains(text(),'Solutions')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Geolocation Testing')]")).click();
	js.executeScript("window.scrollBy(0,40)"); 

	WebElement link = driver.findElement(By.xpath("//a[@id='product-menu-toggle']"
			+ "//span[@class='account-down-caret']//*[local-name()='svg']")); 
	Actions newwin = new Actions(driver); 
	newwin.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform(); 
	//Thread.sleep(2000); 
	//js.executeScript("window.scrollBy(0,400)"); 
	Thread.sleep(3000); 
	
	Set<String> windows = driver.getWindowHandles(); 
	System.out.println(windows); 
	System.out.println("a1"); 
	
	for (String window : windows) {
	driver.switchTo().window(window); 
	
	if (driver.getTitle().contains("Most Reliable App & "
			+ "Cross Browser Testing Platform | Browserstack")){
	System.out.println("a2"); 
	js.executeScript("window.scrollBy(0,1000)"); 
	System.out.println("b1");
	driver.findElement(By.xpath("//a[@id='logo']//*[local-name()='svg']")).click();

	driver.findElement(By.xpath("//a[@id='signupModalButton']")).click(); 
	driver.manage().window().setPosition(new Point(2000, 0)); 
	    } 
	} 
	Thread.sleep(3000); 
	Set<String> windows1 = driver.getWindowHandles(); 
	System.out.println(windows1); 
	System.out.println("a3"); 
	
	for (String window : windows1){
	driver.switchTo().window(window); 
	System.out.println("a4"); 
	js.executeScript("window.scrollBy(0,400)");
	driver.quit();
	        } 
	   } 
	}

