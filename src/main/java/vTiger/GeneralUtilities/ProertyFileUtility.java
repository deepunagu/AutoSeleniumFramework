package vTiger.GeneralUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class consists og Generic methods to read data from property file
 * @author Deepika N
 * 
 * 
 */
public class ProertyFileUtility {
/**
 * This method read data from Property file
 * @param key
 * @return
 * @throws IOException
 */

	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;		
	}	
}
