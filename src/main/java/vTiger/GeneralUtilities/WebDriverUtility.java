package vTiger.GeneralUtilities;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class consists of generic methods related to webdriver actions
 * @author USER
 *
 */
public class WebDriverUtility {
/**
 * 	This method will maximise the window
 * @param driver
 */
	
	public void maximiseWindow(WebDriver driver)//import org.openqa.selenium.WebDriver;
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimise the window
	 * @param driver
	 */
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for the page load
	 * @param driver
	 */
public void waitForPage(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
}
/**
 * This method will wait untill elements becomes visible
 * @param driver
 * @param element
 */
public void waitForElememtTobeVisible(WebDriver driver, WebElement element)
//import org.openqa.selenium.WebElement;
{
	WebDriverWait wait =new WebDriverWait( driver,Duration.ofSeconds(10));//import org.openqa.selenium.support.ui.WebDriverWait;
wait.until(ExpectedConditions.visibilityOf(element));

}
/**
 * This method will wait untill element becomes clickable
 * @param driver
 * @param element
 */
public void waitForElementToBeClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait =new WebDriverWait( driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
/**
 * This method will handle the drop down based on index
 * @param element
 * @param index
 */
public void handleDropdown(WebElement element,int index)
{
	Select sel=new Select(element);//import org.openqa.selenium.support.ui.Select;
			sel.selectByIndex(index);
}
/**
 * This method will handle the drop down based on value
 * @param element
 * @param value
 */
public void handleDropdown(WebElement element,String value)
{
	Select sel=new Select(element);
	sel.selectByValue(value);
}
/**
 * This method will handle the drop down based on visible text
 * @param text
 * @param element
 */
public void handleDropdown(String text,WebElement element)
{
	Select sel=new Select(element);
	sel.selectByVisibleText(text);
}
/**
 * This method will perform mouse hover action
 * @param driver
 * @param element
 */
public void mouseHoverAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);//import org.openqa.selenium.interactions.Actions;
act.moveToElement(element).perform();
}
/**
 * This method perform right click  anywhere in web page
 * @param driver
 */
public void rightClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.contextClick().perform();
}
/**
 * This method perform right click on web element
 * @param driver
 * @param element
 */
public void rightClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.contextClick(element).perform();
}
/**
 * This method perform double click on anywhere on web page
 * @param driver
 */
public void doubleClickAction(WebDriver driver)
{
	Actions act = new Actions(driver);
	act.doubleClick().perform();
}
/**
 *This method perform double click on  web page elrment
 * @param driver
 * @param element
 */
public void doubleClickAction(WebDriver driver,WebElement element)
{
	Actions act = new Actions(driver);
	act.doubleClick(element).perform();
}
/**
 * This  method will perform drag and drop action
 * @param driver
 * @param srcelement
 * @param dstElement
 */
public void dragAndDropAction(WebDriver driver,WebElement srcelement,WebElement dstElement)
{
	Actions act = new Actions(driver);
	act.dragAndDrop(srcelement, dstElement).perform();
}
/**
 * This method will aceept the alert
 * @param driver
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
}
/**
 * This method will dismiss the alert
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
/**
 * This method will capture the text from Alert popup
 * @param driver
 * @return
 */
public String getAlertText(WebDriver driver)
{
	return driver.switchTo().alert().getText();
}
/**
 * This method will handle frame based on index
 * @param driver
 * @param index
 */
public void handleFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}
/**
 * This method will handle frame based on name or ID
 * @param driver
 * @param nameOrId
 */
public void handleFrame(WebDriver driver, String nameOrId)
{
	driver.switchTo().frame(nameOrId);
}
/**
 * This method will handle frame based on web element
 * @param driver
 * @param element
 */
public void handleFrame(WebDriver driver, WebElement element)
{
	driver.switchTo().frame(element);
}
/**
 * This method will switch to immediate parent frame
 * @param driver
 */
public void switchToParentFrame(WebDriver driver)
{
	driver.switchTo().parentFrame();
}
/**
 * This method will switch to default frame
 * @param driver
 */
public void switchToDefaultFrame(WebDriver driver)
{
	driver.switchTo().defaultContent();
}
/**
 * This method will switch the window based on partial window title.
 * @param driver
 * @param partialWinTitle
 */

public void switchToWindow(WebDriver driver, String partialWinTitle)
{
	//Step 1: Capture all the Window IDs
	Set<String> winIDs = driver.getWindowHandles();
	
	//Step 2: Navigate to each window 
	for(String win:winIDs)
	{
		//Step 3: switch to window and capture the title
		String winTitle=driver.switchTo().window(win).getTitle();
		//Step 4: compare the title with required partial title
		if(winTitle.contains(partialWinTitle))
		{
			break;
		}
	}
}
/**
 * this method will take screen shot and save it in folder
 * @param driver
 * @param screenshotName
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver,String screenshotName) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot) driver;//import org.openqa.selenium.TakesScreenshot;
	File src = ts.getScreenshotAs(OutputType.FILE);//
	File dst=new File(".\\ScreenShot\\"+screenshotName+".png");
	FileUtils.copyFile(src, dst);//throws IOException
	return dst.getAbsolutePath();//used for extent Reports....
	
}
/**
 * This method will perform random scroll downwards vertically
 * @param driver
 */
public void scrollAction(WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor) driver;//import org.openqa.selenium.JavascriptExecutor;
	js.executeScript("window.scrollBy(0,500)", "");
}
/**
 * This method will scroll until the element is identified in DOM
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver,WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",element);
}

}
 
