package vTiger.GeneralUtilities;

import java.util.Date;
import java.util.Random;

/**
 * This class conatins all the generic methods related To Java
 * @author USER
 *
 */
public class JavaUtility {
/**
 * This method will provide the system date
 * @return
 */
public String getSystemDate()
{
	Date d =new Date();//import java.sql.Date;
	return d.toString();
}
	/**
	 * This method will provide the system date in specific format
	 * @return
	 */
public	String getSystemDateInFormat()
{
	Date d =new Date();
	String date[] = d.toString().split("");
	String month = date[1];
	String date1 = date[2];
	String time = date[3];
	String year = date[4];
	
	String finalDate = date1+" "+month+" "+year+" "+time;
	return finalDate;
	
}
/**
 * This method will return a random number for every run
 * @return
 */
	
	public int getRandomNumber() {
		Random r =new Random();//import java.util.Random;
		return r.nextInt(1000);
	}
		
	
}
