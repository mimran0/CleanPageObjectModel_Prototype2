/**
 * 
 */
package ElementReporitoryAndMethodLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

/**
 * @author md shahajada imran
 *
 */
public class LoginPasswordPage extends CommonAPI {
	// Objects are created below..
	@FindBy(how = How.ID, using = "login-passwd")
	private WebElement obj_Password;
	@FindBy(how = How.TAG_NAME, using = "button")
	private WebElement obj_SignInButton;

	// Reusable Methods/Functions are created below..
	public WebElement obj_Password() {
		return obj_Password;
	}

	public WebElement obj_SignInButton() {
		return obj_SignInButton;
	}

	public void ActivateAllObjectsAndMethodsOfThisPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Temporary Method will be deleted once Framework is Up and Running.
	public WebDriver TemporaryMethod_LoginPasswordPage() {
		LoginPage LoginPage = new LoginPage();
		WebDriver driver = LoginPage.TemporaryMethod();
		PageFactory.initElements(driver, this);
		waitTime(5000);
		// HighLight_Element(driver, obj_Password);
		// HighLight_Element(driver, obj_SignInButton);
		waitTime(3000);
		obj_Password.sendKeys("selenium54321");
		waitTime(2000);
		obj_SignInButton.click();
		return driver;

	}

	// Temporary method is used to check if created elements get highlighted or
	// not.
	@Test(enabled = true)
	public void TemporaryMethod_LoginPasswordPage2() {
		LoginPage LoginPage = new LoginPage();
		WebDriver driver = LoginPage.TemporaryMethod();
		PageFactory.initElements(driver, this);
		waitTime(5000);
		HighLight_Element(driver, obj_Password);
		HighLight_Element(driver, obj_SignInButton);

	}
}
