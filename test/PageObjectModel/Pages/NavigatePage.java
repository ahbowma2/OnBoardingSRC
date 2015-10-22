package test.PageObjectModel.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/*
 Extend BasePage for access to driver, wait and _baseurl string
 */

public class NavigatePage extends BasePage {

	/*-
	 Create navigation methods: These methods navigate around the browser window, this includes going to certain urls or
	 locating elements for input from other classes

	 Method Descriptions
	 	Navigate Page = 		The mail page URL as a string.

	 	NavToBase = 			Goes to the homepage, if you enter a string that will be added to the end of the url.

	 	NavToDeptPage = 		Self Explanatory.

	 	NavToEmployeeBar = 		This goes to the search bar for employees on the home page.

	 	NavToNewEmployeeClick = Clicks the newly created employee after the info is thrown into the employee search bar.

	 	NavToEmployeeClick = 	Clicks the first employee in the list for editing, it will be the only employee available.
	 							if the employee name is put in the employee search bar.
	 */
	public NavigatePage() {
		_baseUrl = "https://bluesourcestaging.herokuapp.com";
	}

	public void NavToBase(String url) {
		String navigateToThisUrl = _baseUrl + url;
		driver.navigate().to(navigateToThisUrl);
	}

	public void NavToDeptPage() {
		WebElement adminButton = driver.findElement(By.linkText("Admin"));
		WebElement deptButton = driver.findElement(By.cssSelector("a[href='/admin/departments']"));
		adminButton.click();
		deptButton.click();
	}

	public void NavToEmployeeBar(String strLastName) {
		WebElement searchBar = driver.findElement(By.cssSelector("input[id='search-bar']"));
		searchBar.clear();
		searchBar.sendKeys(strLastName);
	}

	public void NavToNewEmployeeClick() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[@class=' js ']/body/div[@id='content']/section[@id='ng-app']/div[@id='all-content']/div[@id='resource-content']/div[@class='table-responsive']/table[@class='table table-bordered table-condensed table-hover']/tbody/tr[@class='ng-scope']/td[1]/a[@class='ng-binding']")));
		WebElement newEmp = driver.findElement(By.xpath(
				"/html[@class=' js ']/body/div[@id='content']/section[@id='ng-app']/div[@id='all-content']/div[@id='resource-content']/div[@class='table-responsive']/table[@class='table table-bordered table-condensed table-hover']/tbody/tr[@class='ng-scope']/td[1]/a[@class='ng-binding']"));
		Wait.until(ExpectedConditions.visibilityOf(newEmp));
		newEmp.click();
	}

	public void NavToEmployeeClick() throws InterruptedException {
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/html[@class=' js ']/body/div[@id='content']/section[@id='ng-app']/div[@id='all-content']/div[@id='resource-content']/div[@class='table-responsive']/table[@class='table table-bordered table-condensed table-hover']/tbody/tr[@class='ng-scope'][1]/td[1]/a[@class='ng-binding']")));
		WebElement newEmp = driver.findElement(By.xpath(
				"/html[@class=' js ']/body/div[@id='content']/section[@id='ng-app']/div[@id='all-content']/div[@id='resource-content']/div[@class='table-responsive']/table[@class='table table-bordered table-condensed table-hover']/tbody/tr[@class='ng-scope'][1]/td[1]/a[@class='ng-binding']"));
		Wait.until(ExpectedConditions.visibilityOf(newEmp));
		newEmp.click();
	}
}
