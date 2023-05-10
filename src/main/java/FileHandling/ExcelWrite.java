package FileHandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {
	
	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\ouput.xlsx";
	
	String[] name = {"sathish","Kumar","R"};
	public void WriteData() throws IOException
	{
		FileOutputStream FO = new FileOutputStream(filepath);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		Sheet outsheet = workbook.createSheet("OutputSheet");
		int arraySize = name.length;
		for(int i=0;i<arraySize;i++)
		{
			Row eachRow = outsheet.createRow(i);
			Cell eachcolumn = eachRow.createCell(0);
			eachcolumn.setCellValue(name[i]);
		}
		
		/*int arraySize = name.length;
		for(int i=0;i<arraySize;i++)
		{
			Cell eachcolumn = eachRow.createCell(i);
			eachcolumn.setCellValue(name[i]);
		}*/
		
		//Cell eachcolumn2 = eachRow.createCell(1);
		
		
		
		workbook.write(FO);
		System.out.println("Write operation is Done");
		FO.close();
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelWrite EW = new ExcelWrite();
		EW.WriteData();
	}

}
