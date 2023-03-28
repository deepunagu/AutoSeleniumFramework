package practice;

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
public class CreateMultipleOrgWithIndustryDataProviderTest extends BaseClass{
@Test(dataProvider="getData")//import org.testng.annotations.Test;
public void createMultipleOrgWithIndustryDataProviderTest(String Org, String INDUSTRY)
{
	String ORGNAME=Org+jUtil.getRandomNumber();
	// step 1:click on Crete Organization link
	HomePage27_02 hp=new HomePage27_02(driver);
	hp.clickOnOrganizationsLnk();
	//Step 2: Click on Create Organization look up image
	OrganizationsPage27_02 op=new OrganizationsPage27_02(driver);
	op.clickOnCreateOrgImg();
	
	// Step 3: Create Organization with mandatory detail
	CreateNewOrganizationPage27_02 cnop= new CreateNewOrganizationPage27_02(driver);
	cnop.createOraganization(ORGNAME,INDUSTRY);
	
	// Step 4: Validate for Organization
	OrganizationsInfoPage27_02 oip = new OrganizationsInfoPage27_02(driver);
	String orgHeader = oip.getOrgHeader();
	Assert.assertTrue(orgHeader.contains(ORGNAME));	//import org.testng.Assert;
}
@DataProvider//import org.testng.annotations.DataProvider;
public Object[][] getData() throws EncryptedDocumentException, IOException
{
	Object[][] data = eUtil.readMultipleData("Multiple");
	return data;
}	
}
