package com.nopecommerce.seleniumdrivers;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com.nopecommerce.listeners.TestNGListener;
import com.nopecommerce.scripts.BaseTest;
import com.nopecommerce.utils.Log4J;
public class WebElementActions extends TestNGListener{
	
	/**
	 * to pass input to text box or text area
	 * 
	 * @param element
	 * @param input
	 * @param message
	 * @throws Exception
	 */
	public static void enterInputIntoTextField(WebElement element, String input, String msg) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.sendKeys(input);
				Log4J.info(msg);
				test.log(Status.PASS, msg+ " passed");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			Log4J.error(msg);
			test.log(Status.FAIL, msg+ " failed");
		}
	}

	/**
	 * to click on a element
	 * 
	 * @param element
	 * @param msg
	 * @throws Exception
	 */
	public static void clickOnElement(WebElement element, String msg) {
		try {
			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
				Log4J.info(msg);
				test.log(Status.PASS, msg+ " passed");
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			Log4J.error(msg);
			test.log(Status.FAIL, msg+ " failed");
		}
	}

	public static void selectDropDownValue(WebElement element, String value, String msg) throws Exception {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
			WebElement Element = select.getFirstSelectedOption();
			Assert.assertEquals(Element.getText(), value);
			Log4J.info(msg);
			test.log(Status.PASS, msg+ " passed");
		} catch (Exception e) {
			Log4J.error(msg);
			test.log(Status.FAIL, msg+ " failed");
		}
	}

	/**
	 * to click on element by javascript executor
	 * 
	 * @Param msg
	 * @param element
	 */
	public static void clickByJavaScript(WebElement element, String msg) {
		try {
		JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
		js.executeScript("arguments[0].click();", element);
		Log4J.info(msg);
		test.log(Status.PASS, msg+ " passed");
		}catch(Exception e) {
			Log4J.error(msg);
			test.log(Status.FAIL, msg+ " failed");
		}
	}

	/**
	 * to get the text of an element
	 * 
	 * @param element
	 * @param msg
	 * @return
	 */
	public static String getTextOfElement(WebElement element, String msg) {
		try {
			element.isDisplayed();
			return element.getText();
		} catch (Exception e) {
			return "";
		}

	}

	/**
	 * to get the attribute value
	 * 
	 * @param element
	 * @param attribute name
	 * @param msg
	 * @return
	 */

	public static String getAttributeOfElement(WebElement element, String attribute, String msg) {
		try {
			element.isDisplayed();
			return element.getAttribute(attribute);
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * to pause execution
	 * 
	 * @param time
	 * @throws InterruptedException
	 */
	public static void Wait(int time) throws InterruptedException {
		Thread.sleep(time);
	}
	
	/**
	 * to verify the dropdown values
	 * 
	 * @param element
	 * @param msg
	 * @param values
	 */
	public static void verifyPickListValues(WebElement element, String[] values, String msg) {
		try {
		Select selection = new Select(element);
		List<WebElement> options = selection.getOptions();
		for (WebElement ele : options) {
			for (int i = 0; i < values.length; i++) {
				assertTrue(ele.getText().equalsIgnoreCase(values[i]));
				break;
			}
		}
		Log4J.info(msg);
		test.log(Status.PASS, msg+ " passed");
		}catch(Exception e) {
			Log4J.error(msg);
			test.log(Status.FAIL, msg+ " failed");
		}
	}

	/**
	 * to move the mouse to element
	 * 
	 * @param msg
	 * @param element
	 */
	public static void moveToElement(WebElement element, String msg) {
		Actions action = new Actions(BaseTest.getDriver());
		action.moveToElement(element).build().perform();
	}

	/**
	 * to perform drag and drop
	 * 
	 * @param sourceEle
	 * @param desEle
	 * @param msg
	 */
	public static void dragAndDrop(WebElement sourceEle, WebElement desEle, String msg) {
		Actions action = new Actions(BaseTest.getDriver());
		action.dragAndDrop(sourceEle, desEle).build().perform();

	}

}
