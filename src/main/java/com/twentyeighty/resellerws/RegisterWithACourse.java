package com.twentyeighty.resellerws;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;

public class RegisterWithACourse {

	public static String resEmail;
	Wrapper wrapperObj = Wrapper.getInstance();
	By courseLink = By.xpath("//tr[19]/td[2]/a");
	By  likeToRegister = By.xpath("//form/input[3]");
	By agree = By.xpath("//tr/td/p/input");
	By emaillocator = By.xpath("//input[@name='txtEmail']");
	By password = By.xpath("//input[@name ='txtPassword']");
	By continueButton = By.xpath("//input[@value = 'Continue']");
	By emailCreatePage = By.cssSelector("input[name='txtEmail']");
	By confirmEmail = By.cssSelector("input[name ='txtConfirmEmail']");
	By passwordCreatepage = By.cssSelector("input[name ='txtPassword']");
	By confirmpasswordCreatePage = By.cssSelector("input[name='txtConfirmPassword']");
	By createRecord = By.cssSelector("input[value='Create record']");
	By createNewRecord = By.cssSelector("input[value='Create new record']");


	public void signUpForACourse()
	{

		String emailValue = resellerEmail();
		wrapperObj.click(courseLink);
		wrapperObj.click(likeToRegister);
		wrapperObj.click(agree);
		wrapperObj.setTextBoxValue(emaillocator, emailValue);
		wrapperObj.setTextBoxValue(password, wrapperObj.xmlReader("Reseller", "password"));
		wrapperObj.click(continueButton);
		wrapperObj.click(createNewRecord);
		wrapperObj.setTextBoxValue(emailCreatePage, emailValue);
		wrapperObj.setTextBoxValue(confirmEmail, emailValue);
		wrapperObj.setTextBoxValue(passwordCreatepage, wrapperObj.xmlReader("Reseller", "password"));
		wrapperObj.setTextBoxValue(confirmpasswordCreatePage, wrapperObj.xmlReader("Reseller", "password"));
		wrapperObj.click(createRecord);

	}





	public String resellerEmail()
	{ 
		String email = wrapperObj.xmlReader("Reseller", "Email");
		resEmail = email + wrapperObj.generateRandomNumber() + "@mailinator.com";
		return resEmail;

	}




	// - developing use case regiter
	// - i'd like to regiter now
	//t - Agree
	// - email
	// - password
	// - continue button






}
