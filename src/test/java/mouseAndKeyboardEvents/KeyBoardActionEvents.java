package mouseAndKeyboardEvents;

//https://stqatools.com/selenium-keyboard-events/
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActionEvents {

public static void main(String[] args) {

System.setProperty("webdriver.gecko.driver","D:\\geckodriver.exe");

WebDriver driver = new FirefoxDriver();

driver.get("https://www.stqatools.com");

// Create object of Action class
Actions action = new Actions(driver);

// Sendkeys using Action class object
action.sendKeys(Keys.ENTER).build().perform();

// Send mulyiple keys using action class
action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

}

}