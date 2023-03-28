package vTigerContactTestscript.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;


import vTiger.GeneralUtilities.BaseClass;
import vTiger.ObjectRepository.ContactsInfoPage27_02;
import vTiger.ObjectRepository.ContactsPage27_02;
import vTiger.ObjectRepository.CreateNewContactPage27_02;
import vTiger.ObjectRepository.CreateNewOrganizationPage27_02;
import vTiger.ObjectRepository.HomePage27_02;
import vTiger.ObjectRepository.OrganizationsInfoPage27_02;
import vTiger.ObjectRepository.OrganizationsPage27_02;

public class CreateContWithOrgwithBasClasAssertTest extends BaseClass {

	@Test(groups="RegressionSuite")//import org.testng.annotations.Test;
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException {
		
/* Read data from excel sheet - Test data */
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 3);
/*throws EncryptedDocumentException, IOException*/
		
		// step 1:click on Crete Organization link
		HomePage27_02 hp=new HomePage27_02(driver);
		hp.clickOnOrganizationsLnk();
		
		//Step 2: Click on Create Organization look up image
		OrganizationsPage27_02 op=new OrganizationsPage27_02(driver);
		op.clickOnCreateOrgImg();
		
		// Step 3: Create Organization with mandatory details
		CreateNewOrganizationPage27_02 cnop= new CreateNewOrganizationPage27_02(driver);
		cnop.createOraganization(ORGNAME);
		
		// Step 4: Validate for Organization
		OrganizationsInfoPage27_02 oip = new OrganizationsInfoPage27_02(driver);
		String orgHeader = oip.getOrgHeader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader+" --- Organization created");
		
		// Step 5: Navigate to contacts Link
		hp.clickOnContactsLnk();
		
		// Step 6:Click on create contact look up image
		ContactsPage27_02 cp=new ContactsPage27_02(driver);
		cp.clickOnCreateContactImg();
		
		// Step 7: Create contact with mandatory fields and save
		CreateNewContactPage27_02 cncp= new CreateNewContactPage27_02(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		// Step 8: Validate for Contacts
		ContactsInfoPage27_02 cip=new ContactsInfoPage27_02(driver);
		String ContactHeader = cip.getConatctHeader();
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader+" --- Contact created ");	
		
	}
	
}
