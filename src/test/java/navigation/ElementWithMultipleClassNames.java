/**
 * handling elements with multiple class names
 */
package navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ElementWithMultipleClassNames {
	
	WebDriver driver;
	 
	@BeforeClass
	public void multipleClassnameWithClassNameLocator(){
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");		
		//driver.findElement(By.className("required_field cityPadRight ac_input origin_ac")).sendKeys("DELHI");
		System.out.println("Page title0- "+ driver.getTitle());
	}
	
	@Test(priority=0,enabled=true)
	public void multipleClassnameWithXPathLocator(){
		driver.findElement(By.xpath("//input[@class='required_field cityPadRight ac_input origin_ac']"))
		.sendKeys("DELHI");
		System.out.println("Page title1- "+ driver.getTitle());
	}
	
	@Test(priority=1,enabled=true)
	public void multipleClassnameWithCssSelectorLocator(){
		driver.findElement(By.cssSelector("input[class='required_field cityPadRight ac_input origin_ac']"))
		.sendKeys("DELHI");
		System.out.println("Page title2- "+ driver.getTitle());
	}
	
	@Test(priority=2,enabled=true)
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithNode(){
		// Combine all class names with dot and append tag name i.e. tagName.classname1.classname2.classname3
		driver.findElement(By.cssSelector("input.required_field.cityPadRight.ac_input.origin_ac']"));
	}
	
	@Test(priority=3,enabled=true)
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithoutNode(){
		// Combine all class names with dot and append a dot at starting 
		//i.e. .classname1.classname2.classname3
		driver.findElement(By.cssSelector(".required_field.cityPadRight.ac_input.origin_ac']"))
		.sendKeys("DELHI");
	}
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}
	
}