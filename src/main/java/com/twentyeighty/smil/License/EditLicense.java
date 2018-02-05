package com.twentyeighty.smil.License;

import org.openqa.selenium.By;

import com.twentyeighty.core.Wrapper;

public class EditLicense {

	Wrapper wrapperObj = Wrapper.getInstance();

	By licenseTab = By.xpath("//ul/li /a [text()='License']");
	By basicSearch = By.cssSelector("input#Title_BasicSearchText");
	By searchButton = By.cssSelector("button#btnBasic_Search");
	By resultGrid = By.cssSelector("table#dataTable thead tr");
	By clickToEdit = By.cssSelector("a[title='Click to edit this License.']");
	By expirydate = By.cssSelector("input#Session_ExpiryDate");
	By saveButton = By.cssSelector("button[type= 'Submit']");
	By totalseats = By.cssSelector("input#TotalSeats");


	public void changeExpiryDate()
	{
		String oldtab= wrapperObj.getDriver().getWindowHandle();
		wrapperObj.getElement(licenseTab).sendKeys(wrapperObj.openlinkinNewTab());
		wrapperObj.waitForBrowserToLoadCompletely();
		//wrapperObj.setTextBoxValue(basicSearch, CreateLicense.license);
		wrapperObj.setTextBoxValue(basicSearch, ValidateLicenseInCPC.licensetext);
		wrapperObj.click(searchButton);
		wrapperObj.waitForBrowserToLoadCompletely();
		try
		{	
			wrapperObj.getElement(resultGrid).isDisplayed();
			wrapperObj.click(clickToEdit);
		}
		catch(Exception e)
		{
			System .out.println("No results for this license");
		}

		wrapperObj.setTextBoxValue(expirydate, wrapperObj.xmlReader("SMIL", "ExpiredDate"));
		wrapperObj.click(saveButton);
		wrapperObj.getDriver().switchTo().window(oldtab);

	}

	public void changeNumberOfSeats()
	{

		wrapperObj.click(licenseTab);
		wrapperObj.waitForBrowserToLoadCompletely();
		//wrapperObj.setTextBoxValue(basicSearch, CreateLicense.license);
		wrapperObj.setTextBoxValue(basicSearch, ValidateLicenseInCPC.licensetext);
		wrapperObj.click(searchButton);
		wrapperObj.waitForBrowserToLoadCompletely();
		try
		{	
			wrapperObj.getElement(resultGrid).isDisplayed();
			wrapperObj.click(clickToEdit);
		}
		catch(Exception e)
		{
			System .out.println("No results for this license");
		}

		wrapperObj.setTextBoxValue(totalseats, wrapperObj.xmlReader("SMIL", "nototalseats"));
		wrapperObj.click(saveButton);

	}




}







