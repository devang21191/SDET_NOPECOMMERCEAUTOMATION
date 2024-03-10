package com.nopecommerce.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;
import com.nopecommerce.listeners.TestNGListener;
import com.nopecommerce.utils.Log4J;

public class BaseTest extends TestNGListener {

	static WebDriver driver;

	public static WebDriver getDriver() {
		return driver;
	}

	public static WebDriver lauchBrowser(String browserName, String url) {

		switch (browserName) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		case "edge":
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			break;
		}
		Log4J.info(url + "Launched");
		return driver;

	}

}
