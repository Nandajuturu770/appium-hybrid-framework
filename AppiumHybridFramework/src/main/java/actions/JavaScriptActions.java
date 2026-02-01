package actions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import enums.Direction;
import io.appium.java_client.android.AndroidDriver;

public class JavaScriptActions extends W3CActions{

	AndroidDriver driver;
	JavascriptExecutor jse;
	int width;
	int height;

	public JavaScriptActions(AndroidDriver driver){
		super(driver);
		this.driver = driver;
		jse = (JavascriptExecutor)driver;
		width = driver.manage().window().getSize().getWidth();
		height= driver.manage().window().getSize().getHeight();
	}

	/**
	 * This method is used for tap on the element.
	 * @param element {@link WebElement}
	 */
	public void tapOnElement(WebElement element) {
		// Gesture - mobile: tapGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		jse.executeScript("mobile: clickGesture", Map.of(
				"elementId", params));
	}

	/**
	 * This method is used for tap on given coordinates.
	 * @param x <code>int</code>
	 * @param y <code>int</code>
	 */
	public void tapOnCoordinates(int x, int y) {
		// Gesture - mobile: tapGesture
		java.util.Map<String, Object> params = new HashMap<String, Object>();
		params.put("x", x);
		params.put("y", y);
		jse.executeScript("mobile: clickGesture", params);
	}

	/**
	 * This method is used for long press on element.
	 * @param element {@link WebElement}
	 */
	public void longPressOnElement(WebElement element) {
		// Gesture - mobile: longPressGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		params.put("duration", 2000);
		jse.executeScript("mobile: longPressGesture", params);
	}

	/**
	 * This method is used for long press on element until time.
	 * @param element {@link WebElement}
	 * @param seconds <code>int</code>
	 */
	public void longPressOnElementUntilTime(WebElement element, int seconds) {
		// Gesture - mobile: longPressGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		params.put("duration", seconds*1000);
		jse.executeScript("mobile: longPressGesture", params);
	}

	/**
	 * This method is used for long press on given coordinates.
	 * @param x <code>int</code>
	 * @param y <code>int</code>
	 */
	public void longPressOnCoordinates(int x, int y) {
		// Gesture - mobile: longPressGesture
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("x", x);
		params.put("y", y);
		params.put("duration", 2000);
		jse.executeScript("mobile : longPressGesture", params);
	}

	/**
	 * This method is used for double click on element.
	 * @param element {@link WebElement}
	 */
	public void doubleClickOnElement(WebElement element) {
		// Gesture - mobile: doubleClickGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		jse.executeScript("mobile: doubleClickGesture", params);
	}

	/**
	 * This method is used for double on coordinates.
	 * @param x <code>int</code>
	 * @param y <code>int</code>
	 */
	public void doubleClickOnCoordinates(int x, int y) {
		// Gesture - mobile: doubleClickGesture
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("x", x);
		params.put("y", y);
		jse.executeScript("mobile: doubleClickGesture", params);
	}

	/**
	 * This method is used for swipe on element.
	 * @param element   {@link WebElement}
	 * @param direction {@link Direction}
	 */
	public void swipeOnElement(WebElement element, Direction direction) {
		// Gesture- mobile: swipeGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		switch (direction) {
		case UP:
			params.put("direction", Direction.UP.getDirectionValue());
			break;
		case DOWN:
			params.put("direction", Direction.DOWN.getDirectionValue());
			break;
		case LEFT:
			params.put("direction", Direction.LEFT.getDirectionValue());
			break;
		case RIGHT:
			params.put("direction", Direction.RIGHT.getDirectionValue());
			break;
		default:
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}
		params.put("percent", 0.75);
		jse.executeScript("mobile: swipeGesture", params);
	}

	/**
	 * This method is used for swipe by coordinates.
	 * @param direction {@link Direction}
	 * @param percent   <code>double</code>
	 */
	public void swipeByCoordinates(Direction direction, double percent) {
		// Gesture - mobiel: swipeGesture
		Map<String , Object> params = new HashMap<String, Object>();
		params.put("left", 0);
		params.put("top", 0);
		params.put("width", width);
		params.put("height", height);
		switch (direction) {
		case UP:
			params.put("direction", Direction.UP.getDirectionValue());
			break;
		case DOWN:
			params.put("direction", Direction.DOWN.getDirectionValue());
			break;
		case LEFT:
			params.put("direction", Direction.LEFT.getDirectionValue());
			break;
		case RIGHT:
			params.put("direction", Direction.RIGHT.getDirectionValue());
			break;
		default:
			throw new IllegalArgumentException("Invalid direction: " + direction);
		}
		params.put("percent", percent);
		jse.executeScript("mobile: swipeGesture", params);	
	}

	/**
	 * This method is used for swipe screen until element is visible.
	 * @param element   {@link WebElement}
	 * @param direction {@link Direction}
	 * @param percent   <code>int</code>
	 * @param maxSwipes <code>int</code>
	 */
	public void swipeUntilElementIsVisible(WebElement element, Direction direction, double percent, int maxSwipes) {
		// Gesture - mobile : scrollGesture
		Map<String, Object> params = new HashMap<>();
		params.put("left", 0);
		params.put("top", 0);
		params.put("width", driver.manage().window().getSize().width);
		params.put("height", driver.manage().window().getSize().height);
		params.put("direction", direction.getDirectionValue());
		params.put("percent", percent);
		do {
			try {
				element.isDisplayed();
				break;
			} catch (Exception ignore) {
				jse.executeScript("mobile: scrollGesture", params);
				maxSwipes--;
				if(maxSwipes < 1)
					throw new IllegalArgumentException("Element is not found, pelase check here " + ignore.getMessage());
			}
		}while(maxSwipes>1);	
	}

	/**
	 * This method is used for drag elemnt to another element.
	 * @param source {@link WebElement}
	 * @param target {@link WebElement}
	 */
	public void dragElementToElement(WebElement source, WebElement target) {
		// Gesture - mobile : dragGesture
		String elementId = ((RemoteWebElement)source).getId();
		String endElementId = ((RemoteWebElement)target).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		params.put("endElementId", endElementId);
		jse.executeScript("mobile: dragGesture", params);
	}

	/**
	 * This method is used for drag elemnt to the point.
	 * @param element {@link WebElement}
	 * @param x       <code>int</code>
	 * @param y       <code>int</code>
	 */
	public void dragElementToPoint(WebElement element, int x, int y) {
		// Gesture - mobile: dragGesture
		String elementId = ((RemoteWebElement)element).getId();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("elementId", elementId);
		param.put("endX", x);
		param.put("endY", y);
		param.put("speed", 1000);
		jse.executeScript("mobile: dragGesture", param);
	}

	/**
	 * This method is used for drop element to target element.
	 * @param source {@link WebElement}
	 * @param target {@link WebElement}
	 */
	public void dropElementToTarget(WebElement source, WebElement target) {
		// Gesture - mobile: dropGesture
		String elementId = ((RemoteWebElement)source).getId();
		String endElementId = ((RemoteWebElement)target).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		params.put("endElementId", endElementId);
		params.put("speed", 1000);
		jse.executeScript("mobile: dropGesture", params);
	}

	/**
	 * This method is used for drop the element at points.
	 * @param source {@link WebElement}
	 * @param x      <code>int</code>
	 * @param y      <code>int</code>
	 */
	public void dropElementAtPoints(WebElement source, int x, int y) {
		// Gesture - mobile: dropGesture
		String elementId = ((RemoteWebElement)source).getId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("elementId", elementId);
		params.put("endX", x);
		params.put("endY", y);
		params.put("speed", 1000);
		jse.executeScript("mobile: dropGesture", params);
	}
}