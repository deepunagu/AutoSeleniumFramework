package practice;

import java.io.IOException;

import vTiger.GeneralUtilities.ExcelFileUtility;
import vTiger.GeneralUtilities.JavaUtility;
import vTiger.GeneralUtilities.ProertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		ProertyFileUtility pUtil=new ProertyFileUtility();
		String URL = pUtil.readDataFromPropertyFile("url");
		System.out.println(URL);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
	String value = eUtil.readDataFromExcel("Contact", 4, 2);
	System.out.println(value);
	//import vTiger.GeneralUtilities.ExcelFileUtility;
	
		System.out.println(eUtil.getRowCount("Contact"));
		eUtil.writeDataIntoExcel("Contact", 4, 6,"batman");
		
		JavaUtility jutil=new JavaUtility();//import vTiger.GeneralUtilities.JavaUtility;
		System.out.println(jutil.getSystemDate());
	
	}

}
