package vTiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//Step 1:open the document in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step 2:Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step 3:Get control of Sheet
	Sheet sh = wb.getSheet("Contact");
		
		//Step 4:Get control of Row
		Row rw = sh.getRow(1);
		
		//Step 5:Get control of cell
		Cell ce = rw.getCell(2);
		
		//Step 6:read the data inside the cell
	String value = ce.getStringCellValue();
	System.out.println(value);
		
	}

}
