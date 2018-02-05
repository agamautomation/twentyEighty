package com.twentyeighty.smil.License;

import org.openqa.selenium.By;
import org.seleniumhq.jetty7.util.log.Log;

import com.twentyeighty.core.Wrapper;
import com.twentyeighty.functional.ResellerResgistrationTest;
import com.twentyeighty.myesiws.NewUserMyESI;
import com.twentyeighty.publicws.PersonalInfoPage;
import com.twentyeighty.resellerws.RegisterWithACourse;

public class ValidateLicenseInCPC {

	By cpcLink = By.cssSelector("a[href='/ProcessingCenter']");
	By advancedLink = By.xpath("//div[@id ='search-simple']/table/tbody/tr/td[3]/a");
	By emailTextbox = By.cssSelector("input#Search_Email_Query");
	By buttonSearch = By.cssSelector("button#btnSearch");
	By clickToEdit = By.xpath("//a[@data-original-title='Click to edit.']");
	By seatsRemaining = By.xpath("//div[@id='displayLicensePopUp']/div/dl[1]/dd[4]");
	By seatsPending = By.xpath("//div[@id='displayLicensePopUp']/div/dl[1]/dd[5]");
	public static int totalRemainingseats;
	public static int totalPendingseats;
	By licenseInfoIcon = By.xpath("//a[@onclick='ShowLicensePopUpModal()']");
	By licenseCode = By.xpath("//div[@id='PaymentInformation']/dl/dt[2]");
	By invalidLicenseCode = By.xpath("//div[@id='displayLicensePopUp']/div/dl/dd");
	By popupClose = By.xpath("//div[@id='displayLicensePopUp']/div/button");
	By licenseText = By.xpath("//div[@id='LicensePopUp']/div/div/div/div[2]/dl[1]/dd[1]");
	public static String licensetext;
	Wrapper wrapperObj = Wrapper.getInstance();



	public void getIntoCPCEditPage(String Email)
	{
		wrapperObj.click(cpcLink);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(advancedLink);
		wrapperObj.holdOn(1000);
		wrapperObj.setTextBoxValue(emailTextbox, Email);
		//wrapperObj.setTextBoxValue(emailTextbox,RegisterWithACourse.resEmail);
		//wrapperObj.setTextBoxValue(emailTextbox,Email);
		//wrapperObj.setTextBoxValue(emailTextbox, "amtest589@mailinato.test");
		wrapperObj.click(buttonSearch);
		wrapperObj.click(clickToEdit);


	}

	public void getIntoCPCViewPage()
	{

	}


	public void approveFromCPC(){

	}
	public void approveWithNoseats(){

	}
	public int checkPendingSeatsOfLicense(){

		try	{
			totalPendingseats =Integer.parseInt(wrapperObj.getElement(seatsPending).getText());
			System.out.println("Total pending seats"  + " " +totalPendingseats);
		}
		catch(Exception e){

			wrapperObj.holdOn(1000);
			wrapperObj.getElement(invalidLicenseCode).getText().contains("invalid.");
			System.out.println("Invalid License");
		}
		return totalPendingseats;
	}


	public int checkRemainingSeatsOfLicense(){

		try	{
			totalRemainingseats = Integer.parseInt(wrapperObj.getElement(seatsRemaining).getText());
			System.out.println("Total Remaining seats" + " "  +totalRemainingseats);
		}

		catch(Exception e){

			wrapperObj.getElement(invalidLicenseCode).getText().contains("invalid");
			System.out.println("Invalid License");
		}return totalRemainingseats;


	}
	public String getLicenseInfo()
	{
		if(wrapperObj.getElement(licenseCode).isDisplayed()){
			wrapperObj.click(licenseInfoIcon);
			licensetext = wrapperObj.getElement(licenseText).getText();
		}
		else
		{
			System.out.println("Payment method is different");

		}
		return licensetext;
	}
	public void closePopup(){
		wrapperObj.click(popupClose);

	}

	public void approveWithExpiryDate(){

	}
}