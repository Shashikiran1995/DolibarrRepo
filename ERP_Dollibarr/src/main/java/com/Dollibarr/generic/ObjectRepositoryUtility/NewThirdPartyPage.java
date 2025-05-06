package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewThirdPartyPage 
{
	WebDriver driver;
	public NewThirdPartyPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy(xpath="//input[@id='name']")
	private WebElement thirdPartyNameEdit;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single flat']")
	private WebElement prospectOrCustomerSelectDD;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']/input")
	private WebElement prospectOrCustomerSelectSearchField;
	
	@FindBy(xpath="//span[@class=\"select2-selection__rendered\"]/../../span[@class='select2-selection select2-selection--single flat width75']")
	private WebElement vendorDD;
	
	@FindBy(xpath="//span[@class='select2-search select2-search--dropdown']/input")
	private WebElement vendorSearchField;
	
	@FindBy(xpath="//input[@name='save']")
	private WebElement saveBtn;
	public WebElement getThirdPartyNameEdit() {
		return thirdPartyNameEdit;
	}

	public WebElement getProspectOrCustomerSelectDD() {
		return prospectOrCustomerSelectDD;
	}

	public WebElement getProspectOrCustomerSelectSearchField() {
		return prospectOrCustomerSelectSearchField;
	}

	public WebElement getVendorDD() {
		return vendorDD;
	}

	public WebElement getVendorSearchField() {
		return vendorSearchField;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createThirdParty(String thirdPartyName,String customerOrProspectr,String vendorOrNot)
	{
		HomePage hp=new HomePage(driver);
		hp.getThirdPartiesLink().click();
		
		ThirdPartyPage tp=new ThirdPartyPage(driver);
		tp.getNewThirdPartyLink().click();
		
		NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
		ntp.getThirdPartyNameEdit().sendKeys(thirdPartyName);
		ntp.getProspectOrCustomerSelectDD().click();
		ntp.getProspectOrCustomerSelectSearchField().sendKeys(customerOrProspectr);
		ntp.getProspectOrCustomerSelectSearchField().sendKeys(Keys.ENTER);
		ntp.getVendorDD().click();
		ntp.getVendorSearchField().sendKeys(vendorOrNot);
		ntp.getVendorSearchField().sendKeys(Keys.ENTER);
		ntp.getSaveBtn().click();
	}
	
}
