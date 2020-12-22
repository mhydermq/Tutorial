package handlingFrame;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * existance of iframes in a web page can be 
 * identified in two ways, by Right-click on 
 * the specific element and check all the options, 
 * if we find optons like this frame, view frame source, 
 * or Reload frame, then the web page contains iframes.
 * 
 *  if we click on view page source and find 
 *  iframe tags in page then the page contains iframe.
 *  
 *  frames can be identified by an id or name attribute or 
 *  their index and the focus can be switched to the frame 
 *  by driver.switchTo().frame() method, the defaultContent()
 *  method is used to switch the focus back to the page.
 * @author hyder
 *
 */

public class HandlingIFrames {
	
	static WebDriver driver;
	static String url="http://www.naukri.com/";
	
	@BeforeClass	
	public void setUp(){
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get(url);
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	@Test(enabled=true)
	public void handleFrame() {
		String actualTitle = "Jobs - Recruitment - Job Search - Employment -Job Vacancies - Naukri.com";
		Assert.assertEquals(driver.getTitle(), actualTitle);
		//driver.findElement(By.name(""));	
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();	
		
	}

}
