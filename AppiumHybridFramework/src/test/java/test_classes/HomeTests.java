package test_classes;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generic.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import repository.HomeScreen;
import repository.LoginScreen;


@Listeners(generic.TestListener.class)
public class HomeTests extends BaseTest {

	private AndroidDriver driver;
	private LoginScreen loginScreen;
	private String username;
	private String password;
	private HomeScreen homeScreen;
	
	@BeforeClass(alwaysRun = true)
	public void initialization() throws IOException {
		this.driver = (AndroidDriver) BaseTest.driver;
		this.username = BaseTest.username;
		this.password = BaseTest.password;
		loginScreen = new LoginScreen(this.driver);
		homeScreen = new HomeScreen(this.driver);
		loginScreen.loginIntoApplication("8147740413", "111111");
	}

	@Test(priority = 0,description = "Verify user is able to see all recent activities in recent activity view all.")
	public void lauchingApplication() {
		Reporter.log("launing the apploication", true);
		homeScreen.verifyHeader();
		homeScreen.verifyMyLibrarySection();
		homeScreen.VerifyRecentActivities();
		homeScreen.verifyRecentActivitiesViewAll();
		homeScreen.verifyTheSmartStore();
	}
}
