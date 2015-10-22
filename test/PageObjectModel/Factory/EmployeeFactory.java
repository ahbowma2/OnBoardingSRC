package test.PageObjectModel.Factory;

import test.PageObjectModel.Pages.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class EmployeeFactory extends BasePage {

	/*
	 Execute findbys and assign them to a webelement name, FindBy is basically the same as driver.findelement.by
	 */

	@FindBy(css = "button[data-target='#modal_1']")
	WebElement clickAddEmp;

	@FindBy(css = "button[data-target='#modal_1']")
	WebElement clickEditEmp;

	@FindBy(id = "employee_username")
	WebElement empUserName;

	@FindBy(id = "employee_first_name")
	WebElement empFirstName;

	@FindBy(id = "employee_last_name")
	WebElement empLastName;

	@FindBy(css = "input[value = 'Update Employee']")
	WebElement submitEditEmp;

	@FindBy(css = "input[value = 'Create Employee']")
	WebElement submitNewEmp;

	@FindBy(id = "employee_department_id")
	WebElement deptDropDown;

	@FindBy(id = "employee_status")
	WebElement statusDropDown;

	/*
	 Initiate the driver and page factory
	 */

	public EmployeeFactory(WebDriver driver) {
		BasePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/*
	 Assign webelements to a method
	 */

	public void setUserName(String strUserName) {
		empUserName.sendKeys(strUserName);
	}

	public void setFirstName(String strFirstName) {
		empFirstName.sendKeys(strFirstName);
	}

	public void setLastName(String strLastName) {
		empLastName.sendKeys(strLastName);
	}

	public void empCreateClick() {
		clickAddEmp.click();
	}

	public void empEditClick() {
		clickEditEmp.click();
	}

	public void empAddSubmit() {
		submitNewEmp.click();
	}

	public void empEditSubmit() {
		submitEditEmp.click();
	}

	public void deptDrop(String strDeptName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		Select select = new Select(deptDropDown);
		select.selectByVisibleText(strDeptName);
	}

	public void empDrop(){
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		Select select = new Select(statusDropDown);
		select.selectByVisibleText("Inactive");
	}

	/*
	 Combine the methods in larger methods to be called.

	 Method Descriptions:
	 	deptDrop / empDrop ^^^^^= 					Selects the dropdown on the employee page and selects the string specified on the test page.

	 	addEmployeeInBlueSource = 	Clicks to add an employee, enters the string information given on the test page
	 	 							and inputs it into the corresponding web elements then finds the drop down and
	 	 							selects the department infothat is given at the test level then submits the new employee.

	 	editEmployeeInBlueSource = 	Clicks an existing employee after navigating to it through the navigation page
	 	 							then edits the employee to select the department info that is given at the test level
	 	 							then submits the edited employee.

	 	removeEmployeeInBlueSource= Clicks an existing employee and makes them inactive to remove them from the base employee list
	 */



	public void addEmployeeInBlueSource(String strUserName, String strFirstName, String strLastName,
			String strDeptName) {
		this.empCreateClick();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_username")));
		this.setUserName(strUserName);
		this.setFirstName(strFirstName);
		this.setLastName(strLastName);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		this.deptDrop(strDeptName);
		this.empAddSubmit();
	}

	public void editEmployeeInBlueSource(String strDeptName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-target='#modal_1']")));
		this.empEditClick();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		this.deptDrop(strDeptName);
		this.empEditSubmit();
	}

	public void removeEmployeeInBlueSource(){
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-target='#modal_1']")));
		this.empEditClick();
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		this.empDrop();
		this.empEditSubmit();
	}
}
