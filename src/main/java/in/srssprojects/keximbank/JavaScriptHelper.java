package in.srssprojects.keximbank;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptHelper {

	public static String getText(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return arguments[0].value", ele).toString();
	}

	public static void bringElementToView(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}

	public static void scrollPageBy(WebDriver driver, long x, long y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.documentElement.scrollBy(arguments[0], arguments[1])", x, y);
	}

	public static Object executeScript(WebDriver driver, String arg0, Object... arg1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(arg0, arg1);
	}

}
