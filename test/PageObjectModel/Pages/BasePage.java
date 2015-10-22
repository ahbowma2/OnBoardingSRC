package test.PageObjectModel.Pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BasePage {

	/*
	 Create instance of webdriver
	 */
	public static WebDriver driver;

	/*
	 Create instance of a string to be assigned to a specific url
	 */

	public static String _baseUrl;

	/*
	 Create protected webdriver wait so that Wait may be called in all classes within the project
	 */

	protected WebDriverWait Wait = new WebDriverWait(driver, 20);

	/*
	 Assign the instance of the webdriver to different drivers depending on browser
	 */

	public static WebDriver GetFFDriver() {
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver GetGCDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\WebDrivers\\chromedriver.exe");
		driver = new ChromeDriver(DesiredCapabilities.chrome());
		return driver;
	}

	public static WebDriver GetIEDriver() {
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\WebDrivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		return driver;
	}

	/*
	 Take a screenshot and deposit it into the assigned file location
	 */

	public void Screenshot(String filename) throws Exception {
		try {
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File("c:\\Screenshots\\Java\\" + filename + ".png");
			FileUtils.copyFile(ScrFile, DestFile);
			Reporter.log("Screenshot for " + filename, true);

		} catch (Exception e) {
			System.err.println("Screenshot Failed");
			throw (e);
		}
	}
}
