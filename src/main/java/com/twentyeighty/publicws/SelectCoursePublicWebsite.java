package com.twentyeighty.publicws;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.twentyeighty.core.Wrapper;

public class SelectCoursePublicWebsite{


	private By courseFinder = By.cssSelector("h2#linken");
	private By checkoutCart = By.cssSelector("a#bodycontent_0_lnkCart[href='/checkout/cart']");
	private By nextButton = By.xpath(".//*[@id='NextPageButton']");
	private By addToCart = By.xpath("//a[@class='btn-blue 360'][1]");

	Wrapper wrapperObj = Wrapper.getInstance();


	public void CheckoutWithACourse() {

		wrapperObj.click(courseFinder);
		wrapperObj.holdOn(10000);

		if(wrapperObj.getElement(checkoutCart).isDisplayed()){
			wrapperObj.getElement(checkoutCart).click();
			wrapperObj.getElement(nextButton).click();
		}
		else {
			
		
			wrapperObj.holdOn(6000);
			selectDeliveryMethod();
			selectCourse();
			wrapperObj.holdOn(2000);
			wrapperObj.getElement(addToCart).click();
			wrapperObj.getElement(checkoutCart).click();
			wrapperObj.getElement(nextButton).click();
		}}




	public void selectCourse() 

	{

		List <WebElement> li = wrapperObj.getDriver().findElements(By.xpath(".//*[@id='ddlCourses_New']/optgroup/option"));
		for(WebElement e : li)
		{
			System.out.println(e.getText());
			if(e.getText().equals("Developing Use Cases"))
			//if(e.getText().equals("How to Gather and Document User Requirements"))
			{
				
				e.click();
				System.out.println("Clicked");
				break;
			}}}




	public void selectDeliveryMethod()
	{	
		List<WebElement> li2 = wrapperObj.getDriver().findElements(By.xpath(".//*[@id='ddlDeliveryMethod_New']/optgroup/option"));

		for(WebElement element : li2)
		{
			if(element.getText().equals("eTraining"))
			{
				element.click();
				break;
			}

		}

	}
}