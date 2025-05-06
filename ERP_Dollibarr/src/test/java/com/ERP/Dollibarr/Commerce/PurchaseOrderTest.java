package com.ERP.Dollibarr.Commerce;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.ObjectRepositoryUtility.CommercePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.HomePage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewPurchaseOrderPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewThirdPartyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.PurchaseOrderInfoPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ThirdPartyVerifyPage;

public class PurchaseOrderTest extends BaseClass
{
	@Test
	public void createPurchaseOrder() throws EncryptedDocumentException, IOException
	{
		String thirdPartyName = elib.getDataFromExcel("thirdParty", 1, 1)+jlib.getRandomNumber();
		String prospectOrCustomer = elib.getDataFromExcel("thirdParty", 1, 2);
		String vendorOrNot = elib.getDataFromExcel("thirdParty", 1, 3);
		String paymentTerms = elib.getDataFromExcel("purchaseOrder", 1, 2);
		String paymentMethod = elib.getDataFromExcel("purchaseOrder", 1, 3);
		String deliveryDay = elib.getDataFromExcel("purchaseOrder", 1, 4);
		String deliveryMonth = elib.getDataFromExcel("purchaseOrder", 1, 5);
		String deliveryYear = elib.getDataFromExcel("purchaseOrder", 1, 6);
		String typeOfPurchase = elib.getDataFromExcel("purchaseOrder", 1, 7);
		String purchaseComment = elib.getDataFromExcel("purchaseOrder", 1, 8);
		String netMoney = elib.getDataFromExcel("purchaseOrder", 1, 9);
		String quantity = elib.getDataFromExcel("purchaseOrder", 1, 10);
		String discount = elib.getDataFromExcel("purchaseOrder", 1, 11);
		
		HomePage hp=new HomePage(driver);
		NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
		ntp.createThirdParty(thirdPartyName, prospectOrCustomer, vendorOrNot);
		
		ThirdPartyVerifyPage tpv=new ThirdPartyVerifyPage(driver);
		String actThirdParty = tpv.getThirdPartyNameVerify().getText();
		boolean verify = actThirdParty.contains(thirdPartyName);
		Assert.assertEquals(verify, true);	
		
		String customerCode = tpv.getCustomerCode().getText();
		
		hp.getCommerceLink().click();
		
		CommercePage cp=new CommercePage(driver);
		cp.getNewPurchaseOrderLink().click();
		
		NewPurchaseOrderPage npo=new NewPurchaseOrderPage(driver);
		npo.getSelectThirdPartyDD().click();
		npo.getSelectThirdPartySearchField().sendKeys(thirdPartyName);
		npo.getSelectThirdPartySearchField().sendKeys(Keys.ENTER);
		
		npo.getPaymentTermsDD().click();
		npo.getPaymentTermsSearchField().sendKeys(paymentTerms);
		npo.getPaymentTermsSearchField().sendKeys(Keys.ENTER);
		npo.getPaymentModeDD().click();
		npo.getPaymentModeSearchField().sendKeys(paymentMethod);
		npo.getPaymentModeSearchField().sendKeys(Keys.ENTER);
		
		
		npo.selectDate(driver, deliveryDay, deliveryMonth, deliveryYear);
		npo.getSaveBtn().click();
		
		PurchaseOrderInfoPage poi=new PurchaseOrderInfoPage(driver);
		boolean tVerify = poi.getThirdPartyVerify().getText().contains(thirdPartyName);
		Assert.assertEquals(tVerify, true);
		
		String purchaseOrderId = poi.getPurchaseOrderId().getText();
		
		String purchaseId="(PROV";
		for(int i=5;i<purchaseOrderId.length();i++)
		{
			char ch = purchaseOrderId.charAt(i);
			if(Character.isDigit(ch))
			{
				purchaseId=purchaseId+ch;
			}
			else
			{
				break;
			}
		}
		purchaseId=purchaseId+")";
		
		cp.getDraftOfPurchaseOrders().click();
		cp.getSearchOfPurchaseOrder().sendKeys(purchaseId);
		cp.getSearchOfPurchaseOrder().sendKeys(Keys.ENTER);
		
		boolean verifyPurchaseOrder = driver.findElement(By.xpath("//a[text()='"+purchaseId+"']")).isDisplayed();
		Assert.assertEquals(verifyPurchaseOrder, true);
		
		driver.findElement(By.xpath("//a[text()='"+purchaseId+"']")).click();
		
		poi.getSelectTypeRadioBtn().click();
		poi.getSelectTypeDD().click();
		poi.getSelectTypeSearchField().sendKeys(typeOfPurchase);
		poi.getSelectTypeSearchField().sendKeys(Keys.ENTER);
		
		wlib.switchToFrameByElement(driver, poi.getCommentFrame());
		
		poi.getCommentField().sendKeys(purchaseComment);
		
		wlib.switchToDefaultFrame(driver);
		
		poi.getNetMoneyEdit().sendKeys(netMoney);
		poi.getPurchaseQyantity().clear();
		poi.getPurchaseQyantity().sendKeys(quantity);
		poi.getDiscountEdit().sendKeys(discount);
		poi.getAddLineBtn().click();
		
		poi.getValidateAndApproveBtn().click();
		
		wlib.switchToWindowByTitle(driver, "Are you sure you want to validate this order under");
		
		String approvedOrderId = poi.getApprovedOrderId().getText();
		
		poi.getSubmitBtn().click();
		
		wlib.switchToWindowByURL(driver, "dolibarr/fourn/commande");
		
		cp.getApprovedOrders().click();
		cp.getSearchOfPurchaseOrder().sendKeys(approvedOrderId);
		cp.getSearchOfPurchaseOrder().sendKeys(Keys.ENTER);
		
		boolean verifyApprovedOrder = driver.findElement(By.xpath("//a[text()='"+approvedOrderId+"']")).isDisplayed();
		Assert.assertEquals(verifyApprovedOrder, true);
	}
}
