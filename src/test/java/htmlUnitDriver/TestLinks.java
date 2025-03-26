package htmlUnitDriver;

import java.time.Duration;

//import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TestLinks {

	@Test
	public void linkTest() throws Exception {
		// To declare and initialize HtmlUnitDriver
		WebDriver driver = new HtmlUnitDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Open https://www.wikipedia.org/
		driver.get("https://www.wikipedia.org/");
		// https://www.wikipedia.org/"
		// "https://www.humanapharmacy.com/login.cmd"
		System.out.println("Home page title is - " + driver.getTitle());

		// get all the links displayed on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("total no. of links = " + links.size());

		// verify there are four links displayed on the page
		// assertEquals(325, links.size());

		// iterate through the list of links and print target for each link
		// for (WebElement link : links)
		// System.out.println(link.getAttribute("href"));
		for (WebElement link : links) {
			if (link.getAttribute("href") == null)
				System.out.println("broken link");
		}
		// quit session
		driver.quit();
	}
}
