package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GeneralUtilities.WebDriverUtility;

public class CreateNewOrganizationPage27_02 extends WebDriverUtility {
	//declaration
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
	
	@FindBy(name="industry")
	private WebElement IndustryDropown;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	//initialization
	public CreateNewOrganizationPage27_02(WebDriver driver) {
		PageFactory.initElements(driver,this);//import org.openqa.selenium.WebDriver;
	}
	//Utilization add the getters method
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}

	public WebElement getIndustryDropown() {
		return IndustryDropown;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	//Business libraries
	/**
	 * This method will create Orgnization with OrgName
	 * @param OrgName
	 */
	
	public void createOraganization(String OrgName) {
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 * This method will create with Org name or Industry type
	 * @param OrgName
	 * @param IndustryType
	 */
	public void createOraganization(String OrgName, String IndustryType) {
		OrgNameEdt.sendKeys(OrgName);
	handleDropdown(IndustryDropown,IndustryType );
		SaveBtn.click();
	}	
	
}
