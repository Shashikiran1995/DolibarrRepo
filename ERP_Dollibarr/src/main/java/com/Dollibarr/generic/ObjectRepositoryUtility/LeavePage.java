package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeavePage 
{
	WebDriver driver;
	public LeavePage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	@FindBy(xpath="//div[@class='menu_contenu menu_contenu_holiday_card']/a")
	private WebElement newLeaveLink;
	
	public WebElement getNewLeaveLink() {
		return newLeaveLink;
	}
	
	
}
