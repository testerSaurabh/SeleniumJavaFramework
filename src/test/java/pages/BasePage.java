package pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.*;

import configuration.PropertiesFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	protected static WebDriver driver = null;
	protected static ExtentSparkReporter extentHtmlReporter;
	protected static ExtentReports extentReports;
	public static String browserName = null;
	public static String url = null;

	@BeforeSuite
	public void setUpTest() {
		extentHtmlReporter = new ExtentSparkReporter("extent.html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);
	}

	@BeforeMethod
	public void beforeTest() throws IOException {
		PropertiesFile.getProperties();
		PropertiesFile.getURL();
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

	@AfterSuite 
	public void tearDown() 
	{ 
		extentReports.flush();
	}

}
