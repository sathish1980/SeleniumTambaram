package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadandWrite {
	
	String readfilepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\Sample.xls";
	String writefilepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\ouput.xlsx";
	

	public void readandWrite() throws IOException
	{
		FileInputStream FI = new FileInputStream(readfilepath);
		HSSFWorkbook workbook = new HSSFWorkbook(FI);
		
		FileOutputStream FO = new FileOutputStream(writefilepath);
		
		XSSFWorkbook outworkbook = new XSSFWorkbook();
		
		Sheet excelsheet = workbook.getSheet("Sheet1");
		Sheet outexcelsheet = outworkbook.createSheet("outputwrite");
		int usedRow = excelsheet.getPhysicalNumberOfRows();
		for(int i=0;i<usedRow;i++)
		{
			Row eachRow = excelsheet.getRow(i);
			Row outeachRow = outexcelsheet.createRow(i);
			int columnUsed = eachRow.getLastCellNum();
			for (int j=0;j<columnUsed;j++)
			{
				Cell eachCell = eachRow.getCell(j);
				Cell outeachCell = outeachRow.createCell(j);
				if (eachCell.getCellType()== CellType.STRING)
				{
				System.out.print(eachCell.getStringCellValue());
				outeachCell.setCellValue(eachCell.getStringCellValue());
				}
				else if (eachCell.getCellType()== CellType.NUMERIC)
				{
					DataFormatter dataFormatter = new DataFormatter();
					System.out.println(dataFormatter.formatCellValue(eachCell));
					outeachCell.setCellValue(dataFormatter.formatCellValue(eachCell));
					//System.out.print(eachCell.getNumericCellValue());
				}
			}
			
		}
		System.out.println("Read and Write is Done");
		outworkbook.write(FO);
		FO.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelReadandWrite EX = new ExcelReadandWrite();
		EX.readandWrite();
	}

}
