package com.twentyeighty.resellerws;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.twentyeighty.core.Wrapper;

public class Information {
	Wrapper wrapperObj = Wrapper.getInstance();
	public static String dynamicUsername;
	By nameTitle = By.cssSelector("input[name ='txtNameTitle']");
	By fname = By.cssSelector("input[name ='txtFirstName']");
	By surname = By.cssSelector("input[name ='txtLastName']");
	By selCompany = By.cssSelector("input[name ='selCompany']");
	By username = By.cssSelector("input[name ='txtUsername']");
	By confirmUsername = By.cssSelector("input[name ='txtConfirmUsername']");
	By lineAddress = By.cssSelector("input[name ='txtA1Line1']");
	By lineAddress2 = By.cssSelector("input[name ='txtA1Line2']");
	By city = By.cssSelector("input[name ='txtA1City']");
	//By State =By.cssSelector("select[name ='selState'] option[value='New York']");
	By selectstatedropdown = By.id("selState");
	By phonenum = By.cssSelector("input[name ='txtPhoneWork']");
	By postalcode = By.cssSelector("input[name ='txtA1Zip']");
	By continuebttn = By.cssSelector("input[name ='Continue']");
	By completeYourRegisteration = By.cssSelector("input[value ='Complete your Registration']");
	By thankyoutest = By.cssSelector("html body h3 font");

	public void StudentInfo()
	{
		wrapperObj.setTextBoxValue(nameTitle, wrapperObj.xmlReader("Reseller", "nametitle"));
		wrapperObj.setTextBoxValue(fname, wrapperObj.xmlReader("Reseller", "fname")+ wrapperObj.generateRandomNumber());
		wrapperObj.setTextBoxValue(surname, wrapperObj.xmlReader("Reseller", "surname"));
		wrapperObj.setTextBoxValue(selCompany, wrapperObj.xmlReader("Reseller", "companyname"));
		dynamicUsername =	usernameforReseller();
		wrapperObj.setTextBoxValue(username, dynamicUsername);
		wrapperObj.setTextBoxValue(confirmUsername, dynamicUsername);
		wrapperObj.setTextBoxValue(lineAddress, wrapperObj.xmlReader("Reseller", "lineAddress"));
		wrapperObj.setTextBoxValue(lineAddress2, wrapperObj.xmlReader("Reseller", "lineAddress2"));
		wrapperObj.setTextBoxValue(city, wrapperObj.xmlReader("Reseller", "city"));
		//wrapperObj.click(selectstatedropdown);
		chooseState();
		wrapperObj.setTextBoxValue(postalcode, wrapperObj.xmlReader("Reseller", "postalcode"));
		wrapperObj.setTextBoxValue(phonenum, wrapperObj.xmlReader("Reseller", "phonenum"));
		wrapperObj.holdOn(5000);
		wrapperObj.click(continuebttn);
		wrapperObj.holdOn(3000);
		wrapperObj.click(completeYourRegisteration);
		wrapperObj.holdOn(3000);
		System.out.println(wrapperObj.getElement(thankyoutest).getText());
		assertTrue(wrapperObj.getElement(thankyoutest).getText().equals("Thank you for your order!"), "Registeration Failed");
	}


	public String usernameforReseller()
	{
		String username12 = wrapperObj.xmlReader("Reseller", "username");
		String usernamdynamic = username12+ wrapperObj.generateRandomNumber();
		return usernamdynamic;
	}

	public void chooseState()
	{

		List <WebElement> li = wrapperObj.getDriver().findElements(By.xpath("//select[@id='selState']/option"));
		for(WebElement e : li){

			if(e.getText().equals("New York"))	{		
				e.click();
				break;
			}
		}
	}
}
