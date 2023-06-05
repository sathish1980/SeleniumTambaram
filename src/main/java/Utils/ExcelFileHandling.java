package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelFileHandling {
	static Object s;
	String filepath=System.getProperty("user.dir")+"\\Input\\";

	public Object[][]  ExcelReaddata(String Filename , String Sheetname) throws IOException
	{
		Object[][] excelreadarray = null;
		File F= new File(filepath+Filename);
		FileInputStream fs = new FileInputStream(F);
		//(.xlsx)
		
		//XSSFWorkbook wbk= new XSSFWorkbook(fs);
		//or (.xls)
		HSSFWorkbook hsf = new HSSFWorkbook(fs);
		
		Sheet sh=hsf.getSheet(Sheetname);
		//Sheet sh=wbk.getSheetAt(1);
		
		//int totalusedrows=sh.getLastRowNum();
		int totalusedrows=sh.getPhysicalNumberOfRows();
		int usedcolu=sh.getRow(0).getLastCellNum();
		//define the maximimun size of the array
		excelreadarray= new  Object[totalusedrows][usedcolu];
		for(int i=0;i<totalusedrows;i++)
		{
			
			Row rw= sh.getRow(i);
			int usedcolumn=rw.getLastCellNum();
			for(int j=0;j<usedcolumn;j++)
			{
				Cell value=rw.getCell(j);
				System.out.println(value);
				//readdataassuch(value);
				//excelreadarray[i][j] =value.toString();
				excelreadarray[i][j] =readdataassuch(value);
			}
			
		}
		hsf.close();
		fs.close();
		return excelreadarray;
	}
	
	public static Object readdataassuch(Cell cellvalue)
	{
		if(cellvalue.getCellType().equals(CellType.STRING))
		{
			s= cellvalue.getStringCellValue();
		}
		else if(cellvalue.getCellType().equals(CellType.NUMERIC)) 
		{
			DataFormatter dataFormatter = new DataFormatter();
			s = dataFormatter.formatCellValue(cellvalue);
		}
		
		return s;
	}
}
