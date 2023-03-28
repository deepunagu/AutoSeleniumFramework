package vTiger.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ContactTestScript1_07D_02M {

	public static void main(String[] args) {
		
		//Step:1 Launch the browser
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888");
		
		//Step:2 Login to Application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//Step:3 Click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		//Step:4 Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//step:5 create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Deepika");
		
		//step:6 Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//Step 7:Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains("Deepika"))
		{
			System.out.println(contactHeader);
			System.out.println("PASS");	
		}
		else
		{
			System.out.println("FAIL");
		}
		//Step 8:Logout of Application
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.linkText("Sign Out")).click();

	}

}
