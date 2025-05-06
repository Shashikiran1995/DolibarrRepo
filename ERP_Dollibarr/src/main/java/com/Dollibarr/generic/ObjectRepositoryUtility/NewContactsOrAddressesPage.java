package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewContactsOrAddressesPage 
{
	public NewContactsOrAddressesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="lastname")
	private WebElement lastNameEdit;
	
	@FindBy(xpath="//span[text()='Select a third party']")
	private WebElement selectThirdPartyDD;
	
	@FindBy(className="select2-search__field")
	private WebElement selectThirdPartySearchField;
	
	@FindBy(name="add")
	private WebElement submitBtn;

	public WebElement getLastNameEdit() {
		return lastNameEdit;
	}

	public WebElement getSelectThirdPartyDD() {
		return selectThirdPartyDD;
	}

	public WebElement getSelectThirdPartySearchField() {
		return selectThirdPartySearchField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}
