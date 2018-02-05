package com.twentyeighty.myesiws;

import org.openqa.selenium.By;

import com.twentyeighty.core.JdbcSQLServerDriverUrlExample;
import com.twentyeighty.core.Wrapper;

public class NewUserMyESI {

	public static String newemailAddress;
	Wrapper wrapperObj = Wrapper.getInstance();

	By signUpLink = By.xpath("//a[contains(@href,'SignUp')]");
	By firstname = By.id("ctl00_MainContentArea_FirstNameTextBox");
	By lastname = By.id("ctl00_MainContentArea_LastNameTextBox");
	By email = By.id("ctl00_MainContentArea_EmailAddressTextBox");
	By companyname = By.id("ctl00_MainContentArea_CompanyTextBox");
	By validation = By.id("ctl00_MainContentArea_nextButton");
	By password = By.id("ctl00_MainContentArea_PasswordTextBox");
	By address1 = By.id("ctl00_MainContentArea_Address1TextBox");
	By address2 = By.id("ctl00_MainContentArea_Address2TextBox");
	By zip = By.id("ctl00_MainContentArea_PostalCodeZipTextBox");
	By phone = By.id("ctl00_MainContentArea_PhoneNumberTextBox");
	By submit = By.id("ctl00_MainContentArea_SubmitButton");
	By addressRadio = By.id("ctl00_MainContentArea_caRadioButtonList_1");
	By city = By.id("ctl00_MainContentArea_TownCityTextBox");
	JdbcSQLServerDriverUrlExample obj = new JdbcSQLServerDriverUrlExample();

	public void signUp()
	{
		wrapperObj.click(signUpLink);
		wrapperObj.setTextBoxValue(firstname, wrapperObj.xmlReader("myesi", "firstname")+ wrapperObj.generateRandomNumber());
		wrapperObj.setTextBoxValue(lastname, wrapperObj.xmlReader("myesi", "lastname"));
		wrapperObj.setTextBoxValue(email, newEmailaddress());
		wrapperObj.setTextBoxValue(companyname, wrapperObj.xmlReader("myesi", "company"));
		wrapperObj.click(validation);
	}

	public String newEmailaddress(){

		String emailAddress = wrapperObj.xmlReader("myesi", "newemail");

		newemailAddress = emailAddress + wrapperObj.generateRandomNumber() + "@mailinator.com";

		return newemailAddress;


	}

	public String  extractLink(String query, String databaseName)
	{	
		String bodyValue = obj.sqlmethod(newemailAddress, query, databaseName);

		int item= bodyValue.indexOf("http",0);
		int item1= bodyValue.indexOf("Email address: "+newemailAddress);

		String link="";
		link = bodyValue.substring(item, item1) + "Email address: " +newemailAddress;
		//System.out.println("Email "+item1);
		System.out.println(link);
		return link;

	}

	public void accountDetails(){

		wrapperObj.setTextBoxValue(password, "password");
		wrapperObj.setTextBoxValue(address1, "address1");
		wrapperObj.setTextBoxValue(address2, "address2");
		wrapperObj.setTextBoxValue(city, "City");
		wrapperObj.setTextBoxValue(zip, "20050");
		wrapperObj.setTextBoxValue(phone, "123456789");
		wrapperObj.click(submit);

	}

	public void passwordAndRadioButton()
	{
		wrapperObj.setTextBoxValue(password, "password");
		wrapperObj.click(addressRadio);
		wrapperObj.click(submit);


	}

}
