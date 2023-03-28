package vTigerOrganization.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GeneralUtilities.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage27_02;
import vTiger.ObjectRepository.HomePage27_02;
import vTiger.ObjectRepository.OrganizationsInfoPage27_02;
import vTiger.ObjectRepository.OrganizationsPage27_02;
@Listeners(vTiger.GeneralUtilities.ListnersImplimentaion.class)
public class CreateOrganizationwithBaseClasTest extends BaseClass {
@Test(groups ="SmokeSuite")
public void createOrganizationTest() throws EncryptedDocumentException, IOException {
	String ORGNAME =eUtil.readDataFromExcel("Organizations",1,2)+jUtil.getRandomNumber();
	
	//Step1:click on Organizations link
	HomePage27_02 hp=new HomePage27_02(driver);
	hp.clickOnOrganizationsLnk();
	
	//Step2:click on Create Organizations look up image
	OrganizationsPage27_02 op=new OrganizationsPage27_02(driver);
	op.clickOnCreateOrgImg();
	
	//Step3:Create Oraganization with mandatory details 
	CreateNewOrganizationPage27_02 cnop =new CreateNewOrganizationPage27_02(driver);
	cnop.createOraganization(ORGNAME);
	
	//Step 4: Validate
	OrganizationsInfoPage27_02 oip =new OrganizationsInfoPage27_02(driver);
	String OrgHeader =oip.getOrgHeader();
	Assert.assertTrue(OrgHeader.contains(ORGNAME));
}
@Test(groups="RegressionSuite")
public void demoScript()
{
	System.out.println("Demo");
}
@Test
public void regional() {
	System.out.println("regional regression");
}
}
