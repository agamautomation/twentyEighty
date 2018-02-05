package com.twentyeighty.core;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BaseDriver extends Wrapper {


	//Will select the browser, Launch it and send the URL
	public static void getDriver(String browserName) {
		
			try {

			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\BrowserDrivers\\chromedriver.exe");

				ChromeOptions options = new ChromeOptions();
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				options.addArguments("test-type");

				driver = new ChromeDriver(options);

				driver.manage().window().maximize();
				CustomLogger.logInfo("Initialize the driver", browserName + " browser iniialized and and open");
			}

			else if (browserName.equalsIgnoreCase("ie")) {

				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
				capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "//BrowserDriver//IEDriverServer.exe");
				driver = new InternetExplorerDriver(capabilities);
				driver.manage().window().maximize();
				CustomLogger.logInfo("Initialize the driver", browserName + " browser iniialized and and open");
			}

			else if (browserName.equalsIgnoreCase("firefox")) {
				System.out.println("Testing");
				driver = new FirefoxDriver();
				
				driver.manage().deleteAllCookies();
				
				driver.manage().window().maximize();
				CustomLogger.logInfo("Initialize the driver", browserName + " browser iniialized and and open");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//will close the driver
	public static void stopDriver() {

		try {
			if (driver != null) {
				driver.close();
				driver.quit();
				driver = null;
				CustomLogger.logInfo("Closing the driver", "Driver quit");
			}
		} catch (Exception ignore) {
			System.out.println("Getting Exception while closing the driver: " + ignore);
			CustomLogger.logInfo("Closing the driver", "Getting Exception while closing the driver");
		}

	}
}
