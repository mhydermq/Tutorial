package handlingCookies;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookie {

 @SuppressWarnings("deprecation")
public static void main(String[] args) {
  String exePath = "C:\\Users\\hyder\\Downloads\\chromedriver_win32\\chromedriver.exe";
  System.setProperty("webdriver.chrome.driver", exePath);
  WebDriver driver = new ChromeDriver();
  
  driver.get("https://only-testing-blog.blogspot.com/2014/01/textbox.html");
  
  //Add cookie with name, value, domain, path, expiry, isSecure and isHTTPOnly.
  driver.manage().addCookie(new Cookie("Cookiename1", "cookieval1",
		  ".only-testing-blog.blogspot.com", "/", new Date((2035-1900),05,07), false, true));
Cookie cookieobj = new Cookie("Cookiename2", "cookieval2", 
		".only-testing-blog.blogspot.com", "/", new Date((2035-1900),03,06), false, true);
  driver.manage().addCookie(cookieobj);
  driver.manage().addCookie(new Cookie("Cookiename3", "cookieval3",
		  ".only-testing-blog.blogspot.com", "/", new Date((2035-1900),03,06), false, true));
 
  //Get all cookie details from browser using getCookies().  
  Set<Cookie> cookies = driver.manage().getCookies();
    
  //Iterate through cookies to isolate each cookie and print.
  Iterator<Cookie> value = cookies.iterator();   
  while (value.hasNext()) { 
         System.out.println(value.next()); 
  }
  
  //Delete cookie by name
  driver.manage().deleteCookieNamed("Cookiename1");
  //Deleting cookie using deleteCookie
  driver.manage().deleteCookie(cookieobj);
  
  System.out.println("\n");
  System.out.println("********** Cookies after deleting cookies by"
  		+ " name and cookie object of current browsing context **************");
  System.out.println("\n");
    
  //Get all cookie details from browser after deleting cookie by name and deleteCookie() method. 
  Set<Cookie> cookies1 = driver.manage().getCookies();
      
  //Iterate through cookies to isolate each cookie and print.
  Iterator<Cookie> value1 = cookies1.iterator();   
  while (value1.hasNext()) { 
         System.out.println(value1.next()); 
  }
 }
 
}
