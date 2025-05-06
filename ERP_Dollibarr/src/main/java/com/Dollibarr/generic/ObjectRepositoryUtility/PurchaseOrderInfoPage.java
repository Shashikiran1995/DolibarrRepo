package com.Dollibarr.generic.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInfoPage 
{
	WebDriver driver;
	public PurchaseOrderInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*Verifying Elements*/
//	@FindBy(css=".classfortooltip.refurl.valignmiddle")
//	private WebElement thirdPartyVerify; 
	
	@FindBy(xpath="//a[@class='classfortooltip refurl valignmiddle']")
	private WebElement thirdPartyVerify;
	
	
//	@FindBy(css=".inline-block.floatleft.valignmiddle.maxwidth750.marginbottomonly.refid.refidpadding")
//	private WebElement purchaseOrderId;
//	@FindBy(xpath = "//div[contains(text(),'PROV')]")
//	private WebElement purchaseOrderId;
	
	@FindBy(xpath = "//div[contains(@class, 'inline-block') and contains(@class, 'refid') and contains(text(),'PROV')]")
	private WebElement purchaseOrderId;


	
	
	/*Add New Line section elements*/
	@FindBy(xpath="//label[@for='prod_entry_mode_free']/input")
	private WebElement selectTypeRadioBtn;
	
	@FindBy(xpath="//label[@for='prod_entry_mode_free']/..//span[@class='select2-selection__rendered']")
	private WebElement selectTypeDD;
	
	@FindBy(xpath="//input[@class='select2-search__field']")
	private WebElement selectTypeSearchField;
	
	@FindBy(xpath="//body[@aria-label='Editor, dp_desc']")
	private WebElement commentField;
	
	@FindBy(xpath = "//iframe[@title='Editor, dp_desc']")
	private WebElement commentFrame;
	
	@FindBy(id="price_ht")
	private WebElement netMoneyEdit;
	
	@FindBy(xpath="//input[@name='qty']")
	private WebElement purchaseQyantity;
	
	@FindBy(id="remise_percent")
	private WebElement discountEdit;
	
	@FindBy(id="addline")
	private WebElement addLineBtn;
	
	@FindBy(xpath = "//a[text()='Validate and Approve']")
	private WebElement validateAndApproveBtn;
	
	@FindBy(xpath="//div[@class='confirmmessage']//b")
	private WebElement approvedOrderId;
	
	@FindBy(xpath ="//button[text()='Yes']")
	private WebElement submitBtn;
	
	public WebElement getThirdPartyVerify() {
		return thirdPartyVerify;
	}

	public WebElement getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public WebElement getSelectTypeRadioBtn() {
		return selectTypeRadioBtn;
	}

	public WebElement getCommentField() {
		return commentField;
	}

	public WebElement getNetMoneyEdit() {
		return netMoneyEdit;
	}

	public WebElement getDiscountEdit() {
		return discountEdit;
	}

	public WebElement getAddLineBtn() {
		return addLineBtn;
	}

	public WebElement getSelectTypeDD() {
		return selectTypeDD;
	}

	public WebElement getSelectTypeSearchField() {
		return selectTypeSearchField;
	}

	public WebElement getPurchaseQyantity() {
		return purchaseQyantity;
	}

	public WebElement getValidateAndApproveBtn() {
		return validateAndApproveBtn;
	}

	public WebElement getApprovedOrderId() {
		return approvedOrderId;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getCommentFrame() {
		return commentFrame;
	}
	
	
}
