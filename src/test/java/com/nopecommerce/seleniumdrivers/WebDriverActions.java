package com.nopecommerce.seleniumdrivers;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import com.nopecommerce.scripts.*;
import com.nopecommerce.listeners.TestNGListener;

public class WebDriverActions extends TestNGListener {

	/**
	 * to refresh the browser
	 */
	public static void refresh() {
		BaseTest.getDriver().navigate().refresh();
	}

	/**
	 * to switch to window by title of page
	 * 
	 * @param title
	 */
	public static void SwitchingMultipleWindowByTitle(String title) {
		Set<String> windows = BaseTest.getDriver().getWindowHandles();
		for (String window : windows) {
			BaseTest.getDriver().switchTo().window(window);
			if (BaseTest.getDriver().getTitle().contains(title))
				break;
		}
	}

	/**
	 * to switch to window by url of page
	 * 
	 * @param url
	 */
	public static void SwitchingMutlpleWindowsByURL(String url) {
		Set<String> windows = BaseTest.getDriver().getWindowHandles();
		for (String window : windows) {
			BaseTest.getDriver().switchTo().window(window);
			if (BaseTest.getDriver().getCurrentUrl().contains(url))
				break;
		}
	}

	/**
	 * to handle web alers
	 * 
	 * @param value
	 * @param status
	 */
	public static void handleAlerts(String value, String status) {
		if (value.isEmpty() && status.equalsIgnoreCase("accept")) {
			BaseTest.getDriver().switchTo().alert().accept();
		} else if (value.isEmpty() && status.equalsIgnoreCase("dismiss")) {
			BaseTest.getDriver().switchTo().alert().dismiss();
		} else {
			BaseTest.getDriver().switchTo().alert().sendKeys(value);
			BaseTest.getDriver().switchTo().alert().accept();
		}
	}

	/**
	 * to wait for page load
	 */
	public static void pageRoadTimeOut() {
		BaseTest.getDriver().manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	public static void switchToFrameByElement(WebElement element) {
		BaseTest.getDriver().switchTo().frame(element);
	}
	
	public static void switchTodefaultConent() {
		BaseTest.getDriver().switchTo().defaultContent();
	}
}
