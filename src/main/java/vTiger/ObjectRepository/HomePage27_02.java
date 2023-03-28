package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GeneralUtilities.WebDriverUtility;

public class HomePage27_02 extends WebDriverUtility{
	//import org.openqa.selenium.WebDriver;
//declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
	 
	@FindBy(linkText="Contacts")
	private WebElement ContactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement  AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	//initialization
	public HomePage27_02(WebDriver driver)//import org.openqa.selenium.WebDriver;
	{
	PageFactory.initElements(driver, this);	
	}
	//Utilization add the getters method
	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

	public WebElement getContactsLnk() {
		return ContactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return OpportunitiesLnk;
	}

	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}

	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	
	//Business libraries
	/**
	 * This method will perform click operation on Organizations Link
	 */
	
	public void clickOnOrganizationsLnk() {
		OrganizationsLnk.click();
	}
	/*
	 * This method will perform click operation on Contacts Link
	 */
	public void clickOnContactsLnk() {
		ContactsLnk.click();
	}
	/*
	 * This method will perform click operation on Opportunities Link
	 */
	
	public void clickOnOpportunitiesLnk() {
		OpportunitiesLnk.click();
	}
	/**
	 * This method will perform  logout operation 
	 * @param driver
	 */
	
	public void logoutApp(WebDriver driver) {
		mouseHoverAction(driver,AdministratorImg);
		SignOutLnk.click();
	}
}
