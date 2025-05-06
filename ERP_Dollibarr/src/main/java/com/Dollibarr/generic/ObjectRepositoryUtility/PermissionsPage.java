package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PermissionsPage 
{
	WebDriver driver;
	public PermissionsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[text()='Read other users and groups']/preceding-sibling::td[@class='center nowrap']//span")
	private WebElement readUsersToggle;
	
	@FindBy(xpath="//td[text()='Create/modify his own user information']/preceding-sibling::td[@class='center nowrap']//span")
	private WebElement modifyOwnInfoToggle;
	
	@FindBy(xpath="//td[text()='Modify his own password']/preceding-sibling::td[@class='center nowrap']//span")
	private WebElement modifyOwnPasswordToggle;
	
	@FindBy(xpath="//span[@class='permtohide_holiday']/a[@title='All']")
	private WebElement leaveRequestAllLink;
	
	@FindBy(xpath="//span[@class='badge marginleftonlyshort']")
	private WebElement permissionsVerify;
	
	@FindBy(xpath="//span[@class='permtohide_societe']//a[@title='All']")
	private WebElement ThirdPartyAllAccess;
	
	public WebElement getReadUsersToggle() {
		return readUsersToggle;
	}

	public WebElement getModifyOwnInfoToggle() {
		return modifyOwnInfoToggle;
	}

	public WebElement getModifyOwnPasswordToggle() {
		return modifyOwnPasswordToggle;
	}

	public WebElement getLeaveRequestAllLink() {
		return leaveRequestAllLink;
	}

	public WebElement getPermissionsVerify() {
		return permissionsVerify;
	}

	public WebElement getThirdPartyAllAccess() {
		return ThirdPartyAllAccess;
	}

	
	
	
}
