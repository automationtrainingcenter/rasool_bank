package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

//page factory
public class AdminHomePage {
	private WebDriver driver;

	// home
	@FindBy(css = "a[href *= 'adminflow']")
	private WebElement home;

	// logout
	@FindBy(how = How.CSS, using = "a[href *= 'home']")
	private WebElement logout;

	// branches
	@FindBy(how = How.CSS, using = "a[href *= 'banker_master']")
	private WebElement branches;

	// roles
	@FindBy(how = How.CSS, using = "a[href *= 'Roles']")
	private WebElement roles;

	// employees
	@FindBy(how = How.CSS, using = "a[href *= 'Emp']")
	private WebElement employees;
	
	
	public AdminHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// click on home button
	public AdminHomePage clickHome() {
		this.home.click();
		return PageFactory.initElements(driver, AdminHomePage.class);
	}

	// click on logout button
	public BankHomePage clickLogout() {
		this.logout.click();
		return PageFactory.initElements(driver, BankHomePage.class);
	}

	// click branches
	public BranchDetailspage clickBranches() {
		this.branches.click();
		return PageFactory.initElements(driver, BranchDetailspage.class);
	}

	// click roles
	public RoleDetailsPage clickRoles() {
		this.roles.click();
		return PageFactory.initElements(driver, RoleDetailsPage.class);
	}

	// click employees
	public EmployeeDetailspage clickEmployees() {
		this.employees.click();
		return PageFactory.initElements(driver, EmployeeDetailspage.class);
	}
	
	//verify Admin home page with welcome to admin message and logout link
	public boolean verifyAdminHomePage() {
		return this.logout.isDisplayed();
	}

}
