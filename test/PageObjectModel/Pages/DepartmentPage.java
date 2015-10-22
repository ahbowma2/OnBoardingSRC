package test.PageObjectModel.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/*
Extend the BasePage to have access to the driver and wait functions
*/

public class DepartmentPage extends BasePage {

	/*
	 Creates department methods for entering department info and finding department related elements

	 Method Descriptions:
	 	CreateDept = Clicks the add new department button to open up the info for creating a new department.

	 	NameDept = Put in the info that is generated on the test level to name the new department.

	 	SubmitNewDept = Submits the department to offically create it.
	 */
	public void CreateDept() {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/departments/new']")));
		driver.findElement(By.cssSelector("a[href='/departments/new']")).click();
	}

	public void NameDept(String deptName) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("department_name")));
		WebElement deptNameField = driver.findElement(By.id("department_name"));
		deptNameField.clear();
		deptNameField.sendKeys(deptName);
	}

	public void SubmitNewDept() {
		WebElement deptSubmitButton = driver.findElement(By.name("commit"));
		deptSubmitButton.click();
	}


}
