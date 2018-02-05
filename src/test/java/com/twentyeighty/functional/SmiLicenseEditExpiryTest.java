package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.smil.License.CreateLicense;
import com.twentyeighty.smil.License.EditLicense;
import com.twentyeighty.smil.License.LogIntoSMIL;

public class SmiLicenseEditExpiryTest extends BaseTest {
	
	

	Wrapper wrapperObj = Wrapper.getInstance();
	CreateLicense createLicenseObj = new CreateLicense();
	EditLicense editLicenseObj = new EditLicense();
	LogIntoSMIL logintosmilObj = new LogIntoSMIL();
	
	@Test
	public void SmilApplicationLicenseEditExpiry() throws InterruptedException
	{	
		test = extent
				.startTest("VerifyLicenseCreation").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("SMIL", "URL"));
		wrapperObj.holdOn(2000);
		logintosmilObj.logIntoSmil();
		createLicenseObj.createLicense();
		editLicenseObj.changeExpiryDate();
		Thread.sleep(3000);
	}

}
