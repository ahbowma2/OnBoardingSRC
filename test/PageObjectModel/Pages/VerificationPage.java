package test.PageObjectModel.Pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/*
 Extend the BasePage to have access to the driver and wait functions
 */

public class VerificationPage extends BasePage {

	/*-
	 Create verification methods - they find an element to see that it is where it should be.
	 It then sends out a message if it is successful, if unsuccessful it sends an error message and throws it

	 Method Descriptions:
	 	VerifyLogin = 				Verifies login is successful through locating a logout element.

	 	VerifyEmpEdit = 			Verifies that an employee was successfully edited.

	 	VerifyEmpEditHasDept = 		Goes to a page and verifies the selected department is associated with newly edited employee.

	 	VerifyEmpAddHasDept = 		Goes to a page and verifies the selected department is associated with the newly added employee.

	 	VerifyEmpAdd = 				Verifies a success element is displayed on the page after submitting a new employee.

	 	VerifyDeptAdd = 			Verifies a success element is displayed on the page after submitting a new department.

	 	VerifyNewDeptExists = 		Verifies the new department exists by finding it on the page after the submit.
	 */

	public void VerifyLogin() {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		try {
			WebElement panel = driver.findElement(By.linkText("Logout"));
			Assert.assertTrue(panel.isDisplayed(), "ALERT: User was not logged in");
			System.out.println("Message: Login was successful");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyEmpEdit() throws Exception {
		Wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='alert alert-success alert-dismissable']")));
		try {
			WebElement panel = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissable']"));
			Assert.assertTrue(panel.isDisplayed(), "ALERT: Employee edit failed");
			System.out.println("Message: Employee was successfully edited");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyEmpEditHasDept(String strDeptName) throws Exception {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		try {
			boolean panel = driver.getPageSource().contains(strDeptName);
			Assert.assertTrue(panel, "ALERT: Edited Emp Department add failed");
			System.out.println("Message: Department was successfully added to edited employee info");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyEmpAddHasDept(String strDeptName) throws Exception {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		try {
			boolean panel = driver.getPageSource().contains(strDeptName);
			Assert.assertTrue(panel, "ALERT: Added Emp Department add failed");
			System.out.println("Message: Department was successfully added to added employee info");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyEmpAdd() throws Exception {
		Wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='alert alert-success alert-dismissable']")));
		try {
			WebElement panel = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissable']"));
			Assert.assertTrue(panel.isDisplayed(), "ALERT: Employee add failed");
			System.out.println("Message: Employee was successfully added");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyDeptAdd() throws Exception {
		Wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector("div[class='alert alert-success alert-dismissable']")));
		try {
			WebElement panel = driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissable']"));
			Assert.assertTrue(panel.isDisplayed(), "ALERT: Department add failed");
			System.out.println("Message: Department was successfully added");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}

	public void VerifyNewDeptExists(String strDeptName) throws Exception {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		try {
			boolean panel = driver.getPageSource().contains(strDeptName);
			Assert.assertTrue(panel, "ALERT: Department add failed");
			System.out.println("Message: Department was successfully added to Department list");
		} catch (NoSuchElementException f) {
			System.err.println(f.getMessage());
			throw (f);
		}
	}
}
