package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelRead {
	
	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\Sample.xls";
	
	public void ReadData() throws IOException
	{
		FileInputStream FI = new FileInputStream(filepath);
		//XSSFWorkbook workbook = new XSSFWorkbook(FI);
		HSSFWorkbook workbook = new HSSFWorkbook(FI);
		//Sheet excelsheet = workbook.getSheetAt(1);
		Sheet excelsheet = workbook.getSheet("Sheet1");
		//excelsheet.getLastRowNum();
		int usedRow = excelsheet.getPhysicalNumberOfRows();
		for(int i=0;i<usedRow;i++)
		{
			Row eachRow = excelsheet.getRow(i);
			int columnUsed = eachRow.getLastCellNum();
			for (int j=0;j<columnUsed;j++)
			{
				Cell eachCell =eachRow.getCell(j);
				if (eachCell.getCellType()== CellType.STRING)
				{
				System.out.print(eachCell.getStringCellValue());
				}
				else if (eachCell.getCellType()== CellType.NUMERIC)
				{
					DataFormatter dataFormatter = new DataFormatter();
					System.out.println(dataFormatter.formatCellValue(eachCell));
					//System.out.print(eachCell.getNumericCellValue());
				}
				System.out.print(" ");
			}
			System.out.println();
		}
		FI.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelRead E = new ExcelRead();
		E.ReadData();
	}

}
