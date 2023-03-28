package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsInfoPage27_02 {
	//declaration
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement OrgHeaderText;
/*import org.openqa.selenium.support.FindBy;import org.openqa.selenium.WebElement; */
//initialization
public OrganizationsInfoPage27_02(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
//utiliztion and add getters method
public WebElement getOrgHeaderText() {
	return OrgHeaderText;
}

//Bussiness library
/**
 * This method will capture the text from orgHeader and return it to caller
 * @return
 */
public String getOrgHeader() {
	return OrgHeaderText.getText();
}

}








