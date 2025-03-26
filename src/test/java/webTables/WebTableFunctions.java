package webTables;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebTableFunctions {

	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		//https://www.techlistic.com/p/demo-selenium-practice.html

		WebElement t = driver.findElement(By.tagName("table"));
		List<WebElement> rows = t.findElements(By.tagName("tr")); // t stands for table
		System.out.println("row size: "+rows.size());
		getColumnNumber(t, "Company");
		verifyValue(t, 2, "Francisco Chang");
		verifyText(t);
		verifyColumnValue(t, 1, "Centro comercial Moctezuma");
		getColValue(1, 3, driver);
		getColValue(6, 3);
		getCellNumber("Helen Bennett");

		driver.quit();
	}

	// find the column number for the given column name in a table.
	static int getColumnNumber(WebElement r, String columnName) {
		List<WebElement> cells = r.findElements(By.tagName("th"));
		int c = 0;
		for (WebElement cell : cells) {
			c = c + 1;
			System.out.println(c + " --> " + cell.getText());
			if (columnName.equals(cell.getText()))
				break;
		}
		//System.out.println(c);
		return c;
	}

	/*
	 * check, if the value in a given cell matches the desired value. The function
	 * takes 3 parameters. The first parameter is the row element, the second
	 * parameter is the column number, and third parameter is the expected value.
	 */

	static boolean verifyValue(WebElement r, int a, String expValue) {
		List<WebElement> mcells = r.findElements(By.tagName("td"));
		int c = 0;
		for (WebElement cell : mcells) {
			c = c + 1;
			if (c == a) {
				// get the value inside cell with the getText() method
				if (expValue.equals(cell.getText()))
					return true;
			}
		}
		return false;
	}

	// find the text in each cell
	static void verifyText(WebElement r) {
		List<WebElement> mcells = r.findElements(By.tagName("td"));
		for (WebElement cell : mcells) {
			System.out.println(cell.getText());

		}
	}
	
	
	// under construction
	static void verifyColumnValue(WebElement r, int a, String expValue) {
		List<WebElement> mcells = r.findElements(By.tagName("td"));
		int c = 0;
		for (WebElement cell : mcells) {
			c = c + 1;
			if (c == a) {
				// get the value inside cell with the getText() method
				if (expValue.equals(cell.getText())) {
					System.out.println("true");
				}
				else {
					System.out.println("false");
				}
			}
		}
	}

	// get text using cell number
	public static String getColValue(int row, int col, WebDriver driver) {
		WebElement colValue = driver
				.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (row + 1) + "]/td[" + col + "]"));
		System.out.println("cell 1,3 value: " + colValue.getText());
		return colValue.getText();

	}

	// get text using cell number-overloaded method
	public static String getColValue(int row, int col) {
		WebElement colValue = driver
				.findElement(By.xpath("//table[@id='customers']/tbody/tr[" + (row + 1) + "]/td[" + col + "]"));
		System.out.println(row + ", " + col + " cell value: " + colValue.getText());
		return colValue.getText();

	}

	// get cell number-using cell value/text
	static void getCellNumber(String cellText) {
		int rowCount = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		int colCount = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		System.out.println("rowCount: "+rowCount);
		System.out.println("colCount: "+colCount);
		

		for (int row = 1; row < rowCount; row++) {
			for (int column = 1; column <= colCount; column++) {
				String actualValue = 
						driver.findElement(By.
								xpath("//table[@id='customers']/tbody/tr[" + (row + 1) + "]/td[" + column + "]"))
						.getText();
				if (actualValue.equals(cellText)) {
					System.out.println("cellNum: " + row + " , " + column);
					break;
				}
			}
		} 
	}

	// Mouse and keyboard events
	public void testRowSelectionUsingControlKey() {
		List<WebElement> tableRows = 
				driver.findElements(By.xpath("//table[@class='iceDatTbl']/tbody/tr"));
		// Select second and fourth row from table using Control Key.
		// Row Index start at 0
		Actions builder = new Actions(driver);
		builder
		.click(tableRows.get(1))
		.keyDown(Keys.CONTROL)
		.click(tableRows.get(3))
		.keyUp(Keys.CONTROL)
		.build().perform();
		// Verify Selected Row table shows two rows selected
		List<WebElement> rows = driver
				.findElements(By.xpath("//div[@class='icePnlGrp exampleBox']/table[@class='iceDatTbl']/tbody/tr"));
		assertEquals(2, rows.size());
	}
}
