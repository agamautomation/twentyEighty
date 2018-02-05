package com.twentyeighty.smil.License;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;
import com.twentyeighty.myesiws.NewUserMyESI;
import com.twentyeighty.publicws.PersonalInfoPage;

public class ApproveFromCPC {

	Wrapper wrapperObj = Wrapper.getInstance();

	By intacctId = By.cssSelector("input#EditedIntactId");
	By processedAccessGranted = By.cssSelector("select#Status option[value='3']");
	By save = By.xpath("//div[@class='action-bottom-container-buttons']/button[@id='btnApprove']");

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

	public void approve()
	{

		String intacct = String.valueOf(wrapperObj.generateRandomNumber());

		if(wrapperObj.getElement(intacctId).getAttribute("value").isEmpty())
		{
			wrapperObj.setTextBoxValue(intacctId, intacct);
			wrapperObj.holdOn(2000);
			wrapperObj.click(processedAccessGranted);
			wrapperObj.holdOn(2000);
			wrapperObj.click(save);
			wrapperObj.waitForBrowserToLoadCompletely();

		}
		else
		{

			wrapperObj.holdOn(2000);
			wrapperObj.click(processedAccessGranted);
			wrapperObj.holdOn(2000);
			wrapperObj.click(save);
			wrapperObj.waitForBrowserToLoadCompletely();
		}


	}
	public void getIntoCPCEditPage()
	{
		wrapperObj.click(cpcLink);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(advancedLink);
		wrapperObj.holdOn(1000);
		wrapperObj.setTextBoxValue(emailTextbox, PersonalInfoPage.newEmailAddress);
		//wrapperObj.setTextBoxValue(emailTextbox, NewUserMyESI.newemailAddress);

		wrapperObj.click(buttonSearch);
		wrapperObj.click(clickToEdit);
	}
}