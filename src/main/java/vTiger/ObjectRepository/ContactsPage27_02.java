package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage27_02 {

	//declaration
		@FindBy(xpath="//img[@alt='Create Contact...']")
		private WebElement CreateContactLookUpImg;
		/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
		
		//initialization
		public ContactsPage27_02(WebDriver driver)
		{
			PageFactory.initElements( driver,this);
		}//import org.openqa.selenium.WebDriver;import org.openqa.selenium.support.PageFactory;

		//Utilization add the getters method
		public WebElement getCreateContactLookUpImg() {
			return CreateContactLookUpImg;
		}

		//Business library
		/**
		 * This method will perform click operation on create contact lookup img
		 */
		public void clickOnCreateContactImg()
		{
			CreateContactLookUpImg.click();
		}
}
