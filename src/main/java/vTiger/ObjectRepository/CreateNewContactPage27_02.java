package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GeneralUtilities.WebDriverUtility;

public class CreateNewContactPage27_02 extends WebDriverUtility{

	//declaration
		@FindBy(name="lastname")
		private WebElement LastNameEdt;
		/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
		
		@FindBy(xpath="//input[@name='account_id']/following-sibling::img[@alt='Select']")
		private WebElement OrgLookUpImg;
		
		@FindBy(name="search_text")
		private WebElement searchEdt;
		
		@FindBy(name="search")
		private WebElement searchBtn;
		
		//initialization
		public CreateNewContactPage27_02(WebDriver driver) {
			PageFactory.initElements(driver,this);//import org.openqa.selenium.WebDriver;
		}
		//Utilization add the getters method
		public WebElement getLastNameEdt() {
			return LastNameEdt;
		}

		public WebElement getSaveBtn() {
			return SaveBtn;
		}

		public WebElement getOrgLookUpImg() {
			return OrgLookUpImg;
		}

		public WebElement getSearchEdt() {
			return searchEdt;
		}

		public WebElement getSearchBtn() {
			return searchBtn;
		}
	//Businees libraries
		/**
		 * This method will create new contact with lastname
		 * @param LastName
		 */
	public void	createNewContact(String LastName) {
		LastNameEdt.sendKeys(LastName);
		SaveBtn.click();
	}
		/**
		 * This method will create contact with Oraganization
		 * @param driver
		 * @param LastName
		 * @param OrgName
		 */
		public void createNewContact(WebDriver driver,String LastName, String OrgName) {
			LastNameEdt.sendKeys(LastName);
			OrgLookUpImg.click();
			switchToWindow(driver, "Accounts");
			// we need to extends WebDriverUtility,import vTiger.GeneralUtilities.WebDriverUtility;
			searchEdt.sendKeys(OrgName);
			searchBtn.click();
			driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
			switchToWindow(driver, "Contacts");
			SaveBtn.click();
			
		}
}
