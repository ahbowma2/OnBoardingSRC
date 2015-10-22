package test.PageObjectModel.Factory;

import test.PageObjectModel.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DepartmentFactory extends BasePage {

	/*
	 Execute findbys and assign them to a webelement name, FindBy is basically the same as driver.findelement.by
	 */

	@FindBy(id = "department_name")
	WebElement deptName;

	@FindBy(css = "a[href='/departments/new']")
	WebElement newDept;

	@FindBy(name = "commit")
	WebElement deptSubmit;

	/*
	 Initiate the driver and page factory
	 */

	public DepartmentFactory(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 Assign webelements to a method
	 */

	public void setDeptName(String strDeptName) {
		deptName.sendKeys(strDeptName);
	}

	public void deptCreateClick() {
		newDept.click();
	}

	public void deptSubmitClick() {
		deptSubmit.click();
	}

	/*
	 Combine the methods in one large method to be called.

	 Method Description:
	 	createDeptInBlueSource = Clicks to create department then enters the new department details
	 							 given on the test page and submits the new department.
	 */

	public void createDeptInBlueSource(String strDeptName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/departments/new']")));
		this.deptCreateClick();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department_name")));
		this.setDeptName(strDeptName);
		this.deptSubmitClick();
	}
}
