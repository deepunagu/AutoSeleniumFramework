package vTiger.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFilePractice {

	public static void main(String[] args) throws IOException {
		
		//Step 1:open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2:Create object of properties from java.util package
		Properties pobj=new Properties();
		
		//Step 3:load the file input stream into properties
		pobj.load(fis);
		
		//Step 4:Access the values with keys
		 String URL = pobj.getProperty("url");
		String PASSWORD = pobj.getProperty("password");

		System.out.println(URL);
		System.out.println(PASSWORD);
}
}