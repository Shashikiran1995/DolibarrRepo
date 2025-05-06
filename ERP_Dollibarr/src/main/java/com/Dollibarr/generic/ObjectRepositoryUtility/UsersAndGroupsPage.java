package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//hi kumar how are you??????

public class UsersAndGroupsPage 
{
	WebDriver driver;
	public UsersAndGroupsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='New user']")
	private WebElement newUserLink;
	
	@FindBy(xpath="//a[text()='List of users']")
	private WebElement listOfUsersLink;
	
	@FindBy(xpath="//a[text()='Hierarchical view']")
	private WebElement hierarchicalViewLink;
	
	@FindBy(xpath="//a[text()='New group']")
	private WebElement newGroupLink;
	
	@FindBy(xpath="//a[text()='List of groups']")
	private WebElement listOfGroupsLink;
	
	public WebElement getNewUserLink() {
		return newUserLink;
	}
	
	public WebElement getListOfUsersLink() {
		return listOfUsersLink;
	}
	
	public WebElement getHierarchicalViewLink() {
		return hierarchicalViewLink;
	}
	
	public WebElement getNewGroupLink() {
		return newGroupLink;
	}
	
	public WebElement getListOfGroupsLink() {
		return listOfGroupsLink;
	}


}
