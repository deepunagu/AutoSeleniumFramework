package vTigerOrganization.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationWithDDT {

	public static void main(String[] args) throws IOException {
		
		Random r=new Random();
	int random = r.nextInt(100);
		
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
			  String ORGNAME = wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue()+random;
				
				WebDriver driver = null;
				
				//Step 2:Launchthe browser -Runtime polymorphism
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					driver=new ChromeDriver();
				} else if (BROWSER.equalsIgnoreCase("firefox"))
				{
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
		
		//Step 4: Click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 5: Click on create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//step 6: create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		
		//step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8:Validate
		String orgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgHeader.contains(ORGNAME))
		{
			System.out.println(orgHeader);
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
		System.out.println("Sign Out Successfilly");
	}

}
