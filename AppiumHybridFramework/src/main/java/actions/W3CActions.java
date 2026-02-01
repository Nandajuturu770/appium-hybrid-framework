package actions;

import java.time.Duration;
import java.util.Arrays;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.Sequence;

import enums.Direction;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class W3CActions {

	private AppiumDriver driver;
	private int screenWidth;
	private int screenHeight;
	private Dimension dimension;
	private PointerInput finger;
	private Sequence actions;

	public W3CActions(AppiumDriver driver) {
		this.driver = driver;
		this.dimension = driver.manage().window().getSize();
		this.screenWidth = dimension.getWidth();
		this.screenHeight = dimension.getHeight();
	}

	/**
	 * This method is used for tap on the element.
	 * @param element {@link WebElement}
	 */
	public void tapOnElement(WebElement element) {
		Dimension dimension = element.getSize();
		int x = dimension.width/2;
		int y = dimension.height/2;
		finger = new PointerInput(PointerInput.Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger, Duration.ofMillis(50)))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used for tap on coordinates.
	 * @param x <code>int</code>
	 * @param y <code>int</code>
	 */
	public void tapOnCoordinates(int x, int y) {
		finger = new PointerInput(PointerInput.Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO,PointerInput.Origin.viewport(),x, y ))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger, Duration.ofMillis(50)))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used for long press on element.
	 * @param element {@link WebElement}
	 * @param seconds <code>int</code>
	 */
	public void longPressOnElement(WebElement element, int seconds) {
		Dimension dimension = element.getSize();
		int x = dimension.getWidth()/2;
		int y = dimension.getHeight()/2;
		finger = new PointerInput(Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x,y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger, Duration.ofSeconds(seconds)))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used for long press on coordinate.
	 * @param x    <code>int</code>
	 * @param y    <code>int</code>
	 * @param seconds <code>int</code>
	 */
	public void longPressOnCoordinates(int x, int y, int seconds) {
		finger = new PointerInput(Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(new Pause(finger, Duration.ofSeconds(seconds)))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used for swipe the screen up or down.
	 * @param direction    {@link Direction}
	 * @param swipePercentage <code>double</code>
	 */
	public void swipeUpOrDown(Direction direction, double swipePercentage) {
		int x = (int)screenWidth/2, startY, endY;
		switch (direction) {
		case UP:
			startY = (int)(screenHeight*0.75);
			endY = (int)(startY - screenHeight*swipePercentage);
			break;
		case DOWN:
			startY = (int)(screenHeight*0.25);
			endY = (int)(startY + screenHeight*swipePercentage);
			break;
		default:
			throw new IllegalArgumentException(direction + " is not matched...");
		}
		finger = new PointerInput(Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(finger.createPointerMove(Duration.ofMillis(2500), PointerInput.Origin.viewport(), x , endY))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used for swipe the screen right or left.
	 * @param direction    {@link WebElement}
	 * @param swipePercentage <code>int</code>
	 */
	public void swipeRightOrLeft(Direction direction, double swipePercentage) {
		int y = (int) screenHeight/2, startX, endX;
		switch (direction) {
		case LEFT:
			startX = (int)(screenWidth*0.8);
			endX = (int) (screenWidth * (1 - swipePercentage));
			break;
		case RIGHT:
			startX = (int)(screenWidth*0.2);
			endX = (int)(screenWidth*swipePercentage);
			break;
		default:
			throw new IllegalArgumentException(direction + " is not matched...");
		}
		finger = new PointerInput(Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(finger.createPointerMove(Duration.ofMillis(800),PointerInput.Origin.viewport(), endX, y))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used to swipe up or down till element.
	 * @param element   <code>WebElement</code>
	 * @param direction <code>Direction</code>
	 * @param maxSwipes <code>int</code>
	 */
	public void swipeUpOrDownTillElement(By by, Direction direction, int maxSwipes) {
		do {
			try {
				driver.findElement(by).isDisplayed();
				break;
			}catch (Exception exception) {
				swipeUpOrDown(direction, 1);
				maxSwipes--;
				if(maxSwipes == 0) {
					throw new RuntimeException(by + "element is not found. please check below details :: "+exception.getMessage());
				}
			}
		}while(maxSwipes>0);
	}
	
	/**
	 * This method is used to swipe element to top the screen.
	 * @param element <code>WebElement</code>
	 */
	public void swipeElementToTopOfScreen(WebElement element) {
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		int endY = (int) (screenHeight*0.2);
		finger = new PointerInput(Kind.MOUSE, "finger");
		actions = new Sequence(finger, 1);
		actions.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
		.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		.addAction(finger.createPointerMove(Duration.ofMillis(1500),PointerInput.Origin.viewport(), x, endY))
		.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Arrays.asList(actions));
	}

	/**
	 * This method is used to scroll to the element by resource id.
	 * @param resourceId <code>String</code>
	 */
	public void scrollToElementByResourceId(String resourceId) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))."
								+"scrollIntoView(new UiSelector().resourceId(\""+resourceId+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by class name.
	 * @param className <code>String</code>
	 */
	public void scrollToElementByClassName(String className) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))."
								+"scrollIntoView(new UiSelector().className(\""+className+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by text.
	 * @param text <code>String</code>
	 */
	public void scrollToElementByText(String text) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))."
								+"scrollIntoView(new UiSelector().text(\""+text+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by partial text.
	 * @param textContains <code>String</code>
	 */
	public void scrollToElementByTextContains(String textContains) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"
								+ ".scrollIntoView(new UiSelector().textContains(\""+textContains+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by text star with.
	 * @param textStartWith <code>String</code>
	 */
	public void scrollToElementByTextStartWith(String textStartWith) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"
								+ ".scrollIntoView(new UiSelector().textStartWith(\""+textStartWith+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by description.
	 * @param textStartWith <code>String</code>
	 */
	public void scrollToElementByDescription(String description) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"
								+".scrollIntoView(new UiSelector().description(\""+description+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by description contains.
	 * @param descriptionContains <code>String</code>
	 */
	public void scrollToElementByDescriptionContains(String descriptionContains) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"
								+".scrollIntoView(new UiSelectore().descriptionContains(\""+descriptionContains+"\"))"
						)
				);
	}

	/**
	 * This method is used to scroll to the element by description start with.
	 * @param descriptionStartWith
	 */
	public void scrollToElementByDesctiptionStartWith(String descriptionStartWith) {
		driver.findElement(
				AppiumBy.androidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"
								+".scrollIntoView(new UiSelector().descriptionStartWith(\""+descriptionStartWith+"\"))"
						)
				);
	}
	
	/**
	 * This method is click on back button of android device.
	 */
	public void navigateBack() {
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
