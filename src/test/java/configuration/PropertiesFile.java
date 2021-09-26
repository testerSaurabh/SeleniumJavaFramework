package configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import pages.BasePage;

public class PropertiesFile {
	public static Properties prop = new Properties();
	public static String projectPath = System.getProperty("user.dir");
	public static void getProperties() throws IOException {
		InputStream input = new FileInputStream(projectPath+"/src/test/java/configuration/config.properties");
		prop.load(input);
		String browser = prop.getProperty("browserName");
		BasePage.browserName = browser;
	}

	public static void getURL() throws IOException {
		InputStream input1 = new FileInputStream(projectPath+"/src/test/java/configuration/config.properties");
		prop.load(input1);
		String url = prop.getProperty("url");
		BasePage.url = url;
	}
}
