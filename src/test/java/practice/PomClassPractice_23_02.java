package practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.LoginPage_24_02;

public class PomClassPractice_23_02 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//import io.github.bonigarcia.wdm.WebDriverManager;
		WebDriver driver= new ChromeDriver();
		//import org.openqa.selenium.WebDriver;
		//import org.openqa.selenium.chrome.ChromeDriver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://localhost:8888");
		
		LoginPage_24_02 lp= new LoginPage_24_02(driver);
		//import vTiger.ObjectRepository.LoginPage_24_02;
		lp.getUsernameEdt().sendKeys("admin");
		lp.getPasswordEdt().sendKeys("admin");
		lp.getSubmitBtn().click();
		
		/*or 
		 * lp.loginToApp("admin","admin")
		 */
		
	}

}
