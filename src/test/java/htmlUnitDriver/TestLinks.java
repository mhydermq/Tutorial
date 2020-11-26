package htmlUnitDriver;

//import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

  public class TestLinks{
  
  @Test
  public void linkTest() throws Exception{
  // To declare and initialize HtmlUnitDriver
  WebDriver driver = new HtmlUnitDriver();
  
  //WebDriver driver = new HtmlUnitDriver(BrowserVersion.)
  // Set implicit wait
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  
  // Open https://www.wikipedia.org/
   driver.get("https://www.humanapharmacy.com/login.cmd");
   //https://www.wikipedia.org/"
   //"https://www.humanapharmacy.com/login.cmd"
   System.out.println("Home page title is - " + driver.getTitle());
/*
  //search for cheese
  WebElement element = driver.findElement(By.xpath("//*[@id='searchInput']"));
  element.sendKeys("english");
  element.submit();

  // Get the title of the current page and store it in the variable Title
  String Title = driver.getTitle();

  // Print the title of the current page
  System.out.println("I am at " +Title); */

 //get all the links displayed on the page
  List<WebElement> links = driver.findElements(By.tagName("a"));
  System.out.println("total no. of links = " + links.size());
  
  //verify there are four links displayed on the page 
  //assertEquals(325, links.size());
 
  //iterate through the list of links and print target for each link
  //for (WebElement  link : links)
 // System.out.println(link.getAttribute("href"));
  for (WebElement link:links) {
  	if(link.getAttribute("href")==null)
  		System.out.println("broken link");
  }
 //quit session
  driver.quit();
      }
  }

