package in.srssprojects.keximbank;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridExecution extends TestExecution {
	@BeforeClass(groups = {"data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset", "cancel" })
	@Parameters({ "brName", "url", "nodeUrl", "os" })
	public void lanch(String browserName, String url, String nodeUrl, String os) {
		openBrowser(browserName, url, nodeUrl, os);
		bankHomePage = new BankHomePage(driver);
	}

	@AfterClass(groups = { "data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset", "cancel" })
	public void close() {
		closeBrowser();
	}

}
