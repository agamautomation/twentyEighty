package com.twentyeighty.smil.License;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;

public class LogIntoSMIL {

	By loginUsername = By.cssSelector("input#UserName");
	By password = By.cssSelector("input#Password");
	By Login = By.xpath("//table[@id='loginTable']//button");
	Wrapper wrapperObj = Wrapper.getInstance();

	public void logIntoSmil()
	{
		if(wrapperObj.getDriver().getTitle().contains("Home Page"))
		{
			System.out.println("Welcome to SMIL");
		}
		else
		{
			wrapperObj.setTextBoxValue(loginUsername, "singhnarulaa");
			wrapperObj.setTextBoxValue(password, "Password123!");
			wrapperObj.click(Login);
			wrapperObj.waitForBrowserToLoadCompletely();
		}

}
}