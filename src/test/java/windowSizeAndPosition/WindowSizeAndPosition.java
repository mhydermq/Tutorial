package windowSizeAndPosition;

/**
 * What Is window size and position?
 * 
 * Window size means height and width of window.
 * 
 * Window position means distance of window from 
 * left side(X Coordinates) of screen and 
 * top side(Y Coordinates) of screen.
 */

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.annotations.Test;

import baseClass.DriverSetUp;

public class WindowSizeAndPosition extends DriverSetUp {

	@Test(priority = 1)
	public void setGetWinSize() throws InterruptedException {
		// WebDriver setSize method used to set window size width = 300 and height =
		// 500.
		driver.manage().window().setSize(new Dimension(300, 500));
		Thread.sleep(2000);

		// WebDriver getSize method used to get window width and height.
		System.out.println("Window height Is -> " + driver.manage().window().getSize().getHeight());
		System.out.println("Window width Is -> " + driver.manage().window().getSize().getWidth());
	}

	@Test(priority = 2)
	public void setGetWinPosition() throws InterruptedException {
		// WebDriver setPosition method used to set window position x coordinate = 50
		// and y coordinate = 100.
		driver.manage().window().setPosition(new Point(50, 200));
		Thread.sleep(2000);

		// WebDriver getPosition method used to get window position x,y coordinates.
		System.out.println("Window position X coordinates Is -> " + driver.manage().window().getPosition().getX());
		System.out.println("Window position Y coordinates Is -> " + driver.manage().window().getPosition().getY());
	}

}
