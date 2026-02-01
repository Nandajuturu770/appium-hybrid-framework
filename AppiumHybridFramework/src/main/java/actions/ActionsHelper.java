package actions;

import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;

public class ActionsHelper extends JavaScriptActions{

	private SoftAssert softAssert;

	public ActionsHelper(AndroidDriver driver) {
		super(driver);
		softAssert = new SoftAssert();
	}
	
	/**
	 * This method is used to call the assert all method.
	 */
	public void callAssertAll() {
		softAssert.assertAll();
	}

	/**
	 * @description this method is used to verify element is displayed or not.
	 * @param element <code>WebElement</code>
	 * @return result <code>boolean</code>
	 */
	public boolean isDisplayed(WebElement element) {
		try{
			element.isDisplayed();
			Allure.step(element +" is displayed.");
			return true;
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
		return false;
	}

	/**
	 * @description this method is used to check the element is presented or not.
	 * @param element <code>WebElement</code>
	 * @return result <code>boolean</code>
	 */
	public boolean checkElementIsPresented(WebElement element) {
		try{
			element.isDisplayed();
			Allure.step(element +" is displayed.");
			return true;
		}catch (Exception exception) {
			Allure.step(element +" is not displayed.");
			return false;
		}
	}

	/**
	 * @description this method is used to click on element.
	 * @param element <code>WebElement</code>
	 */
	public void click(WebElement element) {
		try{
			element.click();
			Allure.step(element+" is clicked.");
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
	}

	/**
	 * @description this method is used to double
	 * @param element <code>WebElement</code>
	 */
	public void doubleClick(WebElement element) {
		try{
			element.click();
			element.click();
			Allure.step(element+" is double clicked.");
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
	}

	/**
	 * @description this method is used to enter into element.
	 * @param element <code>Locator</code>
	 * @param input   <code>String</code>
	 */
	public void enter(WebElement element, String input) {
		try{
			element.sendKeys(input);
			Allure.step(input +" value is enter into "+element+" field.");
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
	}

	/**
	 * This method is used to clear the text field.
	 * @param element <code>WebElement</code>
	 */
	public void clear(WebElement element) {
		try{
			element.clear();
			Allure.step(element+" element is cleared.");
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
	}

	/**
	 * This method is used to wait till element is displayed with in given time.
	 * @param element <code>WebElement</code>
	 * @param seconds <code>int</code>
	 */
	public void waitTillElementIsDisplayed(WebElement element, int seconds) {
		do {
			Allure.step("sytem is waiting for the given "+element+"...");
			try{
				element.isDisplayed();
				Allure.step(element+" element is displayed.");
				break;
			}catch (Exception exception) {
				try {Thread.sleep(1000);}catch (Exception e) {}
				if(seconds == 0) {
					softAssert.fail(element+" element is displayed within given "+seconds+" seconds.");
				}
			}
			seconds--;
		}while(seconds>0);
	}

	/**
	 * This method is used to get text of element.
	 * @param element <code>WebElement</code?
	 * @return text   <code>String</code>
	 */
	public String getTextOfElement(WebElement element){
		String text = null;
		try{
			element.getText();
			Allure.step("text of "+element+" element is ' "+text+" '");
		}catch (Exception exception) {
			softAssert.fail(element+" element is not found, please check below :: \n"+exception.getMessage());
		}
		return text;
	}
}