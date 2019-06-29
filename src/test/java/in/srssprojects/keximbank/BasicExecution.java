package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BasicExecution extends TestExecution {
	@BeforeClass(groups= {"data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset","cancel"})
	public void lanch() {
		openBrowser("chrome", "http://srssprojects.in");
		bankHomePage = new BankHomePage(driver);
	}

	@AfterClass(groups = { "data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset", "cancel" })
	public void close() {
		closeBrowser();
	}

}
