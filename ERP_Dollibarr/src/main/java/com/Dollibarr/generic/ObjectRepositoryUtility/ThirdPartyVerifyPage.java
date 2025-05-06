package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThirdPartyVerifyPage 
{
	WebDriver driver;
	public ThirdPartyVerifyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[text()='Customer Code']/following-sibling::td/span/span[@class=\"clipboardCPValue\"]")
	private WebElement customerCode;
	
	@FindBy(xpath="//div[@class='inline-block floatleft']/following-sibling::div")
	private WebElement thirdPartyNameVerify;
	
	public WebElement getCustomerCode() {
		return customerCode;
	}

	public WebElement getThirdPartyNameVerify() {
		return thirdPartyNameVerify;
	}
	
	
}
