package com.twentyeighty.functional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.publicws.PersonalInfoPage;
import com.twentyeighty.smil.License.ApproveFromCPC;
import com.twentyeighty.smil.License.CreateLicense;
import com.twentyeighty.smil.License.EditLicense;
import com.twentyeighty.smil.License.LogIntoSMIL;
import com.twentyeighty.smil.License.ValidateLicenseInCPC;

public class LicenseInCPCTest extends BaseTest {
	Wrapper wrapperObj= new Wrapper();
	CreateLicense createLicenseObj = new CreateLicense();
	EditLicense editLicenseObj = new EditLicense();
	LogIntoSMIL logintosmilObj = new LogIntoSMIL();
	ValidateLicenseInCPC validateLicenseInCPCobj = new ValidateLicenseInCPC();
	ApproveFromCPC approveFromCPCObj = new ApproveFromCPC();
	int intialPendingseats ;
	int intialRemainingseats ;
	int pendingSeatsafterApproval;
	int remainingSeatsafterApproval;

	int finalPendingseats;
	int finalRemainingSeats;

	@Test
	public void LicenseInfoInCPC() throws Exception
	{	
		test = extent
				.startTest("VerifyLicenseInCPC").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("SMIL", "URL"));
		wrapperObj.holdOn(2000);
		logintosmilObj.logIntoSmil();
		validateLicenseInCPCobj.getIntoCPCEditPage(PersonalInfoPage.newEmailAddress);
		validateLicenseInCPCobj.getLicenseInfo();

		intialPendingseats = validateLicenseInCPCobj.checkPendingSeatsOfLicense();
		intialRemainingseats =validateLicenseInCPCobj.checkRemainingSeatsOfLicense();
		validateLicenseInCPCobj.closePopup();
		wrapperObj.holdOn(3000);
		approveFromCPCObj.approve();
		wrapperObj.waitForBrowserToLoadCompletely();
		/*validateLicenseInCPCobj.getLicenseInfo();
		pendingSeatsafterApproval = validateLicenseInCPCobj.checkPendingSeatsOfLicense();
		remainingSeatsafterApproval = validateLicenseInCPCobj.checkRemainingSeatsOfLicense();
		assertEquals(intialPendingseats-1, pendingSeatsafterApproval);
		assertEquals(intialRemainingseats-1, remainingSeatsafterApproval);

		Thread.sleep(3000);*/
	}

	/*@Test
	public void ExpiredLicenseInCPC() throws Exception
	{	

		test = extent
				.startTest("VerifyExpireLicenseInCPC").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("SMIL", "URL"));
		wrapperObj.holdOn(2000);
		logintosmilObj.logIntoSmil();
		validateLicenseInCPCobj.getIntoCPCEditPage();
		validateLicenseInCPCobj.getLicenseInfo();

		intialPendingseats = validateLicenseInCPCobj.checkPendingSeatsOfLicense();
		intialRemainingseats =validateLicenseInCPCobj.checkRemainingSeatsOfLicense();
		validateLicenseInCPCobj.closePopup();
		wrapperObj.holdOn(3000);
		editLicenseObj.changeExpiryDate();
		approveFromCPCObj.approve();
		validateLicenseInCPCobj.getLicenseInfo();
		finalPendingseats = validateLicenseInCPCobj.checkPendingSeatsOfLicense();
		finalRemainingSeats = validateLicenseInCPCobj.checkRemainingSeatsOfLicense();
		assertTrue(intialPendingseats-finalPendingseats == 1);
		assertTrue(intialRemainingseats-finalRemainingSeats==1);
	}*/}