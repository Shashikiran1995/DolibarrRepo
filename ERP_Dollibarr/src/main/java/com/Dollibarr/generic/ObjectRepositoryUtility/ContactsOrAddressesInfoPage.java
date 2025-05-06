package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsOrAddressesInfoPage 
{

	public ContactsOrAddressesInfoPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Create a user']")
	private WebElement CreateAUserLink;
	
	@FindBy(id="login")
	private WebElement loginId;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(xpath="//input[@value='Validate']")
	private WebElement validateBtn;
	
	public WebElement getCreateAUserLink() {
		return CreateAUserLink;
	}

	public WebElement getLoginId() {
		return loginId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getValidateBtn() {
		return validateBtn;
	}
	
	
}
