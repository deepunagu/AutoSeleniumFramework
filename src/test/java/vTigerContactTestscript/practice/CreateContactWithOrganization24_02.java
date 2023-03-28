package vTigerContactTestscript.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GeneralUtilities.ExcelFileUtility;
import vTiger.GeneralUtilities.JavaUtility;
import vTiger.GeneralUtilities.ProertyFileUtility;
import vTiger.GeneralUtilities.WebDriverUtility;

public class CreateContactWithOrganization24_02 {

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
		
		String ORGNAME=eUtil.readDataFromExcel("Contact", 4, 2)+jUtil.getRandomNumber();
		String LASTNAME=eUtil.readDataFromExcel("Contact", 4, 3);
		
		WebDriver driver=null;
		/*import org.openqa.selenium.WebDriver;*/
		
		//Step 3:Launch the browser -Runtime polymorphism
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				} else 
				{
					System.out.println("invalid Browser name");
				}
		
				wUtil.maximiseWindow(driver);
				wUtil.waitForPage(driver);
				driver.get(URL);

				// Step 4: Login to App
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				/*import org.openqa.selenium.By;*/
		
				// Step 5: Click on Organizations link
				driver.findElement(By.linkText("Organizations")).click();
				
				// Step 6: Click on Create Organization look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				// Step 7: Create Organization with mandatory details
				driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
				// Step 8: save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				// Step 9: Validate for Organization
				String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				/* local variable for orgHeader is String*/
				if(orgHeader.contains(ORGNAME)) {
					System.out.println(orgHeader + "Organization created");
				}else
				{
					System.out.println( "Organization not created");
				}
				
				// Step 10: Navigate to contacts Link
				driver.findElement(By.linkText("Contacts")).click();
				// Step 11:Click on create contact look up image
				driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
				
				// Step 12: Create contact with mandatory fields and save
				driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
				
				// Step 13: Click on Organizatiion look up image
				driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
				
				//Step 14: Switch the window handle to Child
				wUtil.switchToWindow(driver, "Accounts");
				//Step 15: Search for Org name
				driver.findElement(By.name("search_text")).sendKeys(ORGNAME);
				driver.findElement(By.name("search")).click();
				/*driver.findElement(By.linkText(ORGNAME)).click();* OR use below*/
				driver.findElement(By.xpath("//a[text()='"+ORGNAME+"']")).click();
				//Step 16: Switch the control back to parent and save
				wUtil.switchToWindow(driver, "Contacts");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				// Step 17: Validate for Contacts
			String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			/* local variable for ContactHeader is String*/
			if(contactHeader.contains(LASTNAME)) {
				System.out.println(contactHeader + "Contact created");
			}else
			{
				System.out.println( "Contact not created");
			}
			
			//Step 18: Logout of Application
			WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wUtil.mouseHoverAction(driver, element);
	driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Sign out successfull");
	
	}

}
