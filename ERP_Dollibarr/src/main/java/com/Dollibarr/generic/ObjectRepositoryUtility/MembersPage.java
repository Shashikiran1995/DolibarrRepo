package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MembersPage 
{
	WebDriver driver;
	public MembersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='New member']")
	private WebElement newMemberLink;
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement listOfMembersLink;
	
	@FindBy(xpath="//a[text()='Draft members']")
	private WebElement draftMembersLink;
	
	@FindBy(xpath="//a[text()='Validated members']")
	private WebElement validatedMembersLink;
	
	@FindBy(xpath="//a[text()='Membership pending']")
	private WebElement membershipPendingLink;
	
	@FindBy(xpath="//a[text()='Up-to-date']")
	private WebElement upToDateLink;
	
	@FindBy(xpath="//a[text()='Out-of-date']")
	private WebElement outOfDateLink;
	
	@FindBy(xpath="//a[text()='Terminated members']")
	private WebElement terminatedMembersLink;
	
	@FindBy(xpath="//a[text()='Excluded members']")
	private WebElement excludedMembersLink;
	
	@FindBy(xpath="//a[text()='New']")
	private WebElement newMemberTypeLink;
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement listOfMemberTypeLink;
	
	@FindBy(name="search_ref")
	private WebElement memberSerachField;
	
	public WebElement getNewMemberLink() {
		return newMemberLink;
	}
	
	public WebElement getListOfMembersLink() {
		return listOfMembersLink;
	}
	
	public WebElement getDraftMembersLink() {
		return draftMembersLink;
	}
	
	public WebElement getValidatedMembersLink() {
		return validatedMembersLink;
	}
	
	public WebElement getMembershipPendingLink() {
		return membershipPendingLink;
	}
	
	public WebElement getUpToDateLink() {
		return upToDateLink;
	}
	
	public WebElement getOutOfDateLink() {
		return outOfDateLink;
	}
	
	public WebElement getTerminatedMembersLink() {
		return terminatedMembersLink;
	}
	
	public WebElement getExcludedMembersLink() {
		return excludedMembersLink;
	}
	
	public WebElement getNewMemberTypeLink() {
		return newMemberTypeLink;
	}
	
	public WebElement getListOfMemberTypeLink() {
		return listOfMemberTypeLink;
	}

	public WebElement getMemberSerachField() {
		return memberSerachField;
	}

	
}
