package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.smil.License.LogIntoSMIL;
import com.twentyeighty.smil.adminmanagement.AdminManagement;

public class AdminTest extends BaseTest {

	Wrapper wrapperObj= new Wrapper();
	LogIntoSMIL logintosmilObj = new LogIntoSMIL();
	AdminManagement adminmanagementObj = new AdminManagement();
	@Test
	public void AdminCreation() throws Exception
	{	
		test = extent
				.startTest("VerifyAdminCreation").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Admin Management");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("SMIL", "URL"));
		wrapperObj.holdOn(2000);
		logintosmilObj.logIntoSmil();
		adminmanagementObj.adminRecordLandingPage();
		//adminmanagementObj.createCDS();
		adminmanagementObj.createClientAdmin();
	adminmanagementObj.retriggerClick();

	}
}