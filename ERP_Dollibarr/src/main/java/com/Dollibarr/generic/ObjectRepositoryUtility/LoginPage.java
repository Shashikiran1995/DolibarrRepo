package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Dollibarr.generic.WebDriverUtility.WebDriverUtility;

public class LoginPage 
{
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(id="username")
	private WebElement usernameEdit;
	
	@FindBy(id="password")
	private WebElement passwordEdit;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login(String userName,String password)
	{
		usernameEdit.sendKeys(userName);
		passwordEdit.sendKeys(password);
		loginBtn.click();
	}
}
