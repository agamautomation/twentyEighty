package com.twentyeighty.moodle;

import org.openqa.selenium.By;

import com.twentyeighty.core.JdbcSQLServerDriverUrlExample;
import com.twentyeighty.core.Wrapper;

public class LearningPortalAccountSetUp {


	By username = By.cssSelector("input#UserName");
	By password = By.cssSelector("input#Password");
	By confirmPassword = By.id("ConfirmPassword");
	Wrapper wrapperObj = Wrapper.getInstance();
	By firstname = By.cssSelector("input#FirstName");
	By savebttn = By.id("btnSave");
	JdbcSQLServerDriverUrlExample obj = new JdbcSQLServerDriverUrlExample();
	public String ExtractLink()
	{
		String bodyValue =obj.sqlmethod("2", wrapperObj.xmlReader("learningportal", "query"), wrapperObj.xmlReader("learningportal", "databasename"));

		System.out.println(bodyValue);

		int item= bodyValue.indexOf("https",0);
		int item1= bodyValue.indexOf("fstagelearningportal.strategyex.com");

		String link="";
		link = bodyValue.substring(item, item1) ;
		String URL ="";
		URL = link + "fstagelearningportal.strategyex.com";
		System.out.println(URL);
		return URL;
	}


	public void signUp()
	{
		//String firstName = wrapperObj.getTextBoxValue(firstname);
		//wrapperObj.setTextBoxValue(username, firstName);
		wrapperObj.setTextBoxValue(username, "coursetest2");
		
		wrapperObj.setTextBoxValue(password, "pass123");
		wrapperObj.setTextBoxValue(confirmPassword, "pass123");
		wrapperObj.click(savebttn);

	}
}
