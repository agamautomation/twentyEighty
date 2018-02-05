package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.resellerws.Information;
import com.twentyeighty.resellerws.RegisterWithACourse;

public class ResellerResgistrationTest extends BaseTest {


	RegisterWithACourse resellerCourseObj = new RegisterWithACourse();
	Information resInfoObj = new Information();

	Wrapper wrapperObj = Wrapper.getInstance();
	@Test
	public void registerationReseller() throws Exception
	{	
		test = extent
				.startTest("RegisterationFromReseller").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("Reseller", "URL"));
		wrapperObj.holdOn(2000);
		resellerCourseObj.signUpForACourse();
		wrapperObj.holdOn(3000);
		resInfoObj.StudentInfo();
		/*approveFromCPCObj.approve();
		wrapperObj.waitForBrowserToLoadCompletely();
		validateLicenseInCPCobj.getLicenseInfo();
		pendingSeatsafterApproval = validateLicenseInCPCobj.checkPendingSeatsOfLicense();
		remainingSeatsafterApproval = validateLicenseInCPCobj.checkRemainingSeatsOfLicense();
		assertEquals(intialPendingseats-1, pendingSeatsafterApproval);
		assertEquals(intialRemainingseats-1, remainingSeatsafterApproval);

		Thread.sleep(3000);*/
	}
}
