package com.twentyeighty.smil.License;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.twentyeighty.core.Wrapper;

public class CreateLicense {

	Wrapper wrapperObj = Wrapper.getInstance();
	public static String license ;
	By licenseTab = By.xpath("//ul/li /a [text()='Licenses']");
	By createLicenseBttn = By.cssSelector("a[href = '/License/Create']"); 
	
/*	public static int totalRemainingseats;
	public static int totalPendingseats;*/
	By licensecode = By.cssSelector("input#LicenseCode");
	By licenseowner = By.cssSelector("input#LicenseOwner");
	By totalseats = By.cssSelector("input#TotalSeats");
	By startdate = By.cssSelector("input#Session_StartDate");
	By expirydate = By.cssSelector("input#Session_ExpiryDate");
	By clientName = By.cssSelector("input#Name");
	By invoicenumber = By.cssSelector("input#InvoiceNumber");
	By submit = By.cssSelector("button[type='Submit']");
/*	By seatPending = By.xpath("//dl[1]/dd[5]");
	By seatRemaining = By.xpath("//dl[1]/dd[4]");*/


	public void createLicense()

	{
		wrapperObj.click(licenseTab);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(createLicenseBttn);
		wrapperObj.setTextBoxValue(licensecode, generateLicenseCode());
		wrapperObj.setTextBoxValue(licenseowner, wrapperObj.xmlReader("SMIL", "licenseowner"));
		wrapperObj.setTextBoxValue(totalseats, wrapperObj.xmlReader("SMIL", "totalseats"));
		wrapperObj.setTextBoxValue(startdate,wrapperObj.xmlReader("SMIL", "startdate") );
		wrapperObj.setTextBoxValue(expirydate,wrapperObj.xmlReader("SMIL", "expirydate") );
		wrapperObj.setTextBoxValue(invoicenumber,wrapperObj.xmlReader("SMIL", "invoicenumber") );
		wrapperObj.setTextBoxValue(clientName,wrapperObj.xmlReader("SMIL", "client") );
		wrapperObj.holdOn(2000);
		wrapperObj.getElement(clientName).sendKeys(Keys.ARROW_DOWN);
		wrapperObj.getElement(clientName).sendKeys(Keys.ENTER);
		wrapperObj.click(submit);
		wrapperObj.holdOn(2000);
	/*	totalPendingseats = Integer.parseInt(wrapperObj.getElement(seatPending).getText());
		totalRemainingseats = Integer.parseInt(wrapperObj.getElement(seatPending).getText());*/
	}



	public String generateLicenseCode()
	{

		license = wrapperObj.xmlReader("SMIL", "licensecode") + wrapperObj.generateRandomNumber();
		return license;
	}

	public String licenseToUse()
	{
		return license;
	}


	/*public int seatsPending(){


		return  totalPendingseats;



	}

	public int seatsRemaining(){

		
		return  totalPendingseats;



	}*/
}

