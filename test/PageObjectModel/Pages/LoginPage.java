package test.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
Extend the BasePage to have access to the driver and wait functions
*/

public class LoginPage extends BasePage {

	/*
	 Creates login methods for entering the website specified in navigation.

	 Method Descriptions:
	 	LoginInfo = 		Finds the user input elements and inputs the strings put in on the test page.
	 	
	 	SubmitLogin = 		Finds the submit button after entering elements and clicks it.

	 */

	public void LoginInfo(String strLoginName, String strLoginPass) {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("employee_username")));
		WebElement loginName = driver.findElement(By.id("employee_username"));
		WebElement loginPass = driver.findElement(By.id("employee_password"));
		loginName.clear();
		loginName.sendKeys(strLoginName);
		loginPass.clear();
		loginPass.sendKeys(strLoginPass);
	}

	public void SubmitLogin() {
		WebElement loginSubmitButton = driver.findElement(By.name("commit"));
		loginSubmitButton.click();
	}
}
