package in.srssprojects.keximbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BankHomePage {
	private WebDriver driver;

	// username
	public WebElement username() {
		WebElement username = driver.findElement(By.id("txtuId"));
		return username;
	}

	// password
	public WebElement password() {
		WebElement password = driver.findElement(By.id("txtPword"));
		return password;
	}

	// login
	public WebElement login() {
		return driver.findElement(By.id("login"));
	}

	public BankHomePage(WebDriver driver) {
		this.driver = driver;
	}

	// fill username
	public void fillUserName(String username) {
		this.username().sendKeys(username);
	}

	// fill password
	public void fillPassword(String password) {
		this.password().sendKeys(password);
	}

	// click login
	public void clickLogin() {
		this.login().click();
	}
	
	//verify bank home page
	public boolean isLoginDisplayed() {
		return this.login().isDisplayed();
	}

}
