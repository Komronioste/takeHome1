package takeHomeProject.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import takeHomeProject.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {

	/**
	 * This method clears a textbox and sends the new text to it.
	 * 
	 * @param element
	 * @param text
	 */

	public static void sendText(WebElement element, String text) {

		element.clear();
		element.sendKeys(text);

	}

	/**
	 * This method checks if radio/checkbox is enabled and then clicks on the
	 * element that has the value we want.
	 * 
	 * @param listElement
	 * @param value
	 */

	public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
		String actualValue;

		for (WebElement el : listElement) {
			actualValue = el.getAttribute("value").trim();
			if (el.isEnabled() && actualValue.equals(value)) {
				el.click();
				break;
			}
		}

	}

	/**
	 * This method puts the thread to sleep and handles the exception for us. Takes
	 * seconds as argument.
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method will check if a desired text is found in the dropdown and only
	 * then select it.
	 * 
	 * @param element
	 * @param textToSelect
	 */

	public static void selectDropDown(WebElement element, String textToSelect)

	{
		try {

			Select select = new Select(element);
			List<WebElement> options = select.getOptions();

			for (WebElement el : options) {
				if (el.getText().equalsIgnoreCase(textToSelect)) {
					select.selectByVisibleText(textToSelect);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will check if an index exists in the dropdown and only then
	 * select it.
	 * 
	 * @param element
	 * @param index
	 */

	public static void selectDropdown(WebElement element, int index) {

		try {

			Select select = new Select(element);
			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}

		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method accepts the alert and will catch the exception if no alert is
	 * present
	 */

	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will dismiss the alert and will catch the exception if no alert
	 * is preset
	 */

	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns text of the active alert if no alert is present, we will
	 * catch an exception and return null.
	 * 
	 * @return text of alert
	 */

	public static String getAlertText() {
		String text = null;
		try {

			Alert alert = driver.switchTo().alert();
			text = alert.getText();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return text;
	}

	/**
	 * Sends text to alert if one present if no alert, then handled by an exception
	 * 
	 * @param text
	 */

	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to a frame using name or id. It will also handle
	 * NoSuchFrameException.
	 * 
	 * @param nameOrId
	 */

	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to frame using index. It will also handle
	 * NoSuchElementException.
	 * 
	 * @param index
	 */

	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will switch to frame using WebElement. It will also handle
	 * NoSuchElementException.
	 * 
	 * @param element
	 */

	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);

		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method creates a WebDriverWait object and returns it.
	 * 
	 * @return WebDriverWait object.
	 */

	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);

		return wait;

	}

	/**
	 * This method will implement and explicit wait on an element and wait for
	 * element's clickability
	 * 
	 * @param element
	 * @return
	 */

	public static WebElement waitForClickability(WebElement element) {

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method will implement and explicit wait on an element and wait for
	 * element's visibility
	 * 
	 * @param element
	 * @return
	 */

	public static WebElement waitForVisibility(WebElement element) {
		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * Will take a screenshot and save with provided name in /screenshots/ folder
	 * 
	 * @param String fileName
	 */

	public static void takeSS(String fileName) {
		TakesScreenshot ts1 = (TakesScreenshot) driver;
		try {
			FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE), new File("screenshots/" + fileName + ".png"));
		} catch (WebDriverException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}
	
	/**
	 * This method takes a screenshot and saves it with the provided filename.
	 * 
	 * @param filename
	 */
//	public static String takeScreenshot(String filename) {    //for TESTNG **************************
//
//		TakesScreenshot ts = (TakesScreenshot) driver;
//
//		File source = ts.getScreenshotAs(OutputType.FILE);
//
//		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";
//
//		try {
//			FileUtils.copyFile(source, new File(destination));
//		} catch (IOException e) {
//			System.out.println("Cannot take screenshot");
//			e.printStackTrace();
//		}
//
//		return destination;
//	}
	
	public static byte[] takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Cannot take screenshot");
			e.printStackTrace();
		}

		return picBytes;
	}
	
	
	

	/**
	 * This method return the current time stamp in a String
	 * 
	 * @return time_stamp
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}
	

	/**
	 * This method casts driver to Javascript executor and returns it
	 * 
	 * @return JavascriptExecutor
	 */

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}

	/**
	 * This method will click to the element that is passed using JavascriptExecutor
	 * 
	 * @param element
	 */

	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click()", element);
	}

	/**
	 * This method will scroll page until the element that is passed becomes visible
	 * 
	 * @param element
	 */

	public static void sctollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method will scroll the page down based on the passed pixel parameter
	 * 
	 * @param int pixel
	 */

	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll the page up based on the passed pixel parameter
	 * 
	 * @param pixel
	 */

	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * Scrolls to a location of a WebElement
	 * 
	 * @param WebElement element
	 */

	public static void scrollTo(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}

	/**
	 * This method clicks on provided element but uses waitForVisibility before
	 * clicking
	 * 
	 * @param element
	 */

	public static void click(WebElement element) {
		waitForVisibility(element);
		element.click();
	}

	/**
	 * This method will select a date from calendar
	 * 
	 * @param Set    <WebElements>
	 * @param String date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {

				if (day.getText().equals(date)) {
					day.click();
					break;
				}
			}
		}
	}

}
