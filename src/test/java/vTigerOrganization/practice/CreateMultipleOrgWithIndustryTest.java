package vTigerOrganization.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vTiger.GeneralUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage27_02;
import vTiger.ObjectRepository.HomePage27_02;
import vTiger.ObjectRepository.OrganizationsInfoPage27_02;
import vTiger.ObjectRepository.OrganizationsPage27_02;

public class CreateMultipleOrgWithIndustryTest extends BaseClass {

	@Test(dataProvider="getData")
	public void createMultipleOrgWithIndustryTest(String Org, String INDUSTRY) {
		
String ORGNAME = Org+jUtil.getRandomNumber();
		
		HomePage27_02 hp = new HomePage27_02(driver);
		hp.clickOnOrganizationsLnk();
		
		OrganizationsPage27_02 op = new OrganizationsPage27_02(driver);
		op.clickOnCreateOrgImg();
		
		CreateNewOrganizationPage27_02 cnop = new CreateNewOrganizationPage27_02(driver);
		cnop.createOraganization(ORGNAME, INDUSTRY);
		
		OrganizationsInfoPage27_02 oip = new OrganizationsInfoPage27_02(driver);
		String OrgHeader = oip.getOrgHeader();
		Assert.assertTrue(OrgHeader.contains(ORGNAME));	
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		
		Object[][] data =eUtil.readMultipleData("Multiple");
		return data;
		
	}
}
