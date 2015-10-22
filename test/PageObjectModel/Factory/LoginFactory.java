package test.PageObjectModel.Factory;

import test.PageObjectModel.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginFactory extends BasePage {
	/*
	 Execute findbys and assign them to a webelement name, FindBy is basically the same as driver.findelement.by
	 */
	@FindBy(id = "employee_username")
	WebElement loginName;

	@FindBy(id = "employee_password")
	WebElement password;

	@FindBy(name = "commit")
	WebElement loginButton;

	/*
	 Initiate the driver and page factory
	 */

	public LoginFactory(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 Assign webelements to a method
	 */

	public void setUserName(String strUserName) {
		loginName.sendKeys(strUserName);
	}

	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}

	public void clickLogin() {
		loginButton.click();
	}
	/*
	 Combine the methods in one large method to be called.

	 Method Description:
	 	LoginToBlueSource = Puts in the strings indicated on the test level into the weblements
	 						of username and password and then submits the login.
	 */
	public void loginToBlueSource(String strUserName, String strPassword) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_username")));
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}

}