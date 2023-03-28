package vTiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step 1:open the document in java readable format
				FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
				
				//Step 2:Create a workbook
				Workbook wb = WorkbookFactory.create(fis);
				
				//Step 3:Get control of Sheet
			Sheet sh = wb.getSheet("Contact");
				
				//Step 4:Get control of Row
				Row rw = sh.getRow(4);
				
				//Step 5:Create a cell in that row
				Cell ce = rw.createCell(8);
				
				//Step 6:Set the value to  the cell
				ce.setCellValue("wasa");
				
				//Step 7:Open the Document to the write mode
				FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
			
				//Step 8:Write the Data
				wb.write(fos);
				
		System.out.println("data to be added");
		
	}

}
