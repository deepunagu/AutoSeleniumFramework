package vTigerContactTestscript.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactWithDDT {

	public static void main(String[] args) throws IOException {
		
	//Step 1:Read all the necessary data
		/*Read data from Property file -Common Data */
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fisp);
		String URL = pobj.getProperty("url");
		String BROWSER = pobj.getProperty("browser");//chrome,firefox,edge
		 String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		/* Read data from excel shee- Teast dta*/ 
		FileInputStream fise =new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	    Workbook wb = WorkbookFactory.create(fise);
	  String LASTNAME = wb.getSheet("Contact").getRow(1).getCell(2).getStringCellValue();
		
		WebDriver driver = null;
		
		//Step 2:Launchthe browser -Runtime polymorphism
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
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		//Step:3 Login to Application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Step:4 Click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step:5 Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step:6 create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		
		//step:7 Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("PASS");	
		}
		else
		{
			System.out.println("FAIL");
		}
		//Step 9:Logout of Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("signout successfull");
	}


	}


