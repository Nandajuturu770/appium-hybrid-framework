package generic;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class DriverManager {

	private static String androidAutomationName = "UiAutomator2";
	private static String iosAutomationName = "XCUITest";
	private static String androidPlatform = "Android";

	/**
	 * @description this method is used for create and get Android driver.
	 * @param deviceName     <code>String</code>
	 * @param appPackage     <code>String</code>
	 * @param appActivity    <code>String</code>
	 * @return androidDriver {@link AndroidDriver}
	 * @throws MalformedURLException
	 */
	public static AndroidDriver getAndroidDriver(String deviceName, String udid, String appPackage, String appActivity) {
		try {
			UiAutomator2Options capabilities = new UiAutomator2Options();
			capabilities.setAutomationName(androidAutomationName);
			capabilities.setPlatformName(androidPlatform);
			capabilities.setDeviceName(deviceName);
			capabilities.setUdid(udid);
			capabilities.setAppPackage(appPackage);
			capabilities.setAppActivity(appActivity);
			capabilities.setAutoGrantPermissions(true);
			capabilities.setAppWaitForLaunch(true);
			capabilities.setCapability("unicodeKeyboard", true);
			capabilities.setCapability("resetKeyboard", false);
			capabilities.setNoReset(false);
			Reporter.log("Automation engine is trying to lauching application with these capabilities :"+capabilities.toString() ,true);
			return new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);	
		}catch (Exception exception) {
			Assert.fail("System is failed lauching the application : ", exception);
		}
		return null;
	}

	/**
	 * @description this method is used for create and get IOS driver.
	 * @param deviceName <code>String</code>
	 * @param bundleId   <code>String</code>
	 * @return iosDriver {@link IOSDriver}
	 */
	public static IOSDriver getIOSDriver(String deviceName, String bundleId) {
		try {
			XCUITestOptions options = new XCUITestOptions();
			options.setAutomationName(iosAutomationName);
			options.setDeviceName(deviceName);
			options.setBundleId(bundleId);
			return new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
		}catch (Exception exception) {
			Assert.fail("System is failed lauching the application : ", exception);
		}
		return null;
	}
}