package coordinates;

//http://www.projectdebug.com/xy-coordinates-of-a-webelement-in-selenium/
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;


public class XYCoordinates extends DriverSetUp {
     
	static String url="https://www.google.com";
	 
	// XY coordinates of a webelement in selenium webdriver
	  @Test(priority=1)
	 public void getCoordinates(){
	  driver.get(url);
	  WebElement element = driver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a"));
	  Point location = element.getLocation();
	  int x = location.getX();
	  int y = location.getY();
	  System.out.println("Coordinates of the element is : " + x + " and " + y);
	  System.out.println("*exiting @Test with priority 1 ");
	 }
	  
	 
	  // size of our webelement in height and width.
	  @Test(priority=0)
	 public void getHeightWidth(){
	  driver.get(url);
	  WebElement element = driver.findElement(By.xpath("//*[@id='gb']/div/div[2]/a"));
	  System.out.println(element.getText());

	   int elementWidth = element.getSize().getWidth();
	  System.out.println("Element width: "+ elementWidth);
	  int elementHeight = element.getSize().getHeight();
	  System.out.println("Element Height : "+ elementHeight);
	 

	 }

	}