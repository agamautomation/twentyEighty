package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.publicws.BillingInfo;
import com.twentyeighty.publicws.PersonalInfoPage;
import com.twentyeighty.publicws.SelectCoursePublicWebsite;
import com.twentyeighty.smil.License.ApproveFromCPC;



public class PublicWebsiteRegistrationTest extends BaseTest{

	SelectCoursePublicWebsite selectCourseObj = new SelectCoursePublicWebsite();
	PersonalInfoPage personalInfoObj = new PersonalInfoPage();
	BillingInfo billingInfoObj = new BillingInfo();
	//Wrapper wrapperObj= new Wrapper();
	Wrapper wrapperObj = Wrapper.getInstance();
	ApproveFromCPC approveFromcpcObj = new ApproveFromCPC();
	@Test
	public void registrationTest() throws InterruptedException
	{	
		test = extent
				.startTest("Verify Public Website Registration").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Register");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("PublicWebsite", "URL"));
		selectCourseObj.CheckoutWithACourse();
		personalInfoObj.enterPersonalInfo();
		billingInfoObj.billingInfoForm();
		

	}

}
