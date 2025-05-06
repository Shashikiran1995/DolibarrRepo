package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsOrAddressesPage 
{
	public ContactsOrAddressesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Customers']")
	private WebElement customersLink;

	@FindBy(xpath="//a[text()='New Contact/Address']")
	private WebElement NewContactsOrAddressesLink;
	
	public WebElement getCustomersLink() {
		return customersLink;
	}

	public WebElement getNewContactsOrAddressesLink() {
		return NewContactsOrAddressesLink;
	}
	
	
}
