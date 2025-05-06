package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserVerifyPage 
{
	WebDriver driver;
	public UserVerifyPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath="//span[@class='clipboardCPValue']")
    private WebElement loginNameVerify;
	
	@FindBy(className="jnotify-close")
	private WebElement cancelNotify;
	
	@FindBy(xpath="//a[@title='Permissions']")
	private WebElement permissionsBtn;
	
	public WebElement getLoginNameVerify() {
		return loginNameVerify;
	}

	public WebElement getCancelNotify() {
		return cancelNotify;
	}

	public WebElement getPermissionsBtn() {
		return permissionsBtn;
	}
	
	
	    
}
