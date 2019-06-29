package in.srssprojects.keximbank;

import javax.xml.crypto.Data;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utilitiles.BrowserHelper;

public class TestExecution extends BrowserHelper {

	BankHomePage bankHomePage;
	AdminHomePage adminHomePage;
	RoleDetailsPage roleDetailsPage;
	RoleCreationPage roleCreationPage;
	BranchDetailspage branchDetailsPage;
	BranchCreationpage branchCreationPage;
	EmployeeDetailspage employeeDetailsPage;
	EmployeeCreationpage employeeCreationPage;

	Alert alert;

	@Test(priority = 0,groups= {"data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset","cancel"})
	public void loginTest() {
		bankHomePage.fillUserName("Admin");
		bankHomePage.fillPassword("Admin");
//		sleep(3000);
		bankHomePage.clickLogin();
		adminHomePage = PageFactory.initElements(driver, AdminHomePage.class);
		Assert.assertTrue(adminHomePage.verifyAdminHomePage());
	}

	@Test(priority = 1, groups= {"role", "valid"})
	public void roleCreationWithValidData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("newRoleNameseven");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Created Sucessfully"));
	}

	@Test(priority = 2, dependsOnMethods= {"roleCreationWithValidData"}, groups= {"role", "duplicate"})
	public void roleCreationWithDuplicateData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("newRoleNamefive");
		roleCreationPage.selectRoleType("E");
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 3, groups= {"role", "blank"})
	public void roleCreationWithBlankData() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		alert = roleCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}
	
	@Test(priority = 4, groups= {"role", "reset"})
	public void roleCreationReset() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName("newRoleNameOne");
		roleCreationPage.selectRoleType("E");
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isRoleNameEmpty());
	}
	
	@Test(priority = 5, groups= {"role", "cancel"})
	public void roleCreationCancel() {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleDetailsPage = roleCreationPage.clickCancel();
		Assert.assertTrue(roleDetailsPage.isNewRoleDispalyed());
	}

	@Test(priority = 6, groups= {"branch", "valid"})
	public void branchCreationWithValidData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchNMO");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));

	}

	@Test(priority = 7, groups= {"branch", "duplicate"})
	public void branchCreationDuplicateDate() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchNMO");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}
	
	@Test(priority = 8, groups= {"branch", "blank"})
	public void branchCreationBlankData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		alert = branchCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following"));
	}

	@Test(priority = 9, groups= {"branch", "reset"})
	public void branchCreationResetData() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchCreationPage.fillbranchName("newBranchN");
		branchCreationPage.fillAdress1("Addressbranch1");
		branchCreationPage.fillZipcode("56467");
		branchCreationPage.selectcountry("INDIA");
		branchCreationPage.selectstate("Andhra Pradesh");
		branchCreationPage.selectcity("Hyderabad");
		branchCreationPage.clickReset();
		Assert.assertTrue(branchCreationPage.isBranchNameEmpty());

	}

	@Test(priority = 10, groups= {"branch", "cancel"})
	public void branchCreationCancel() {
		branchDetailsPage = adminHomePage.clickBranches();
		branchCreationPage = branchDetailsPage.clickNewbranch();
		branchDetailsPage = branchCreationPage.clickCancel();
		Assert.assertTrue(branchDetailsPage.isNewBranchDisplayed());

	}

	@Test(priority = 11, groups= {"employee", "valid"})
	public void employeeCreationWithValidData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshinessts");
		employeeCreationPage.fillLoginpassword("12345");
		employeeCreationPage.selectRoleType("Manager");
		employeeCreationPage.selectBranchType("Hyderabad");
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("created Sucessfully"));
	}

	@Test(priority = 12, groups= {"employee", "duplicate"})
	public void employeeCreationWithDuplicateData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshinessts");
		employeeCreationPage.fillLoginpassword("12345");
		employeeCreationPage.selectRoleType("Manager");
		employeeCreationPage.selectBranchType("Hyderabad");
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("already Exist"));
	}

	@Test(priority = 13, groups= {"employee", "blank"})
	public void employeeCreationBlankData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		alert = employeeCreationPage.clickSubmit();
		String alertText = alert.getText();
		System.out.println(alertText);
		alert.accept();
		Assert.assertTrue(alertText.contains("Please fill in the following fields"));
	}

	@Test(priority = 14, groups= {"employee", "reset"})
	public void employeeCreationWithRestData() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName("sunshine");
		employeeCreationPage.fillLoginpassword("12345");
		employeeCreationPage.selectRoleType("manager");
		employeeCreationPage.selectBranchType("changed");
		employeeCreationPage.clickReset();
		Assert.assertTrue(employeeCreationPage.isEmployeeNameEmpty());

	}

	@Test(priority = 15, groups= {"employee", "cancel"})
	public void employeeCreationCancel() {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeDetailsPage = employeeCreationPage.clickCancel();
		Assert.assertTrue(employeeDetailsPage.isNewEmployeeDisplayed());

	}
	
	@Test(priority = 16, groups= {"data_driven"}, dataProviderClass=DataProviders.class, dataProvider = "empData")
	public void employeeCreationResetWithDP(String empName, String loginPass, String roleName, String branchName) {
		employeeDetailsPage = adminHomePage.clickEmployees();
		employeeCreationPage = employeeDetailsPage.clickNewEmployee();
		employeeCreationPage.fillEmployerName(empName);
		employeeCreationPage.fillLoginpassword(loginPass);
		employeeCreationPage.selectRoleType(roleName);
		employeeCreationPage.selectBranchType(branchName);
		employeeCreationPage.clickReset();
		Assert.assertTrue(employeeCreationPage.isEmployeeNameEmpty());

	}
	
	@Test(priority = 17, groups= {"data_driven"}, dataProviderClass=DataProviders.class, dataProvider = "roleData")
	public void roleCreationResetWithDP(String roleName, String roleType) {
		roleDetailsPage = adminHomePage.clickRoles();
		roleCreationPage = roleDetailsPage.clickNewRole();
		roleCreationPage.fillRoleName(roleName);
		roleCreationPage.selectRoleType(roleType);
		roleCreationPage.clickReset();
		Assert.assertTrue(roleCreationPage.isRoleNameEmpty());
	}

	@Test(priority = 20, groups= {"data_driven", "employee", "duplicate", "branch", "role", "valid", "blank", "reset","cancel"})
	public void logout() {
		bankHomePage = adminHomePage.clickLogout();
		Assert.assertTrue(bankHomePage.isLoginDisplayed());

	}

}
