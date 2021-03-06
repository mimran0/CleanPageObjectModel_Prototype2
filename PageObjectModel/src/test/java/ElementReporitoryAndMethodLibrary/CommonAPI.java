/**
 * 
 */
package ElementReporitoryAndMethodLibrary;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.annotations.BeforeMethod;

/**
 * @author md shahajada imran
 *
 */
public class CommonAPI {
	// method to wait a specific time
	public static void waitTime(int a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// method that checks if a string contains a numeric number
	public static boolean isContainNewMeric(String a) {
		boolean result = false;
		for (int i = 0; i <= a.length() - 1; i++) {
			char b = a.charAt(i);
			boolean isNM = Character.isDigit(b);
			// System.out.println(isNM);
			// System.out.println(b);
			if (isNM == true) {
				result = true;
				break;
			}
		}
		return result;
	}

	@BeforeMethod(enabled = false)
	public void doBeforeEveryMethod() {
		// CLOSING ALL OPEN BROWSERS before every method/(@test) executed
		WindowsUtils.killByName("chromedriver.exe");
		WindowsUtils.killByName("chrome.exe");
	}

	public int add(int a, int b) {
		int result;
		result = a + b;
		return result;
	}

	// OpenChromeBrowser (09/28/17)
	// This function/method will open GoogleChrome Browser and navigate to the
	// URL given during calling the method
	// Output: this function/method will return page title
	// Input: this function/method takes string URL of the page as input
	// argument
	WebDriver driver;

	public String OpenChromeBrowser(String url) {
		String result = null;
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		waitTime(5000);
		result = driver.getTitle();
		return result;
	}

	public WebDriver getDriver(String url) {
		WindowsUtils.killByName("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\imran\\workspace6\\FirstMavenProject\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}

	// Open Specific browser (Developed by md shahajada Imran on
	// 10/13/2017)(Anyone can
	// Re-use now or 40 years later for any client)
	// Getting webDriver and navigate the provided URL
	// Input: URL of the webpage, Browser Name.
	// Output: driver
	// Drawback: It opens few browsers. (This is the overloaded method to cover
	// more browsers)
	public WebDriver getDriver(String BrowserName, String url) {

		BrowserName = BrowserName.toUpperCase();
		switch (BrowserName) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\imran\\Workstation_POM1\\test\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\imran\\Workstation_POM1\\test\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "MICROSOFE EDGE":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\imran\\Workstation_POM1\\test\\driver\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
		case "IE":
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\imran\\Workstation_POM1\\test\\driver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
		}
		driver.get(url);
		return driver;
	}

	public static void ScrollDownAndUp(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		jse.executeScript("window.scrollBy(0,250)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,500)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,750)", "");
		waitTime(2000);
		jse.executeScript("window.scrollBy(0,1000)", "");
		// ScrollUp
		int j, m;
		j = 0;
		m = -250;
		while (j < 4) {
			// System.out.println(m);
			waitTime(2000);
			jse.executeScript("window.scrollBy(0," + m + ")", "");
			m = m - 250;
			j++;
		}
	}

	// Method overloading (Updated on 11/13/2017)
	public static void ScrollDownAndUp(WebDriver driver, int UpperBound) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		int count = UpperBound / 100;
		count = Math.round(count);
		int k;
		k = 100;
		for (int i = 0; i < count - 1; i++) {
			jse.executeScript("window.scrollBy(0," + k + ")", "");
			waitTime(2000);
			k = k + 100;
		}
		// ScrollUp
		int j, m;
		j = 0;
		m = -100;
		while (j < count) {
			// System.out.println(m);
			waitTime(2000);
			jse.executeScript("window.scrollBy(0," + m + ")", "");
			m = m - 100;
			j++;
		}
	}

	// Developed BY "MD SHAHAJADA IMRAN" on 11/23/17
	public static void scrolldown(WebDriver driver, int UpperBound) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		// ScrollDown
		int count = UpperBound / 100;
		count = Math.round(count);
		int k;
		k = 100;
		for (int i = 0; i < count; i++) {
			jse.executeScript("window.scrollBy(0," + k + ")", "");
			waitTime(2000);
			k = k + 50;
		}
	}

	// CAPTURESCREEN ((Developed by md shahajada Imran on 12/16/2017)(Anyone can
	// Re-use now or 40 years later for any client))
	// This function/method will capture screen shot of current page and save in
	// C:\\temp\\ folder.
	// Output: This function/method will not return anything. it will save a png
	// file in the mentioned location.
	// Input: WebDriver driver
	// drawback: Location where files will be saved is Hard coded.

	public static void CAPTURESCREEN(WebDriver driver) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (src.exists()) {
			System.out.println("src has value");
		}
		// System.out.println(src.exists());
		// now copy the screenshot to desired location using copyFile method
		try {
			// FileUtils.copyFile(src, new File("c:\\tmp\\screenshot" +
			// System.currentTimeMillis() + ".png"));
			FileUtils.copyFile(src, new File("C:\\Users\\imran\\workspace6\\FirstMavenProject\\ScreenShots\\screenshot"
					+ System.currentTimeMillis() + ".png"));
			System.out.println("Try block executed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method OverLoading (updated on 12/20/17)
	public static void CAPTURESCREEN(WebDriver driver, String Text) {
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		if (src.exists()) {
			System.out.println("src has value");
		}
		// System.out.println(src.exists());
		// now copy the screenshot to desired location using copyFile method
		try {
			// FileUtils.copyFile(src, new File("c:\\tmp\\screenshot" +
			// System.currentTimeMillis() + ".png"));
			FileUtils.copyFile(src, new File("C:\\Users\\imran\\workspace6\\FirstMavenProject\\ScreenShots\\" + Text
					+ System.currentTimeMillis() + ".png"));
			System.out.println("Try block executed");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// DeletAllFilesFromTheFolder ((Developed by Imran on 12/17/2017)(Anyone can
	// Re-use now
	// or 40 years later for any client)).
	// This method will delete all files from a given folder.
	// Output: This method will not return anything. it will delete all files
	// from a folder.
	// Input: String FolderPath. The path of the folder that contains all the
	// files.
	public static void DeletAllFilesFromTheFolder(String FolderPath) {
		// Set the path of the folder that contains all the files
		File file = new File(FolderPath);
		// Creating the list of files and store in the "files" variable.
		File[] files = file.listFiles();
		int len = files.length;
		if (len == 0) {
			System.out.println("The folder '" + FolderPath + "' is already empty. Therefore nothing to delete");
		}
		// System.out.println(len);
		// For each file in the folder, first print the name in the console then
		// delete it.
		int i = 0;
		for (File f : files) {
			if (i == 0) {
				System.out.println("Total " + len + " files have been deleted");
				System.out.println("Below is the list of files that have been deleted");
			}
			System.out.println(f.getName());
			f.delete();
			i++;
		}
	}

	// HighLight_Element ((Developed by md shahajada Imran on 04/02/2018)(Anyone
	// can
	// Re-use now or 40 years later for any client)).
	// This method will Highlight only one element.
	// Output: N/A
	// Input arguments: WebDriver driver, WebElement object

	public static void HighLight_Element(WebDriver driver, WebElement object) {
		// highlight only one element.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", object);
	}

	// HighLight_Elements ((Developed by md shahajada Imran on
	// 04/02/2018)(Anyone can
	// Re-use now or 40 years later for any client)).
	// This method will Highlight a list of elements.
	// Output: N/A
	// Input arguments: WebDriver driver, List<WebElement> objects
	public static void HighLight_Elements(WebDriver driver, List<WebElement> objects) {
		System.out.println(
				"There are total " + objects.size() + " elements in the list and those elements are written below.");
		for (WebElement v : objects) {
			System.out.println(v.getText());
			// highlight those elements
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].style.border='3px solid red'", v);

		}
	}

	// Method Overloading (04/04/2018)
	public static void HighLight_Element(WebDriver driver, By object) {
		// highlight only one element.
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].style.border='3px solid red'", object);
	}
}
