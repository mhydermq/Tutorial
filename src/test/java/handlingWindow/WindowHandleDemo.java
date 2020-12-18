package handlingWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandleDemo {
	public static void main(String[] args) throws Exception {
        //driver set up
		WebDriverManager.chromedriver().setup();
		//creating a ChromeDriver instance
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Loading the website
		driver.get("http://www.naukri.com/");

		// return the parent window name as a String
		String pw =driver.getWindowHandle();
		System.out.println("parent window name- "+pw);
		// get the child window names as a set of strings
		Set<String> set =driver.getWindowHandles();
		System.out.println("windowHandles are- "+ set);

		//iterate child windows using Iterator
		Iterator<String> ite= set.iterator();
		while(ite.hasNext()){
		String child_window=ite.next();
		if(!pw.equals(child_window)){
		driver.switchTo().window(child_window);
        //print the titles of the child windows
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.close();
		  }
	}
		//switch to the parent window
		driver.switchTo().window(pw);
		System.out.println("wnidowHandle- " + pw);
		driver.quit();

		}
	}


