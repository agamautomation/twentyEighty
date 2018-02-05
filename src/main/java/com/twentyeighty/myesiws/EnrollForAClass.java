package com.twentyeighty.myesiws;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.twentyeighty.core.Wrapper;

public class EnrollForAClass {



	Wrapper wrapperObj = Wrapper.getInstance();
	By userTraining = By.xpath("//ul[@class='topmenumain']/li[1]/a[1]");
	By findCourses = By.xpath("//ul[@class='topmenumain']/li[1]//ul/li[2]/a");
	By searchButton = By.cssSelector("input[type='submit']#ctl00_MainContentArea_searchButton");
	By courseDropdown = By.cssSelector("Select#ctl00_MainContentArea_titleDropDown ");
	By deliveryMethodDropdown = By.cssSelector("Select#ctl00_MainContentArea_typeDropDown");
	By scheduleClassSession = By.cssSelector("a#ctl00_MainContentArea_courseRepeater_ctl01_classDataList_ctl00_addToCartHyperLink");
	By completeOrderButton = By.id("ctl00_MainContentArea_checkoutButton");
	By startDate = By.id("ctl00_MainContentArea_startDateTextBox");
	By paymentRadioBttn = By.id("ctl00_MainContentArea_paymentRadio_1");
	By nextButton = By.id("ctl00_MainContentArea_nextButton");
	By purchaseOrderNumber = By.id("ctl00_MainContentArea_purchaseOrderNumberTextBox");
	By purchaseOrderDate = By.id("ctl00_MainContentArea_purchaseOrderDateTextBox");
	By copyMailingAddress = By.id("ctl00_MainContentArea_purchaseOrderAddressControl_copyMailingLinkButton");
	By nextButttonOnCheckout = By.id("ctl00_MainContentArea_nextButton");
	By keepAddressRadioButton = By.id("ctl00_MainContentArea_purchaseOrderAddressControl_caRadioButtonList_1");
	By acceptButton = By.id("ctl00_MainContentArea_nextButton");
	By okButton = By.id("ctl00_MainContentArea_nextButton");
	
	
	public void checkOutWithCourse()
	{
		wrapperObj.click(userTraining);
		wrapperObj.holdOn(3000);
		wrapperObj.click(findCourses);
		wrapperObj.waitForBrowserToLoadCompletely();
		selectCourse();
		wrapperObj.holdOn(5000);
		selectDeliveryMethod();
		wrapperObj.holdOn(5000);
		wrapperObj.click(searchButton);
		wrapperObj.holdOn(2000);
		wrapperObj.click(scheduleClassSession);
		wrapperObj.waitForBrowserToLoadCompletely();
		wrapperObj.click(completeOrderButton);
		wrapperObj.waitForBrowserToLoadCompletely();
		LocalDate localDate = LocalDate.now();
		System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDate));
		wrapperObj.setTextBoxValue(startDate, DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDate));
		wrapperObj.holdOn(2000);
		//	System.out.println(DateTimeFormatter.ofPattern("m/dd/yyyy").format(localDate));
		wrapperObj.click(paymentRadioBttn);
		wrapperObj.click(nextButton);
		wrapperObj.setTextBoxValue(purchaseOrderNumber, "123451");
		wrapperObj.setTextBoxValue(purchaseOrderDate, DateTimeFormatter.ofPattern("MM/dd/yyyy").format(localDate));
		wrapperObj.click(copyMailingAddress);
		wrapperObj.click(nextButttonOnCheckout);
		wrapperObj.click(keepAddressRadioButton);
		wrapperObj.holdOn(3000);
		wrapperObj.click(nextButttonOnCheckout);
		wrapperObj.click(acceptButton);
		wrapperObj.click(okButton);


	}


	public void selectDeliveryMethod()

	{
		wrapperObj.click(deliveryMethodDropdown);
		List <WebElement> li= wrapperObj.getDriver().findElements(By.cssSelector("Select#ctl00_MainContentArea_typeDropDown option"));	

		for(WebElement e : li)

		{
			System.out.println(e.getText());
			if(e.getText().equals("eTraining")){	
				wrapperObj.holdOn(2000);
				e.click();
				System.out.println("Clicked");
			}

		}


	}

	public void selectCourse()
	{
		wrapperObj.click(courseDropdown);
		List <WebElement> li2 = wrapperObj.getDriver().findElements(By.cssSelector("Select#ctl00_MainContentArea_titleDropDown option"));
		for(WebElement e : li2)
		{
			if(e.getText().equals("Developing Use Cases")){
				e.click();
			}

		}}




}

