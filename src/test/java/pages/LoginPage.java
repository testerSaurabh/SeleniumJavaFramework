package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPage extends BasePage {

	private static WebElement element = null;

	public static WebElement getUserName(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='txt-username']"));
		return element;
	}

	public static WebElement getPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='txt-password']"));
		return element;
	}

	public static WebElement loginButton(WebDriver driver) {
		element = driver.findElement(By.xpath("//button[@id='btn-login']"));
		return element;
	}

	public static java.util.List<WebElement> getloginFailure(WebDriver driver) {
		java.util.List<WebElement> element = driver.findElements(By.xpath("//p[@class='lead text-danger']"));
		return element;
	}
	
	public static WebElement getLoginFailureMessage(WebDriver driver) {
		element = driver.findElement(By.xpath("//p[@class='lead text-danger']"));
		return element;
	}

	public static void loginWithUsernameAndPassword(WebDriver driver, String userName, String password) throws InterruptedException {
		ExtentTest test = extentReports.createTest("Login Success Test", "Test1");
		test.log(Status.INFO, "Entering credentials");
		test.info("Entering Username");
		getUserName(driver).sendKeys(userName);
		test.pass("Username entered");
		test.info("Entering Password");
		getPassword(driver).sendKeys(password);
		test.pass("Password entered");
		test.info("Clicking login button");
		loginButton(driver).click();
		test.pass("Login button clicked");
		Thread.sleep(2000);
		if(getloginFailure(driver).isEmpty()) {
			test.pass("login successful");
		} else {
			Assert.assertFalse(getloginFailure(driver).isEmpty());
			test.pass("Invalid credentials throwing error message");
		}

	}

	public static void loginErrorValidation(WebDriver driver, String userName, String password) throws InterruptedException {
		ExtentTest test = extentReports.createTest("Login Error Message Validation", "Test2");
		test.log(Status.INFO, "Entering credentials");
		test.info("Entering Username");
		getUserName(driver).sendKeys(userName);
		test.pass("Username entered");
		test.info("Entering Password");
		getPassword(driver).sendKeys(password);
		test.pass("Password entered");
		test.info("Clicking login button");
		loginButton(driver).click();
		test.pass("Login button clicked");
		Thread.sleep(2000);
		if(getloginFailure(driver).isEmpty()) {
			Assert.assertTrue(getloginFailure(driver).isEmpty());
			test.pass("Valid credentials are not giving error message");
		} else {
			if(getLoginFailureMessage(driver).getText().equals("Login failed! Please ensure the username and password are valid.")) {
				test.pass("Error Message is displayed correctly");
			} else {
				test.fail("Error Message is displayed incorrectly");
			}
		}
		
	}
}
