package coordinates;

//http://www.projectdebug.com/xy-coordinates-of-a-webelement-in-selenium/
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class XYCoordinates {

	  WebDriver driver;
	 @BeforeTest
	 public void setup(){
	  System.setProperty("webdriver.chrome.driver", 
			  "C:\\Users\\hyder\\Downloads\\chromedriver_win32\\chromedriver.exe");
	 }
	 
	 @AfterMethod
	 public void endTest() {
		 driver.quit();
	 }
	 
      
	 //to get XY coordinates of a webelement in selenium webdriver
	  @Test
	 public void getCoordinates(){
	  driver = new ChromeDriver();
	  driver.get("https://www.google.com");
	  WebElement element = driver.findElement(By.id("hplogo"));
	  
	  Point location = element.getLocation();
	  int x = location.getX();
	  int y = location.getY();
	  System.out.println("Coordinates of the element is : " + x + " and " + y);
	  System.out.println("*exiting @Test with no priority");
	 }
	  
	 //the size of our webelement in height and width.
	  @Test(priority=0)
	 public void getHeightWidth(){
	  driver = new ChromeDriver();
	  driver.get("https://www.google.com");
	  WebElement element = driver.findElement(By.id("hplogo"));
	  System.out.println(element.getText());

	   int elementWidth = element.getSize().getWidth();
	  System.out.println("Element width: "+ elementWidth);
	  int elementHeight = element.getSize().getHeight();
	  System.out.println("Element width: "+ elementHeight);

	 }

	}