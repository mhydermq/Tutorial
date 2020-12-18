/**
 * handling elements with multiple class names
 */
package navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ElementWithMultipleClassNames {
	 
	@Test(priority=0)
	public void multipleClassnameWithClassNameLocator(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");		
		driver.findElement(By.className("required_field cityPadRight ac_input origin_ac")).sendKeys("DELHI");
		System.out.println("Page title0- "+ driver.getTitle());
	}
	
	@Test(priority=1)
	public void multipleClassnameWithXPathLocator(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		driver.findElement(By.xpath("//input[@class='required_field cityPadRight ac_input origin_ac']"))
		.sendKeys("DELHI");
		System.out.println("Page title1- "+ driver.getTitle());
	}
	
	@Test(priority=2,enabled=false)
	public void multipleClassnameWithCssSelectorLocator(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		driver.findElement(By.cssSelector("input[class='required_field cityPadRight ac_input origin_ac']"))
		.sendKeys("DELHI");
		System.out.println("Page title2- "+ driver.getTitle());
	}
	
	@Test
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithNode(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		// Combine all class names with dot and append tag name i.e. tagName.classname1.classname2.classname3
		driver.findElement(By.cssSelector("input.required_field.cityPadRight.ac_input.origin_ac']"));
	}
	
	@Test
	public void multipleClassnameWithCssSelectorLocatorCombiningClassWithoutNode(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(); 
		driver.get("https://www.yatra.com/");
		// Combine all class names with dot and append a dot at starting 
		//i.e. .classname1.classname2.classname3
		driver.findElement(By.cssSelector(".required_field.cityPadRight.ac_input.origin_ac']"))
		.sendKeys("DELHI");
	}
}