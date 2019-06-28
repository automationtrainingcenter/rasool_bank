package utilitiles;

import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper {

	protected WebDriver driver;

	public void openBrowser(String browserName, String url) {
		browserName = browserName.toUpperCase();
		switch (browserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", GenericHelper.getFilePath("drivers", "chromedriver.exe"));
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", GenericHelper.getFilePath("drivers", "geckodriver.exe"));
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("invalid browser name");
		}

		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void closeBrowser() {
		if (driver.getWindowHandles().size() > 1) {
			driver.quit();
		} else {
			driver.close();
		}
	}

	public void sleep(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
