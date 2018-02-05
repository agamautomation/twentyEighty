package com.twentyeighty.smil.adminmanagement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;

import com.twentyeighty.core.Wrapper;
import com.twentyeighty.publicws.PersonalInfoPage;

public class AdminManagement {



	Wrapper wrapperObj = Wrapper.getInstance();

	By adminManagementtab = By.xpath("//li//a[@href='/Admins']");
	By advancedLink = By.xpath("//a[@onclick ='ShowSearchAdvanced();']");
	By emailTextbox = By.cssSelector("input#Search_Email_Query");
	By submit = By.xpath("//table//tr//td//table//tbody//tr//td//button[@type= 'submit']");
	By clickToEdit = By.cssSelector("a[data-original-title='Click to edit.']");
	By clicktoCreate = By.cssSelector("button[id ='btnApprove']");
	By clients = By.cssSelector("input[id ='clientList']");
	By licenseUpdate = By.cssSelector("tr td input#update");
	By licenseTableDisplayed = By.xpath("//div[contains(@style,'display: block')]/table");
	By triggerAccount = By.xpath("//tr/td[7]/a[3]");

	public void adminRecordLandingPage()
	{
		wrapperObj.click(adminManagementtab);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(advancedLink);
		wrapperObj.waitForBrowserToLoadCompletely();
		//wrapperObj.setTextBoxValue(emailTextbox, PersonalInfoPage.newEmailAddress);
		wrapperObj.setTextBoxValue(emailTextbox, "Auto_public_795704@mailinator.com");
		wrapperObj.waitForBrowserToLoadCompletely();

		wrapperObj.click(submit);
		wrapperObj.click(clickToEdit);
	}


	public void createCDS()
	{

		adminType("CDS Admin");
		wrapperObj.click(clicktoCreate);
		wrapperObj.waitForBrowserToLoadCompletely();
	}

	public void createClientAdmin()
	{

		adminType("Client Admin");

		wrapperObj.click(clicktoCreate);
		wrapperObj.setTextBoxValue(clients, "1151");
		wrapperObj.holdOn(2000);
		wrapperObj.getElement(clients).sendKeys(Keys.ARROW_DOWN);
		wrapperObj.getElement(clients).sendKeys(Keys.ENTER);

		try{
			wrapperObj.getElement(licenseTableDisplayed).isDisplayed();
			wrapperObj.click(licenseUpdate);
			wrapperObj.click(clicktoCreate);

		}
		catch(Exception e){
			System.out.println("There is no License associated with this client");
		}
		wrapperObj.waitForBrowserToLoadCompletely();

	}

	public void retriggerClick()
	{

		wrapperObj.click(adminManagementtab);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(advancedLink);
		wrapperObj.waitForBrowserToLoadCompletely();
		//wrapperObj.setTextBoxValue(emailTextbox, PersonalInfoPage.newEmailAddress);
		wrapperObj.setTextBoxValue(emailTextbox, "KaderBatcha.AKM@sc.com.test");
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(submit);
		wrapperObj.click(triggerAccount);
		
	}
	public void adminType(String admintype)
	{
		List <WebElement> li = wrapperObj.getDriver().findElements(By.cssSelector("select#adminType option"));		

		for (WebElement e : li)
		{
			if(e.getText().equals(admintype))
			{

				e.click();


			}


		}

	}




}



