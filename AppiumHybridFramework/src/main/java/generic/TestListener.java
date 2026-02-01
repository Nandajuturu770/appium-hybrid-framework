package generic;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		attachScreenshot();
		ITestListener.super.onTestStart(result);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getName();
		TakesScreenshot ts = (TakesScreenshot)(BaseTest.driver);
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+methodName+" "+Calendar.getInstance().getTimeInMillis()+".png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {}
		try {
			Allure.addAttachment("Failed Screenshot", FileUtils.openInputStream(scr));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

	@Attachment(value = "Failure Screenshot", type = "image/png")
	public byte[] attachScreenshot() {
		return ((TakesScreenshot) BaseTest.driver)
				.getScreenshotAs(OutputType.BYTES);
	}
}