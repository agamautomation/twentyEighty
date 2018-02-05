package com.twentyeighty.functional;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.twentyeighty.core.BaseTest;
import com.twentyeighty.core.CustomLogger;
import com.twentyeighty.core.JdbcSQLServerDriverUrlExample;
import com.twentyeighty.core.Wrapper;
import com.twentyeighty.myesiws.SignIn;
import com.twentyeighty.smil.License.ApproveFromCPC;
import com.twentyeighty.myesiws.EnrollForAClass;
import com.twentyeighty.myesiws.NewUserMyESI;
import com.twentyeighty.myesiws.NewUserMyESI;

public class MyESIRegistrationTest extends BaseTest {
	Wrapper wrapperObj = Wrapper.getInstance();
	SignIn findcourseobj = new SignIn();
	NewUserMyESI newuserobj = new NewUserMyESI();
	JdbcSQLServerDriverUrlExample obj = new JdbcSQLServerDriverUrlExample();
	EnrollForAClass enrollForAClassObj = new EnrollForAClass();
	ApproveFromCPC approveFromcpcObj = new ApproveFromCPC();
	@Test
	public void MyesiRegistration() throws Exception
	{	
		test = extent
				.startTest("MyesiRegistration").assignCategory(this.getClass().getSimpleName());
		test.log(LogStatus.INFO, "Search");
		CustomLogger.logInfo(this.getClass().getSimpleName(),"Starting Test Case Run");
		System.out.println("This is a just a functional test.");
		wrapperObj.getDriver().get(wrapperObj.xmlReader("myesi", "URL"));
		//	findcourseobj.signIn();
		//findcourseobj.selectCourse();
		newuserobj.signUp();
		//obj.sqlmethod(NewUser.newemailAddress);		
		wrapperObj.navigate(newuserobj.extractLink(wrapperObj.xmlReader("myesi", "query"), wrapperObj.xmlReader("myesi", "databasename")));
		newuserobj.accountDetails();
		newuserobj.passwordAndRadioButton();
		enrollForAClassObj.checkOutWithCourse();
		wrapperObj.holdOn(2000);
		//wrapperObj.getDriver().navigate().to(wrapperObj.xmlReader("SMIL", "URL"));
		/*approveFromcpcObj.getIntoCPCEditPage();
		approveFromcpcObj.approve();*/
	}
}