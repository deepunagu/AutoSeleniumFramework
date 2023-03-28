package vTigerContactTestscript.practice;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GeneralUtilities.ExcelFileUtility;
import vTiger.GeneralUtilities.JavaUtility;
import vTiger.GeneralUtilities.ProertyFileUtility;
import vTiger.GeneralUtilities.WebDriverUtility;
import vTiger.ObjectRepository.ContactsInfoPage27_02;
import vTiger.ObjectRepository.ContactsPage27_02;
import vTiger.ObjectRepository.CreateNewContactPage27_02;
import vTiger.ObjectRepository.CreateNewOrganizationPage27_02;
import vTiger.ObjectRepository.HomePage27_02;
import vTiger.ObjectRepository.LoginPage_24_02;
import vTiger.ObjectRepository.OrganizationsInfoPage27_02;
import vTiger.ObjectRepository.OrganizationsPage27_02;

public class CreateContactWithOrganizationWithPomClass27_02 {
	public static void main(String[] args) throws IOException {
	// Step 1: Create Object for all utilities
			ProertyFileUtility pUtil =new ProertyFileUtility();
			/*import vTiger.GeneralUtilities.ProertyFileUtility;*/
			ExcelFileUtility eUtil=new ExcelFileUtility();
			/*Tiger.GeneralUtilities.ExcelFileUtility;*/
			WebDriverUtility wUtil=new WebDriverUtility();
			/*import vTiger.GeneralUtilities.WebDriverUtility;*/
			JavaUtility jUtil=new JavaUtility();
			/*import vTiger.GeneralUtilities.JavaUtility;*/
			
			// Step 2: Read all the necessary Data
			/* Read data from property File - Common Data */
			String URL =pUtil.readDataFromPropertyFile("url");
			/*throws IOException  */
			String BROWSER= pUtil.readDataFromPropertyFile("browser");
			String USERNAME= pUtil.readDataFromPropertyFile("username");
			String PASSWORD= pUtil.readDataFromPropertyFile("password");
			
			/* Read data from excel sheet - Test data */
			String ORGNAME = eUtil.readDataFromExcel("Contact", 4, 2) + jUtil.getRandomNumber();
			String LASTNAME = eUtil.readDataFromExcel("Contact", 4, 3);

			WebDriver driver = null;

			// Step 2: Launch the browser - runtime polymorphism
			if (BROWSER.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (BROWSER.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				System.out.println("Invalid Browser name");
			}
			
					wUtil.maximiseWindow(driver);
					wUtil.waitForPage(driver);
					driver.get(URL);

					// Step 4: Login to App
					LoginPage_24_02 lp=new LoginPage_24_02(driver);
					lp.loginToApp(USERNAME, PASSWORD);
			
					// Step 5: Click on Organizations link
					HomePage27_02 hp=new HomePage27_02(driver);
					hp.clickOnOrganizationsLnk();
					
					// Step 6: Click on Create Organization look up image
					OrganizationsPage27_02 op = new OrganizationsPage27_02(driver);
					op.clickOnCreateOrgImg();
					
					// Step 7: Create Organization with mandatory details
					CreateNewOrganizationPage27_02 cnop = new CreateNewOrganizationPage27_02(driver);
					cnop.createOraganization(ORGNAME);

					// Step 8: Validate for Organization
					
					OrganizationsInfoPage27_02 oip = new OrganizationsInfoPage27_02(driver);
					String orgHeader = oip.getOrgHeader();
					
					if (orgHeader.contains(ORGNAME)) {
						System.out.println(orgHeader + "Organizationm created");
					} else {
						System.out.println("Organization not created");
					}
					
					// Step 9: Navigate to contacts Link
					hp.clickOnContactsLnk();
					// Step 11:Click on create contact look up image 
					ContactsPage27_02 cp = new ContactsPage27_02(driver);
					cp.clickOnCreateContactImg();
					
					// Step 12: Create contact with mandatory fields and save
					CreateNewContactPage27_02 cncp = new CreateNewContactPage27_02(driver);
					cncp.createNewContact(driver, LASTNAME, ORGNAME);
					
					// Step 16: Validate for Contacts
					ContactsInfoPage27_02 cip = new ContactsInfoPage27_02(driver);
					String ContactHeader = cip.getConatctHeader();
				
					if(ContactHeader.contains(LASTNAME))
					{
						System.out.println(ContactHeader+" --- PASS ---");
					}
					else
					{
						System.out.println("-- FAIL --");
					}
					
					//Step 17: Logout of Application
					hp.logoutApp(driver);
					System.out.println("Sign out successfull");
		
}
	}
