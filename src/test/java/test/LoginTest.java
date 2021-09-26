package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utils.ExcelDataProvider;

@Listeners(listeners.TestNGListeners.class)
public class LoginTest extends BasePage {

	@Test(dataProvider="loginCredentials", dataProviderClass = ExcelDataProvider.class, priority=0)
	public static void loginWithUsernameAndPassword(String userName, String password) throws InterruptedException {
		LoginPage.loginWithUsernameAndPassword(driver, userName, password);
	}
	
	@Test(dataProvider="loginCredentials", dataProviderClass = ExcelDataProvider.class,priority=1)
	public static void loginErrorValidation(String userName, String password) throws InterruptedException {
		LoginPage.loginErrorValidation(driver, userName, password);
	}
	
}
