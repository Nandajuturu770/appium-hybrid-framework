package test_classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;

import generic.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import repository.LoginScreen;

@Listeners(generic.TestListener.class)
public class LoginTests extends BaseTest {
	private AndroidDriver driver;
	private LoginScreen loginScreen;
	private String username;
	private String password;
	
	@BeforeClass(alwaysRun = true)
	public void initialization() throws IOException {
		this.driver = (AndroidDriver) BaseTest.driver;
		this.username = BaseTest.username;
		this.password = BaseTest.password;
		loginScreen = new LoginScreen(driver);
	}

	@Test(priority = 0,description = "Verify user is able to login into appliation with valid creadentials")
	public void lauchingApplication() {
		Reporter.log("launing the apploication", true);
		loginScreen.verifyLoginScreen();
		loginScreen.loginIntoApplication(username, password);
		loginScreen.callAssertAll();
	}
}
