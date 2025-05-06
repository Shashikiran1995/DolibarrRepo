package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPartyPage 
{
	WebDriver driver;
	public ThirdPartyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//a[text()='New Third Party']")
	private WebElement newThirdPartyLink;
	
	@FindBy(xpath="//a[text()='New Prospect']")
	private WebElement newProspectLink;
	
	@FindBy(xpath="//a[text()='New Customer']")
	private WebElement newCustomerLink;
	
	@FindBy(xpath="//a[text()='New Vendor']")
	private WebElement newVendorLink;
	
	@FindBy(xpath="//div[text()='Third Parties/Contacts']")
	private WebElement thirdPartyPageVerify;
	
	public WebElement getNewThirdPartyLink() {
		return newThirdPartyLink;
	}

	public WebElement getNewProspectLink() {
		return newProspectLink;
	}

	public WebElement getNewCustomerLink() {
		return newCustomerLink;
	}

	public WebElement getNewVendorLink() {
		return newVendorLink;
	}

	public WebElement getThirdPartyPageVerify() {
		return thirdPartyPageVerify;
	}
	
	
}
