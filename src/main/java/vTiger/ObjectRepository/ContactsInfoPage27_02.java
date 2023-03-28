package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInfoPage27_02 {
	//declaration
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContctHeaderText;
	/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
	//initialization
	public ContactsInfoPage27_02(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization and add getters method
	public WebElement getContctHeaderText() {
		return ContctHeaderText;
	}
	//Business library
	/**
	 * This method will capture the text from orgHeader and return it to caller
	 * @return
	 */
	public String getConatctHeader() {
		return ContctHeaderText.getText();
	}
	
	
}
