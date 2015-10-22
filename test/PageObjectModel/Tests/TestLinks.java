package test.PageObjectModel.Tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.PageObjectModel.Factory.LoginFactory;
import test.PageObjectModel.Pages.BasePage;
import test.PageObjectModel.Pages.NavigatePage;
import test.PageObjectModel.Pages.RandomShitPage;
import test.PageObjectModel.Pages.VerificationPage;

public class TestLinks{
	/*
	Calling to the webdriver
*/
private WebDriver _driver;
/*
	Call to the page classes and factories in the page object model and set them to a variable
*/
LoginFactory Login;
NavigatePage Navigate;
VerificationPage Verify;
BasePage Base;
WebDriverWait Wait;
RandomShitPage rnd;
int i;

@BeforeClass()
public void startClassFF() {
	System.out.println("Starting Firefox Factory Class");
	_driver = test.PageObjectModel.Pages.BasePage.GetGCDriver();
	Base = new test.PageObjectModel.Pages.BasePage();
	Navigate = new test.PageObjectModel.Pages.NavigatePage();
	Login = new test.PageObjectModel.Factory.LoginFactory(_driver);
	rnd = new test.PageObjectModel.Pages.RandomShitPage();
	Navigate.NavToBase("");
	Login.loginToBlueSource("company.admin", "1234");
	//_driver.get("http://www.wingingitinmotown.com");

}

@AfterClass()
public void endClassFF() {
	_driver.close();
	_driver.quit();
	System.out.println("Ending Firefox Class");
	System.out.println("================================================================");
}

/*
	Here I am instantiating the variable from the page object model and factory that I called above and calling to the driver variable created to the Basepage
*/

@BeforeMethod()
public void start() {
	System.out.println("Starting Method");

}


/*
 	Here is where the called driver is closed so that it doesn't stay open and get confused by duplicate drivers.
*/
@AfterMethod
public void end() {

	System.out.println("Ending Method");
}

@Test
public void dfgdfg() throws Exception {
	rnd.findLinks();


}}