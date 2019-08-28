package com.automation.framework.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

	private static WebDriver driver = null;

	public static WebDriver getDriver(String browserName) {

		if (driver == null) {
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", PropertyLoader.getProperty("CHROME_DRIVER_PATH"));
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.firefox.driver", PropertyLoader.getProperty("FIREFOX_DRIVER_PATH"));
				driver = new FirefoxDriver();
				break;

			case "safari":
				driver = new SafariDriver();
				break;

			default:
				System.out.println("Invalid browser name provided");
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertyLoader.getProperty("PAGE_LOAD_TIMEOUT")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertyLoader.getProperty("IMPLICIT_WAIT")),
				TimeUnit.SECONDS);

		return driver;
	}

	public static void quitDriver() {
		if (driver != null)
			driver.quit();
		driver = null;
	}

}
