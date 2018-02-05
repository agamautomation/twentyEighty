package com.twentyeighty.core;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.utilities.SendEmailWithAttachment;

public class BaseTest {


	protected static ExtentReports extent;
	static public ExtentTest test;
	static Wrapper baseObj= new Wrapper();
	SendEmailWithAttachment mailReport =  new SendEmailWithAttachment();
	
	
    @BeforeSuite
	public void beforeSuite() {
		extent = new ExtentReports("Automation_Report.html", true);
		extent.loadConfig(new File("extent-config.xml"));

		Map<String, String> sysInfo = new HashMap<String, String>();
		sysInfo.put("Selenium Version", "2.46");
		sysInfo.put("Environment", "NST-Internal");
		extent.addSystemInfo(sysInfo);
	}


	//it will call the getDriver and will pass the values
	@BeforeMethod
	@Parameters({ "browserName",})
	public void InitiateDriver(String browserName) {
		BaseDriver.getDriver(browserName);
	}

	@AfterTest
	public void stopDriver() {
		BaseDriver.stopDriver();
	}

	@AfterMethod
	public static void StopDriver(ITestResult result) {
		if (!result.isSuccess()) {
			test.log(LogStatus.FAIL, result.getThrowable());
			String methodName=result.getName().toString().trim();
			takeScreenShot(methodName);
		} else {
			test.log(LogStatus.PASS, result.getMethod().getMethodName());
		}

		if (test != null) {
			extent.endTest(test);
		}

		BaseDriver.stopDriver();
		extent.flush();
	}

	public static void takeScreenShot(String methodName) {
		//get the driver
		File scrFile = ((TakesScreenshot)baseObj.getDriver()).getScreenshotAs(OutputType.FILE);
		//The below method will save the screen shot in d drive with test method name 
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshot\\"+methodName+".png"));
			System.out.println("***Placed screen shot ***");
			test.log(LogStatus.FAIL, "Screencast below: " + test.addScreenCapture(System.getProperty("user.dir")+"\\screenshot\\"+methodName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	protected void afterSuite() {
		extent.close();
		mailReport.sendEmail();

	}
}
