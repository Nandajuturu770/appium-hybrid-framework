package generic;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static enums.AppConfigPathEnum.*;

import java.io.IOException;

import utils.PropertiesReader;

public class BaseTest {

	public static WebDriver driver;
	public static String username;
	public static String password;
	String platformName;
	String environment;
	PropertiesReader propertiesReader;
	String appPackage;
	String appActivity;
	String deviceName;

	/**
	 * This methods is used for get configuration values from xml and property file.
	 * @param platformName
	 * @param environment
	 * @throws IOException 
	 */
	@Parameters({"platformName","environment"})
	@BeforeTest(alwaysRun = true)
	public void getConfig(@Optional("android") String platformName, @Optional("uat") String environment) throws IOException {
		this.platformName = platformName.toLowerCase();
		this.environment = environment.toLowerCase();
		Reporter.log("Execution environment : "+this.environment + " and platform : "+this.platformName , true);
		propertiesReader = new PropertiesReader(App_CONFIG_PATH.appConfigPathReader());
		appPackage = propertiesReader.getValueOfKey(environment+APP_PACKAGE.appConfigPathReader());
		appActivity = propertiesReader.getValueOfKey(environment+APP_ACTIVITY.appConfigPathReader());
		Reporter.log("appPackage : "+this.appPackage+ " and appActivity : "+this.appActivity , true);
		username = propertiesReader.getValueOfKey(environment+USER_NAME.appConfigPathReader());
		password = propertiesReader.getValueOfKey(environment+USER_PASSWORD.appConfigPathReader());
		Reporter.log("username : "+username+ " and password : "+password , true);
	}

	/**
	 * This method is used for set up the driver from DriverManager class based on platform name.
	 * @param platformVersion <code>String</code>
	 * @param deviceName      <code>String</code>
	 * @param udid            <code>String</code>
	 * @return appiumDriver   <code>String</code>
	 */
	@Parameters({"platformVersion", "deviceName", "udid"})
	@BeforeClass(alwaysRun = true)
	public WebDriver setup(@Optional("16")String platformVersion, @Optional("Real Device") String deviceName, @Optional("") String udid ){
		Reporter.log("System is trying to lauching the application");
		switch (platformName) {
		case "android":
			driver = DriverManager.getAndroidDriver(deviceName, udid, appPackage, appActivity);
			Reporter.log("After creating instance of android "+ driver , true);
			break;
		case "ios":
			driver =  DriverManager.getIOSDriver(deviceName, appPackage);
			break;
		default:
			org.testng.Assert.fail("System is failed to create instance of platform "+platformName);
		}
		return driver;
	}

	/**
	 * This method is used for tear down the driver.
	 */
	@AfterClass(alwaysRun = true)
	public void teardown() {
		Reporter.log("System is trying to tear down the driver "+ driver , true);
		if(driver != null)
			driver.quit();
	}
}