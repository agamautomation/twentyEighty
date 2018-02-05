package com.twentyeighty.publicws;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;

public class PersonalInfoPage {
	Wrapper wrapperObj = Wrapper.getInstance();

	public static String newEmailAddress ;


	private By firstName = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountFirstNameTextBox");
	private By lastName = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountLastNameTextBox");
	private By emailAddress = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountEmailAddressTextBox");
	private By company = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountCompanyTextBox");
	private By phoneNumber = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountPhoneNumberTextBox");
	private By password = By.cssSelector("input#bodycontent_0_contentcolumn1_0_createAccountPasswordTextBox");
	private By next = By.cssSelector("div#PInfoStepButtons input[value = 'Next']");

	public void enterPersonalInfo()
	{
		wrapperObj.setTextBoxValue(firstName, firstname());
		//wrapperObj.setTextBoxValue(firstName, "Auto_test_547675");
	wrapperObj.setTextBoxValue(lastName, wrapperObj.xmlReader("PublicWebsite", "lastname"));
	//wrapperObj.setTextBoxValue(lastName, "Auto_lastname");
	wrapperObj.setTextBoxValue(emailAddress, emailAddress());
		//wrapperObj.setTextBoxValue(emailAddress, "Auto_public_886360@mailinator.com");
		wrapperObj.setTextBoxValue(company, wrapperObj.xmlReader("PublicWebsite", "company"));

		wrapperObj.setTextBoxValue(phoneNumber, wrapperObj.xmlReader("PublicWebsite", "phonenumber"));
		wrapperObj.setTextBoxValue(password, wrapperObj.xmlReader("PublicWebsite", "password"));
		wrapperObj.click(next);

	}




	public String firstname(){

		String firstname = wrapperObj.xmlReader("PublicWebsite", "firstname");

		String newFName = firstname + wrapperObj.generateRandomNumber();

		return newFName;


	}

	public String emailAddress(){

		String emailAddress = wrapperObj.xmlReader("PublicWebsite", "emailAddress");

		newEmailAddress = emailAddress + wrapperObj.generateRandomNumber() + "@mailinator.com";
		System.out.print(newEmailAddress);
		return newEmailAddress;


	}
}
