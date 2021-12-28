package takeHomeProject.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import takeHomeProject.utils.ConfigsReader;
import takeHomeProject.utils.Constants;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * this method will create the driver and return it
	 * 
	 * @return WebDriver driver
	 */

	public static WebDriver setUp() { //start of setUp
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		if (ConfigsReader.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();

		} else if (ConfigsReader.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();

		}

		driver.get(ConfigsReader.getProperty("url")); // gets from properties file
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		PageInitializer.initialize(); //to initialize POM objects

		return driver;

	} //end of setUp

	/**
	 * this method will close the browser
	 */
	public static void tearDown() { //start of tearDown
		if (driver != null)
			driver.quit();
	} //end of tearDown
}
