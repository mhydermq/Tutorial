package openingNewTab;

public class OpenATab {
	
/**	
	//open a new tab in the same browser
	driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
	
	// switch to it to be able to work with the newly opened tab
	ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(tabs.get(0));

*/
}
