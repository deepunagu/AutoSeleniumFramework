package vTiger.GeneralUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage27_02;
import vTiger.ObjectRepository.LoginPage_24_02;

/**
 * This class consists of Basic configuration annotations of TestNG
 */
	
public class BaseClass {

public	ProertyFileUtility pUtil =new ProertyFileUtility();
	/*import vTiger.GeneralUtilities.ProertyFileUtility;*/
public ExcelFileUtility eUtil=new ExcelFileUtility();
public	WebDriverUtility wUtil= new WebDriverUtility();
public	JavaUtility jUtil=new JavaUtility();
public static WebDriver sDriver;//listeners
	
public WebDriver driver;
	
	@BeforeSuite(groups ={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("-------------Database Connection successfull------");
	}
	
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups ={"SmokeSuite","RegressionSuite"})
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		//Step 1:REad the data from propertyfile
		String URL =pUtil.readDataFromPropertyFile("url");
		/*throws IOException  */
		String BROWSER= pUtil.readDataFromPropertyFile("browser");
		
		//Step 2:Launch the browser -Runtime polymorphism
		if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println("----"+BROWSER+"Launched succesfully-----");
		}
		else if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			System.out.println("----"+BROWSER+"Launched succesfully-----");
		}  else 
		{
			System.out.println("invalid Browser name");
		}
		
		sDriver=driver;//listeners
		wUtil.maximiseWindow(driver);
		wUtil.waitForPage(driver);
		driver.get(URL);
	}
	@BeforeMethod(groups ={"SmokeSuite","RegressionSuite"})
	public void bmConfig() throws IOException
	{
		String USERNAME= pUtil.readDataFromPropertyFile("username");
		String PASSWORD= pUtil.readDataFromPropertyFile("password");
		
		LoginPage_24_02 lp=new LoginPage_24_02(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("----- Login successful -----");
	
	}
	@AfterMethod(groups ={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage27_02 hp=new HomePage27_02(driver);
		hp.logoutApp(driver);
		System.out.println("----- Login successful -----");
	}
	
	@AfterClass(groups ={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("----- Browser Closed successfully -----");
	
	}
	@AfterSuite(groups ={"SmokeSuite","RegressionSuite"})
	public void asConfig()
	{
		System.out.println("-------------Database Connection successfull------");
	}	
}
