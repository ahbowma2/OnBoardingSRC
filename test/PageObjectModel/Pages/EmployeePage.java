package test.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/*
Extend the BasePage to have access to the driver and wait functions
*/

public class EmployeePage extends BasePage {

	/*
	 Creates employee methods for entering employee info and finding employee related elements

	 Method Descriptions:
	 	AddEmployeePage = 			Clicks the button to open the new employee creation info.

	 	EditEmployee = 				Clicks the button after finding an employee to edit their info.

	 	EmployeeInfo = 				Input the string values into the webelements that are associated
	 	 			   				with the employee info.

		SubmitExistingEmployee = 	Submit the edit of an employee.

		SubmitNewEmployee = 		Submit the new employee.

	 	EmployeeDeptLook =          Most confusing one on this page. It finds the drop down for department
	 	 							and selects the department specified on the test page.
	 */

	public void AddEmployeePage() {
		driver.findElement(By.cssSelector("button[data-target='#modal_1']")).click();
	}

	public void EditEmployee() {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-target='#modal_1']")));
		WebElement editEmp = driver.findElement(By.cssSelector("button[data-target='#modal_1']"));
		editEmp.click();
	}

	public void EmployeeInfo(String strUserName, String strFirstName, String strLastName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_username")));
		WebElement userName = driver.findElement(By.id("employee_username"));
		WebElement firstName = driver.findElement(By.id("employee_first_name"));
		WebElement lastName = driver.findElement(By.id("employee_last_name"));
		userName.clear();
		userName.sendKeys(strUserName);
		firstName.clear();
		firstName.sendKeys(strFirstName);
		lastName.clear();
		lastName.sendKeys(strLastName);
	}

	public void SubmitExistingEmployee() {
		driver.findElement(By.cssSelector("input[value = 'Update Employee']")).click();
	}

	public void SubmitNewEmployee() {
		driver.findElement(By.cssSelector("input[value = 'Create Employee']")).click();
	}

	public void EmployeeDeptLook(String deptName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_department_id")));
		Select select = new Select(driver.findElement(By.id("employee_department_id")));
		select.selectByVisibleText(deptName);
	}

}
