package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage27_02 {
	//declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOrgLookUpImg;
	/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
	
	//initialization
	public OrganizationsPage27_02(WebDriver driver)
	{
		PageFactory.initElements( driver,this);
	}//import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.PageFactory;

	//Utilization add the getters method
	public WebElement getCreateOrgLookUpImg() {
		return CreateOrgLookUpImg;
	}
	
	//Business libraries
	/**
	 * This method will perform click operation create org look up img 
	 */
	
	public void clickOnCreateOrgImg() {
		CreateOrgLookUpImg.click();
	}	
}
