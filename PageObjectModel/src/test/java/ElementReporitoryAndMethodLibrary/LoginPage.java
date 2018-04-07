package ElementReporitoryAndMethodLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @author md shahajada imran
 *
 */
public class LoginPage extends CommonAPI {
	// elements are created below
	@FindBy(how = How.ID, using = "login-username")
	private WebElement obj_UserName;
	@FindBy(how = How.NAME, using = "signin")
	private WebElement obj_NextButton;

	// Reusable Methods are created below
	public WebElement obj_UserName() {
		return obj_UserName;
	}

	public WebElement obj_NextButton() {
		return obj_NextButton;
	}

	public void ActivateAllObjectsAndMethodsOfThisPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebDriver TemporaryMethod() {
		WindowsUtils.killByName("chromedriver.exe");
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);
		PageFactory.initElements(driver, this);
		// HighLight_Element(driver, obj_UserName);
		// HighLight_Element(driver, obj_NextButton);
		obj_UserName.sendKeys("mdshahajadaimran");
		waitTime(3000);
		obj_NextButton.click();
		return driver;
	}

	// Temporary method is used to check if created elements get highlighted or
	// not.
	@Test(enabled = true)
	public void TemporaryMethod2() {
		WindowsUtils.killByName("chromedriver.exe");
		String vBaseURL = "https://login.aol.com/";
		String wBrowser = "CHROME";
		CommonAPI CommonAPI = new CommonAPI();
		WebDriver driver = CommonAPI.getDriver(wBrowser, vBaseURL);
		waitTime(10000);
		PageFactory.initElements(driver, this);
		// WebElement object = driver.findElement(By.id("login-username"));
		HighLight_Element(driver, obj_UserName);
		HighLight_Element(driver, obj_NextButton);
	}
}
