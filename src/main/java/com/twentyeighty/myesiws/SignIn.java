package com.twentyeighty.myesiws;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;

public class SignIn {

	Wrapper wrapperObj = Wrapper.getInstance();
	By email = By.cssSelector("input#email");
	By password = By.cssSelector("input#password");
	By signIn = By.cssSelector("input#loginButton");
	
	
	
	
	public void signIn()
	{
		wrapperObj.setTextBoxValue(email, wrapperObj.xmlReader("myesi", "email"));
		wrapperObj.setTextBoxValue(password, wrapperObj.xmlReader("myesi", "password"));
		wrapperObj.click(signIn);

	}


}
