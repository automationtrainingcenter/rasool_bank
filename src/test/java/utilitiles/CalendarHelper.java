package utilitiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CalendarHelper {

	public static void selectDate(WebElement tbody, String date) {
		boolean status = false;
		// locate rows inside the table body
		List<WebElement> rows = tbody.findElements(By.tagName("tr"));
		// iterate over the rows
		for (WebElement row : rows) {
			// locate cells in every row
			List<WebElement> cells = row.findElements(By.tagName("td"));
			// iterate over the cells
			for (WebElement cell : cells) {
				// get the cell text and compare it will given date
				if (cell.getText().endsWith(date)) {
					cell.findElement(By.tagName("button")).click();
					status = true;
					break; // breaks the cells loop
				}
			}
			// break the rows loop
			if (status) {
				break;
			}
		}
	}

}
