package repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import actions.ActionsHelper;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.Allure;

public class LoginScreen {

	ActionsHelper actionsHelper;
	
	public LoginScreen(AndroidDriver driver) {
		Allure.step("login screen intinialtion is starated...");
		actionsHelper = new ActionsHelper(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	//* 1.Login Screen
	private static final String smartStoreLogo_Img = "com.app.smartdigibook:id/imgLogo";
	private static final String loginYourAccount_Txt = "com.app.smartdigibook:id/txtLoginYourAccount";
	private static final String indianFlag_Img = "com.app.smartdigibook:id/imgCountry";
	private static final String indianCountryCode_Txt = "com.app.smartdigibook:id/textViewselectedCountry";
	private static final String mobileNumber_Txtfd = "com.app.smartdigibook:id/edtYourMobileNumber";
	private static final String securityCode_Txt = "com.app.smartdigibook:id/txtCodePin";
	private static final String securyPin_Lnk = "com.app.smartdigibook:id/txtForGotPin";
	private static final String password_TxtFd = "com.app.smartdigibook:id/pinViewCode";
	private static final String login_Btn = "com.app.smartdigibook:id/btnLogin";
	private static final String newUser_Txt = "com.app.smartdigibook:id/txtNewUser";
	private static final String createNewAccount_Btn = "com.app.smartdigibook:id/btnCreateYourAccount";
	private static final String howToCreateAccount_Lnk = "com.app.smartdigibook:id/txtCreateNewAccount";
	private static final String howToUse_Lnk = "com.app.smartdigibook:id/txtHowToUse";

	//* 2.Change Security Pin Screen
	private static final String securityPinChange_Img = "com.app.smartdigibook:id/viewBackground";
	private static final String securityPinChangeMain_Img = "com.app.smartdigibook:id/imgSlay";
	private static final String resetPin_Txt = "com.app.smartdigibook:id/txtForGotPin";
	private static final String pleaseEnterMobileNumber_Txt = "com.app.smartdigibook:id/txtPleaseEnterMobileNumber";
	private static final String getMobileNumber_TxtFd = "com.app.smartdigibook:id/txtPleaseEnterMobileNumber";
	private static final String sendVerificationCode_Btn = "com.app.smartdigibook:id/btnSendVerificationCode";

	//* 3.Create New Account Screen
	private static final String smartDigiBook_Logo = "com.app.smartdigibook:id/imgLogo";
	private static final String createYourAccount_Txt = "com.app.smartdigibook:id/txtCreateYourAccount";
	private static final String whenWeLearn_Txt = "com.app.smartdigibook:id/txtLoremIpsumDolor";
	private static final String smartDigiBookAnimation_Img = "com.app.smartdigibook:id/imgAnimation";
	private static final String firstName_TxtFd = "com.app.smartdigibook:id/edtFirstName";
	private static final String lastName_TxtFd = "com.app.smartdigibook:id/edtLastName";
	private static final String createAccountPassword_TxtFd = "com.app.smartdigibook:id/etPassword";
	private static final String useEnter6Digit_Txt = "com.app.smartdigibook:id/txtPasswordValidationLabel";
	private static final String emailAddress_TxtFd = "com.app.smartdigibook:id/edtEmailAddress";
	private static final String createAccountMobile_TxtFd = "com.app.smartdigibook:id/edtMobileNumber";
	private static final String state_Txt = "com.app.smartdigibook:id/txtState";
	private static final String state_Dropdown = "com.app.smartdigibook:id/ImgVwStartSearch";
	private static final String city_Txt = "com.app.smartdigibook:id/txtCity";
	private static final String city_Dropdown = "//android.widget.TextView[@text= 'Select City']/..//following-sibling::android.widget.FrameLayout";
	private static final String privacyPolicy_Txt = "com.app.smartdigibook:id/chkPrivacyPolicy";
	private static final String continue_Btn = "com.app.smartdigibook:id/btnContinue";
	private static final String accountSignIn_Txt = "com.app.smartdigibook:id/txtAlreadyAccountSignIn";
	private static final String smartDigiBook_Icon = "com.app.smartdigibook:id/imgLogo";

	//* WebElement declarations using variables
	@AndroidFindBy(id = smartStoreLogo_Img)
	private WebElement smartStoreLogoImg;

	@AndroidFindBy(id = loginYourAccount_Txt)
	private WebElement loginYourAccountTxt;

	@AndroidFindBy(id = indianFlag_Img)
	private WebElement indianFlagImg;

	@AndroidFindBy(id = indianCountryCode_Txt)
	private WebElement indianCountryCodeTxt;

	@AndroidFindBy(id = mobileNumber_Txtfd)
	private WebElement mobileNumberTxtfd;

	@AndroidFindBy(id = securityCode_Txt)
	private WebElement securityCodeTxt;

	@AndroidFindBy(id = securyPin_Lnk)
	private WebElement securyPinLnk;

	@AndroidFindBy(id = password_TxtFd)
	private WebElement passwordTxtFd;

	@AndroidFindBy(id = login_Btn)
	private WebElement loginBtn;

	@AndroidFindBy(id = newUser_Txt)
	private WebElement newUserTxt;

	@AndroidFindBy(id = createNewAccount_Btn)
	private WebElement createNewAccountBtn;

	@AndroidFindBy(id = howToCreateAccount_Lnk)
	private WebElement howToCreateAccountLnk;

	@AndroidFindBy(id = howToUse_Lnk)
	private WebElement howToUseLnk;

	@AndroidFindBy(id = securityPinChange_Img)
	private WebElement securityPinChangeImg;

	@AndroidFindBy(id = securityPinChangeMain_Img)
	private WebElement securityPinChangeMainImg;

	@AndroidFindBy(id = resetPin_Txt)
	private WebElement resetPinTxt;

	@AndroidFindBy(id = pleaseEnterMobileNumber_Txt)
	private WebElement pleaseEnterMobileNumberTxt;

	@AndroidFindBy(id = getMobileNumber_TxtFd)
	private WebElement mobileNumberTxtFd;

	@AndroidFindBy(id = sendVerificationCode_Btn)
	private WebElement sendVerificationCodeBtn;

	@AndroidFindBy(id = smartDigiBook_Logo)
	private WebElement smartDigiBookLogo;

	@AndroidFindBy(id = createYourAccount_Txt)
	private WebElement createYourAccountTxt;

	@AndroidFindBy(id = whenWeLearn_Txt)
	private WebElement whenWeLearnTxt;

	@AndroidFindBy(id = smartDigiBookAnimation_Img)
	private WebElement smartDigiBookAnimationImg;

	@AndroidFindBy(id = firstName_TxtFd)
	private WebElement firstNameTxtFd;

	@AndroidFindBy(id = lastName_TxtFd)
	private WebElement lastNameTxtFd;

	@AndroidFindBy(id = createAccountPassword_TxtFd)
	private WebElement createAccountPasswordTxtFd;

	@AndroidFindBy(id = useEnter6Digit_Txt)
	private WebElement useEnter6DigitTxt;

	@AndroidFindBy(id = emailAddress_TxtFd)
	private WebElement emailAddressTxtFd;

	@AndroidFindBy(id = createAccountMobile_TxtFd)
	private WebElement createAccountMobileTxtFd;

	@AndroidFindBy(id = state_Txt)
	private WebElement stateTxt;

	@AndroidFindBy(id = state_Dropdown)
	private WebElement stateDropdown;

	@AndroidFindBy(id = city_Txt)
	private WebElement cityTxt;

	@AndroidFindBy(xpath = city_Dropdown)
	private WebElement cityDropdown;

	@AndroidFindBy(id = privacyPolicy_Txt)
	private WebElement privacyPolicyTxt;

	@AndroidFindBy(id = continue_Btn)
	private WebElement continueBtn;

	@AndroidFindBy(id = accountSignIn_Txt)
	private WebElement accountSignInTxt;
	
	@AndroidFindBy(id = smartDigiBook_Icon)
	private WebElement smartDigiBookIcon;

	/**
	 * This method is used to verify user is able to see the element or components of login screen.
	 */
	public void verifyLoginScreen() {
		actionsHelper.waitTillElementIsDisplayed(mobileNumberTxtfd, 30);
		actionsHelper.isDisplayed(loginYourAccountTxt);
		actionsHelper.isDisplayed(indianFlagImg);
		actionsHelper.isDisplayed(indianCountryCodeTxt);
		actionsHelper.isDisplayed(mobileNumberTxtfd);
		actionsHelper.isDisplayed(securityCodeTxt);
		actionsHelper.isDisplayed(passwordTxtFd);
		actionsHelper.isDisplayed(loginBtn);
	}

	/**
	 * This method is used to login to application.
	 * @param username <code>String</code>
	 * @param password <code>String</code>
	 */
	public void loginIntoApplication(String username, String password) {
		actionsHelper.waitTillElementIsDisplayed(mobileNumberTxtfd, 30);
		actionsHelper.enter(mobileNumberTxtfd, username);
		actionsHelper.enter(passwordTxtFd, password);
		actionsHelper.click(loginBtn);
		actionsHelper.waitTillElementIsDisplayed(smartDigiBookIcon, 30);
	}
	
	/**
	 * This method is used to call the assert all method.
	 */
	public void callAssertAll() {
		actionsHelper.callAssertAll();
	}
}