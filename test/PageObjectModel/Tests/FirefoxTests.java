package test.PageObjectModel.Tests;

import org.testng.annotations.Test;
import org.apache.commons.lang3.RandomStringUtils;
import test.PageObjectModel.Pages.BasePage;
import test.PageObjectModel.Pages.DepartmentPage;
import test.PageObjectModel.Pages.EmployeePage;
import test.PageObjectModel.Pages.LoginPage;
import test.PageObjectModel.Pages.NavigatePage;
import test.PageObjectModel.Pages.VerificationPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirefoxTests {
	/*
		Calling to the webdriver
	*/
	private WebDriver _driver;
	/*
		Call to the page classes in the page object model and set them to a variable
	*/
	BasePage Base;
	DepartmentPage Dept;
	EmployeePage Emp;
	LoginPage Login;
	NavigatePage Nav;
	VerificationPage Verify;
	WebDriverWait Wait;
	/*
		Create random strings to call to later, can be removed and import a data sheet if that is preferred.
		I feel this is better when I am testing without given variables for specific tests
	*/

	String deptName = "M" + RandomStringUtils.randomAlphabetic(6) + " Department";
	String uName = RandomStringUtils.randomAlphabetic(6);
	String fName = RandomStringUtils.randomAlphabetic(8);
	String lName = RandomStringUtils.randomAlphabetic(8);

	/*
		Before/After methods. These are performed before and after each test or class
	*/

	@BeforeClass()
	public void startClassFF() {
		System.out.println("Starting Firefox Class");

	}

	@AfterClass()
	public void endClassFF() {
		System.out.println("Ending Firefox Class");
		System.out.println("================================================================");
	}

	/*
		Here I am instantiating the variable from the page object model that I called above and calling to the driver variable created to the Basepage
	*/
	@BeforeMethod()
	public void start() {
		System.out.println("Starting Method");
		_driver = test.PageObjectModel.Pages.BasePage.GetFFDriver();
		Nav = new test.PageObjectModel.Pages.NavigatePage();
		Base = new test.PageObjectModel.Pages.BasePage();
		Dept = new test.PageObjectModel.Pages.DepartmentPage();
		Emp = new test.PageObjectModel.Pages.EmployeePage();
		Login = new test.PageObjectModel.Pages.LoginPage();
		Verify = new test.PageObjectModel.Pages.VerificationPage();
	}
	/*
	 	Here is where the called driver is closed so that it doesn't stay open and get confused by duplicate drivers.
	*/

	@AfterMethod
	public void end() {
		_driver.close();
		_driver.quit();
		System.out.println("Ending Method");
	}

	/*
		Here I run the test for FF using page object model.
	KEY:****************************************************************************************************
		Base 	- Calls to the base page, mostly for screenshots.
		Nav 	- Calls to navigation page for navigation within the browser.
		Login 	- Calls to login page just for the initial step of logging in with a username and password.
		Dept 	- Calls to department page for activities such as creating and naming a new or existing dept.
				  DeptLook is for finding a created department in a dropdown on an employee page.
		Emp 	- Calls to employee page for creating a new employee with a username, first name and last name.
			 	  It is also used to find and edit existing employees.
		Verify 	- Calls to verification page to verify that other methods worked properly. This includes making sure
			 	  that the newly created department or employee exists and that all the attributes with that is included
	/KEY****************************************************************************************************
	*/

	@Test
	public void Test1FF() throws Exception {
		Nav.NavToBase("");
		Login.LoginInfo("company.admin", "1234");
		Login.SubmitLogin();
		Verify.VerifyLogin();
		Nav.NavToDeptPage();
		Dept.CreateDept();
		Dept.NameDept(deptName);
		Dept.SubmitNewDept();
		Verify.VerifyDeptAdd();
		Base.Screenshot("DeptAddEvidenceFF");
		Verify.VerifyNewDeptExists(deptName);
		Base.Screenshot("DeptAdd2ListEvidenceFF");
		Nav.NavToBase("");
		Emp.AddEmployeePage();
		Emp.EmployeeInfo(uName, fName, lName);
		Emp.EmployeeDeptLook(deptName);
		Emp.SubmitNewEmployee();
		Verify.VerifyEmpAdd();
		Base.Screenshot("EmpAddEvidenceFF");
		Nav.NavToEmployeeBar(lName);
		Nav.NavToNewEmployeeClick();
		Verify.VerifyEmpAddHasDept(deptName);
		Base.Screenshot("EmpAddHadDeptEvidenceFF");
		Nav.NavToBase("");
		Nav.NavToEmployeeClick();
		Emp.EditEmployee();
		Emp.EmployeeDeptLook(deptName);
		Emp.SubmitExistingEmployee();
		Verify.VerifyEmpEdit();
		Base.Screenshot("EmpEditEvidenceFF");
		Verify.VerifyEmpEditHasDept(deptName);
		Base.Screenshot("EmpEditHasDeptEvidenceFF");

	}

}