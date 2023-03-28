package vTiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class OraganizationTestScriptDropDown {

	public static void main(String[] args) {
		//Step:1 Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step:2 Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step:3 Click on Organization link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step:4 Click on create Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step:5 create Organization with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("KannadaNad"); 
		
		//step:6 Select "Chemicals" in the industry drop down
		WebElement dropdown = driver.findElement(By.name("industry"));
		
		Select s=new Select(dropdown);
		s.selectByVisibleText("Chemicals");
		
		//step:7 Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 8:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("KannadaNad"))
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
	}
}
