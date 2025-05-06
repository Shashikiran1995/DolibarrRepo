package com.ERP.Dollibarr.ThirdParty;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Dollibarr.BaseUtility.BaseClass;
import com.Dollibarr.generic.ObjectRepositoryUtility.NewThirdPartyPage;
import com.Dollibarr.generic.ObjectRepositoryUtility.ThirdPartyVerifyPage;

public class CreateThirdPartyTest extends BaseClass
{
	@Test(groups = "ST")
	public void createThirdPartyWithMandatoryField() throws EncryptedDocumentException, IOException
	{
		String thirdPartyName = elib.getDataFromExcel("thirdParty", 1, 1)+jlib.getRandomNumber();
		String prospectOrCustomer = elib.getDataFromExcel("thirdParty", 1, 2);
		String vendorOrNot = elib.getDataFromExcel("thirdParty", 1, 3);
		
		NewThirdPartyPage ntp=new NewThirdPartyPage(driver);
		ntp.createThirdParty(thirdPartyName, prospectOrCustomer, vendorOrNot);
		
		ThirdPartyVerifyPage tpv=new ThirdPartyVerifyPage(driver);
		String actThirdParty = tpv.getThirdPartyNameVerify().getText();
		boolean verify = actThirdParty.contains(thirdPartyName);
		Assert.assertEquals(verify, true);	
	}
}
