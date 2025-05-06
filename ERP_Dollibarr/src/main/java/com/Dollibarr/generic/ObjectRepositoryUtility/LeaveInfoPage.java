package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeaveInfoPage 
{

	WebDriver driver;
	public LeaveInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Validate']")
	private WebElement validateBtn;
	
	public WebElement getValidateBtn() {
		return validateBtn;
	}
	
	
}
