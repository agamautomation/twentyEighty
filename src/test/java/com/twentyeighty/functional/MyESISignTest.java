package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.JdbcSQLServerDriverUrlExample;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.myesiws.EnrollForAClass;
import com.twentyeighty.myesiws.NewUserMyESI;
import com.twentyeighty.myesiws.SignIn;
import com.twentyeighty.smil.License.ApproveFromCPC;

public class MyESISignTest extends BaseTest {
	Wrapper wrapperObj = Wrapper.getInstance();
	SignIn signInObj = new SignIn();
	EnrollForAClass enrollForAcourseObj = new EnrollForAClass();
	JdbcSQLServerDriverUrlExample obj = new JdbcSQLServerDriverUrlExample();
	ApproveFromCPC approveFromcpcObj = new ApproveFromCPC();

	@Test
	public void SignIn()
	{
		test = extent
				.startTest("Verify Public Website Registration").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Register");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("myesi", "URL"));
		signInObj.signIn();
		enrollForAcourseObj.checkOutWithCourse();
		wrapperObj.getDriver().navigate().to(wrapperObj.xmlReader("SMIL", "URL"));
		approveFromcpcObj.getIntoCPCEditPage();
		approveFromcpcObj.approve();

	}








}
