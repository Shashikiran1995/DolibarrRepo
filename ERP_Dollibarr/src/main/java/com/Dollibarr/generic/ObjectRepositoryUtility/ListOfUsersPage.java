package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfUsersPage 
{
	WebDriver driver;
	public ListOfUsersPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(name="search_login")
	private WebElement loginNameSearchEdit;
	
	public WebElement getLoginNameSearchEdit() {
		return loginNameSearchEdit;
	}
	
	
}
