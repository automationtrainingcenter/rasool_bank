package utilitiles;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	private static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	private static String getTimeStamp() {
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("HH_mm_ss-dd_MMM_yy");
		return df.format(date);
	}

	public static void captureScreenshot(WebDriver driver, String folderName, String fileName) {
		// convert WebDriver object reference to TakeScreenshot object reference
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File destImg = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
		try {
			BufferedImage bi = ImageIO.read(src);
			ImageIO.write(bi, "png", destImg);
		} catch (Exception e) {
			System.out.println("image not avaible");
		}
	}

	// alert screenshot
	public static void captureAlertScreenshot(String folderName, String fileName) {
		try {
			// get the screen size using ToolKit class
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			// create a Rectangle class object which accepts Dimension class object
			Rectangle rect = new Rectangle(screenSize);
			// create a Robot class object
			Robot r = new Robot();
			// capture the screenshot using Rectangle class object
			BufferedImage bi = r.createScreenCapture(rect);
			// provide destination location of the image
			File destLoc = new File(getFilePath(folderName, fileName + getTimeStamp() + ".png"));
			// save the file to the destination location using ImageIO class
			ImageIO.write(bi, "png", destLoc);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

//	public static void main(String[] args) {
//		System.out.println(getTimeStamp());
//	}
}
