package takeHomeProject.utils;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;

import takeHomeProject.testbase.PageInitializer;

public class CommonMethods extends PageInitializer {



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
	 * Checks if links are working
	 * 
	 * @param URL
	 * @return Prints link + status code + response message
	 */

	public static void checkAllLinks(String URL) {
		try {
			URL url = new URL(URL);

			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(6000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(URL + " --- " + httpURLConnect.getResponseMessage() + " with code: "
						+ httpURLConnect.getResponseCode() + " is a broken link");

			}

			else {
				System.out.println(URL + " --- " + httpURLConnect.getResponseMessage() + " with code: "
						+ httpURLConnect.getResponseCode());
			}
		} catch (Exception e) {
		}
	}

	/**
	 * @return prints console errors if any
	 */

	public static void checkConsole() {
		LogEntries logEntries = driver.manage().logs().get("browser");

		for (LogEntry entry : logEntries) {
			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			String errorLogType = entry.getLevel().toString();
			String errorLog = entry.getMessage().toString();
			if (errorLog.contains("404")) {
				System.out.println("Error LogType: " + errorLogType + " Error Log message: " + errorLog);
			}
		}
	}

}
