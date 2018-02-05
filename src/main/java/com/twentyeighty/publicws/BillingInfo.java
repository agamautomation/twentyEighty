package com.twentyeighty.publicws;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.twentyeighty.core.Wrapper;

import com.twentyeighty.smil.License.CreateLicense;


public class BillingInfo {
	Wrapper wrapperObj = Wrapper.getInstance();
	CreateLicense localObjCreateLicense = new CreateLicense();

	CreateLicense createlicenseobj = new CreateLicense();
	private By paymentCheckboxLicense = By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_paymentMethodsRadioButtonList']/tbody/tr[4]/td/label");
	private By licenseTextbox = By.cssSelector("fieldset#licenseInfoForm div input[type= 'text']");
	private By addressLine1 = By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_baAddressOneTextBox']");
	private By addressLine2 = By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_baAddressTwoTextBox']");
	private By city = By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_baCityTextBox']");
	private By zipCode = By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_baZipTextBox']");
	private By nextButton = By.xpath(".//input[@id='btnGoNext']");
	private By finishButton = By.xpath(".//input[@id='btnNext']");
	private By thankyouTest = By.xpath(".//div[@id='CartWrapper']/p[1]");

	public void billingInfoForm(){
		wrapperObj.click(paymentCheckboxLicense);
		wrapperObj.holdOn(3000);
		//wrapperObj.setTextBoxValue(licenseTextbox, localObjCreateLicense.licenseToUse());
		wrapperObj.setTextBoxValue(licenseTextbox, "CISCO-001");
		wrapperObj.holdOn(2000);
		chooseCountry();
		wrapperObj.holdOn(3000);
		wrapperObj.setTextBoxValue(addressLine1, "Add1");
		wrapperObj.setTextBoxValue(addressLine2, "Add2");
		wrapperObj.setTextBoxValue(city, "City");
		chooseState();
		wrapperObj.setTextBoxValue(zipCode, "12345");
		wrapperObj.click(nextButton);
		wrapperObj.click(finishButton);

		try{

			wrapperObj.holdOn(10000);
			System.out.println(wrapperObj.getElement(thankyouTest).getText());
			wrapperObj.holdOn(1000);
			wrapperObj.getElement(thankyouTest).getText().contains("Thank you for your order. Your order is currently being processed by TwentyEighty Strategy Execution");

		}
		catch(Exception e)
		{

			System.out.println("We encountered an error processing your registration" + e);
		}
	}
	public void chooseCountry(){

		List<WebElement> li = wrapperObj.getDriver().findElements(By.xpath(".//select[@id='bodycontent_0_contentcolumn1_0_baCountryDropDownList']/optgroup/option"));
		li.get(1).click();


	}

	public void chooseState()
	{
		List<WebElement> li2 = wrapperObj.getDriver().findElements(By.xpath(".//*[@id='bodycontent_0_contentcolumn1_0_baUSStateDropDownList']/optgroup/option"));
		li2.get(17).click();

	}



}
