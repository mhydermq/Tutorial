package webelementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * getLocation(): element location on the page. 
 * getSize(): returns width and height of the element.
 * getTagName(): gets the tag name of the current element.
 * getText(): gets visible text of an element.
 * @author hyder
 */

public class ExampleWebEleMethods {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", 
				"C:\\Users\\hyder\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		String Url = "https://google.com";
		driver.get(Url);
		WebElement sigin = driver.findElement(By.id("gb_70"));
		
		//getLocation() WebElement method
		Point location = sigin.getLocation();
		System.out.println("Location of X: "+ location.getX()+ ", " 
		+"Location of Y: " +location.getY());
		
		//getSize() WebElement method
		Dimension size = sigin.getSize();
		System.out.println("Width: "+size.getWidth()+ ", " 
		+"Height: "+size.getHeight());
		
		//getText() WebElement method
		String text = sigin.getText();
		System.out.println("Text: " +text);
		
		//getTagName() WebElement method
		String tagName = sigin.getTagName();
		System.out.println("Tagname: "+tagName);
		
		//close the browser
		driver.quit();
	}

}
