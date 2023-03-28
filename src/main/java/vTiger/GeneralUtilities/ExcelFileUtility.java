package vTiger.GeneralUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This clASS contains generic methods related to excel file
 * @author USER
 *
 */
public class ExcelFileUtility {
	/**
	 * This method will read data from excel sheet based on row and cell value
	 * @param sheet
	 * @param row
	 * @param cel
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int row,int cel) throws EncryptedDocumentException, IOException {
		FileInputStream fis =new FileInputStream(InterferConstantUtility.ExcelFilePath);	
		/*import java.io.FileInputStream; 
		 * throws FileNotFoundException (import java.io.FileNotFoundException;)		
		 */
				
	 Workbook wb = WorkbookFactory.create(fis);		
		/*	import org.apache.poi.ss.usermodel.WorkbookFactory;
		 * import org.apache.poi.EncryptedDocumentException;
		 *  throws EncryptedDocumentException
		 * Workbook is local variable fr wb	*/
				
			Sheet sh = wb.getSheet(sheet);	
			/*import org.apache.poi.ss.usermodel.Workbook;
			 * import org.apache.poi.ss.usermodel.Sheet;
			 * Sheet is local variable fr sh	*/
			
			Row rw = sh.getRow(row);
			/*	import org.apache.poi.ss.usermodel.Row;
			 * Row is local variable fr rw
			 */
			
		Cell ce = rw.getCell(cel);	
			/*import org.apache.poi.ss.usermodel.Cell;
			 * Cell is local variable fr ce
			 */
		String value = ce.getStringCellValue();
		return value;
	}
		/**
		 * this method will write data into excel sheet
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
			
		FileInputStream fis=new FileInputStream(InterferConstantUtility.ExcelFilePath);//FileNotFoundException
		Workbook wb = WorkbookFactory.create(fis);//throws EncryptedDocumentException,IOException,
		Sheet sh = wb.getSheet(sheet);
	   int rowCount = sh.getLastRowNum();
	   wb.close();
	   return rowCount;			
	}
/**
 * This method will write the data into the excel sheet
 * @param sheet
 * @param row
 * @param cel
 * @param value
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String sheet,int row,int cel,String value) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream(InterferConstantUtility.ExcelFilePath);// throws FileNotFoundException
 Workbook wb = WorkbookFactory.create(fis);//throws EncryptedDocumentException,workbook is local variable fr wb
	Row rw = wb.getSheet(sheet).getRow(row);//Row is local variable fr rw
	rw.createCell(cel).setCellValue(value);
	
	FileOutputStream fos=new FileOutputStream(InterferConstantUtility.ExcelFilePath); 
		//import java.io.FileOutputStream;
	wb.write(fos);
	System.out.println(value+"----> Data added");
	wb.close();
}
/**
 * This method will load the data from excel sheet to data provider
 * @param Sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public Object[][] readMultipleData(String Sheetname) throws EncryptedDocumentException, IOException {
	FileInputStream fis=new FileInputStream(InterferConstantUtility.ExcelFilePath);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(Sheetname);
	int lastRow=sh.getLastRowNum();
	int lastCel=sh.getRow(0).getLastCellNum();
	
	Object[][] data =new Object[lastRow][lastCel];
	
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;i<lastCel;j++) 
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return data;
}
	}


