package in.srssprojects.keximbank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BranchDetailspage {
	
	WebDriver driver;
	
	@FindBy(id = "BtnNewBR")
	private WebElement newbranch;
	
	public BranchDetailspage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BranchCreationpage clickNewbranch() 
	{
		this.newbranch.click();
		return PageFactory.initElements(driver, BranchCreationpage.class);
	}
	
	//verify branch details page
	public boolean isNewBranchDisplayed() {
		return this.newbranch.isDisplayed();
	}
	
}


