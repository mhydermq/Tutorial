package javascriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import baseClass.DriverSetUp;

/**
 * current application's page URL using driver.getCurrentUrl(); and domain name
 * using JavascriptExecutor.
 * 
 */
public class CurrentUrlAndDomain extends DriverSetUp {

	@Test
	public void getUrlAndDomainName() {
		driver.get("https://gmail.com");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);

		// get and store domain name
		JavascriptExecutor jsc = (JavascriptExecutor) driver;
		String domainName = (String) jsc.executeScript("return document.domain");
		System.out.println("domain name is: " + domainName);

	}
}
