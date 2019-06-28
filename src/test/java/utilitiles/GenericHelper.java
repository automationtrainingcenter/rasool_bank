package utilitiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class GenericHelper {
	public static String getFilePath(String folderName, String fileName) {
		return System.getProperty("user.dir") + File.separator + folderName + File.separator + fileName;
	}

	// helper method which will read data from a properties file
	public static String getProperty(String folderName, String fileName, String propertyName) {
		try {
			FileInputStream fis = new FileInputStream(getFilePath(folderName, fileName));
			Properties prop = new Properties();
			prop.load(fis);
			return prop.getProperty(propertyName);

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
