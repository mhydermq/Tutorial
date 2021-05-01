package interrogation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VisibilityConditions {
	 
    public static void main(String[] args) {
    	
           WebDriverManager.firefoxdriver().setup();
           // objects and variables instantiation
           WebDriver driver = new FirefoxDriver();
           String appUrl = "https://google.com";

           // launch the firefox browser and open the application url
           driver.get(appUrl);

           // maximize the browser window
           driver.manage().window().maximize();

           // declare and initialize the variable to store the expected title of the webpage.
           String expectedTitle = "Google";

           // fetch the title of the web page and save it into a string variable
           String actualTitle = driver.getTitle();

           // compare the expected title of the page with the actual title of the page and print the result
           if (expectedTitle.equals(actualTitle))
           {
                  System.out.println("Verification Successful - The correct title is displayed on the web page.");
           }
           else
           {
                  System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
           }

           // verify if the “Google Search” button is displayed and print the result
           boolean submitbuttonPresence=driver.findElement(By.xpath("//input[@class='gNO89b']")).isDisplayed();
           System.out.println(submitbuttonPresence);

           // enter the keyword in the “Google Search” text box by which we would want to make the request
           WebElement searchTextBox = driver.findElement(By.name("q"));
           searchTextBox.clear();
           searchTextBox.sendKeys("Selenium");

           // verify that the “Search button” is displayed and enabled
           boolean searchIconPresence = driver.findElement(By.xpath("//input[@class='gNO89b']")).isDisplayed();
           boolean searchIconEnabled = driver.findElement(By.xpath("//input[@class='gNO89b']")).isEnabled();

           if (searchIconPresence==true && searchIconEnabled==true)
           {
                  // click on the search button
                  WebElement searchIcon = driver.findElement(By.xpath("//input[@class='gNO89b']"));
                  searchIcon.click();
           }

           //close the web browser
          driver.close();
          System.out.println("Test script executed successfully.");

         //terminate the program
         System.exit(0);
    }
}