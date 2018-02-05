package com.twentyeighty.functional;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.moodle.LearningPortalAccountSetUp;

public class LearningPortalTest extends BaseTest{


	Wrapper wrapperObj = Wrapper.getInstance();
	LearningPortalAccountSetUp accountsetupobj = new LearningPortalAccountSetUp();
	@Test
	public void AccountSetUpLink() throws Exception
	{	
		test = extent
				.startTest("LearningPortal").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(accountsetupobj.ExtractLink());
		accountsetupobj.signUp();
		wrapperObj.holdOn(10000);

	}


}
