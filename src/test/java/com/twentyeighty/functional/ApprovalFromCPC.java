package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.smil.License.ApproveFromCPC;
import com.twentyeighty.smil.License.LogIntoSMIL;

public class ApprovalFromCPC extends BaseTest {

	Wrapper wrapperObj = Wrapper.getInstance();

	ApproveFromCPC approvafromcpcObj = new ApproveFromCPC();
	LogIntoSMIL loginIntoSmilObj = new LogIntoSMIL();

	@Test
	public void MyesiRegistration() throws Exception
	{	
		test = extent
				.startTest("ApprovalFromCPC").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("SMIL", "URL"));
		loginIntoSmilObj.logIntoSmil();
		approvafromcpcObj.getIntoCPCEditPage();
		approvafromcpcObj.approve();

	}}
