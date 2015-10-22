package test.PageObjectModel.Tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PageObjectModel.Factory.DepartmentFactory;
import test.PageObjectModel.Factory.EmployeeFactory;
import test.PageObjectModel.Factory.LoginFactory;
import test.PageObjectModel.Pages.BasePage;
import test.PageObjectModel.Pages.NavigatePage;
import test.PageObjectModel.Pages.VerificationPage;

public class _FactoryFirefoxTests {
	/*
		Calling to the webdriver
	*/
	private WebDriver _driver;
	/*
		Call to the page classes and factories in the page object model and set them to a variable
	*/
	LoginFactory Login;
	DepartmentFactory Department;
	EmployeeFactory Employee;
	NavigatePage Navigate;
	VerificationPage Verify;
	BasePage Base;
	WebDriverWait Wait;
	/*
		Create random strings to call to later, can be removed and import a data sheet if that is preferred.
		I feel this is better when I am testing without given variables for specific tests
	*/
	String deptName = "M" + RandomStringUtils.randomAlphabetic(6) + " Department";
	String uName = "T" + RandomStringUtils.randomAlphabetic(6);
	String fName = "S" + RandomStringUtils.randomAlphabetic(5);
	String lName = "B" + RandomStringUtils.randomAlphabetic(5);

	/*
		Before/After methods. These are performed before and after each test or class
	*/

	@BeforeClass()
	public void startClassFF() {
		System.out.println("Starting Firefox Factory Class");

	}

	@AfterClass()
	public void endClassFF() {
		System.out.println("Ending Firefox Class");
		System.out.println("================================================================");
	}

	/*
		Here I am instantiating the variable from the page object model and factory that I called above and calling to the driver variable created to the Basepage
	*/

	@BeforeMethod()
	public void start() {
		System.out.println("Starting Method");
		_driver = test.PageObjectModel.Pages.BasePage.GetFFDriver();
		Base = new test.PageObjectModel.Pages.BasePage();
		Navigate = new test.PageObjectModel.Pages.NavigatePage();
		Verify = new test.PageObjectModel.Pages.VerificationPage();
		Employee = new test.PageObjectModel.Factory.EmployeeFactory(_driver);
		Department = new test.PageObjectModel.Factory.DepartmentFactory(_driver);
		Login = new test.PageObjectModel.Factory.LoginFactory(_driver);
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

	/*-
	 	Here I run the test for FF using page object model.
	KEY:****************************************************************************************************
		Base 		- Calls to the base page, mostly for screenshots.
		Navigate	- Calls to navigation page for navigation within the browser.
		Login 		- Calls to login factory just for the initial step of logging in with a username and password.
		Department 	- Calls to department factory for activities such as creating and naming a new or existing dept.
		Employee 	- Calls to employee factory for creating a new employee with a username, first name and last name.
		 		      It is also used to find and edit existing employees.
		Verify 		- Calls to verification page to verify that other methods worked properly. This includes making sure
		 		  	  that the newly created department or employee exists and that all the attributes with that is included
	/KEY****************************************************************************************************
	*/
	@Test
	public void FactoryTest1FF() throws Exception {
		Navigate.NavToBase("");
		Login.loginToBlueSource("company.admin", "1234");
		Verify.VerifyLogin();
		Navigate.NavToDeptPage();
		Department.createDeptInBlueSource(deptName);
		Verify.VerifyDeptAdd();
		Base.Screenshot("FactoryDeptAddEvidenceFF");
		Verify.VerifyNewDeptExists(deptName);
		Base.Screenshot("DeptAdd2ListEvidenceFF");
		Navigate.NavToBase("");
		Employee.addEmployeeInBlueSource(uName, fName, lName, deptName);
		Verify.VerifyEmpAdd();
		Base.Screenshot("FactoryEmpAddEvidenceFF");
		Navigate.NavToEmployeeBar(lName);
		Navigate.NavToNewEmployeeClick();
		Verify.VerifyEmpAddHasDept(deptName);
		Base.Screenshot("FactoryEmpAddHadDeptEvidenceFF");
		Navigate.NavToBase("");
		Navigate.NavToEmployeeClick();
		Employee.editEmployeeInBlueSource(deptName);
		Verify.VerifyEmpEdit();
		Base.Screenshot("FactoryEmpEditEvidenceFF");
		Verify.VerifyEmpEditHasDept(deptName);
		Base.Screenshot("FactoryEmpEditHasDeptEvidenceFF");
	}
}
