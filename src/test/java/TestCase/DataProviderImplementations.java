package TestCase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Utils.ExcelFileHandling;

public class DataProviderImplementations {
	
	@DataProvider(name ="SearchData")
	public Object[][] SearchPageTestData() throws IOException
	{
		ExcelFileHandling E = new ExcelFileHandling();
		return E.ExcelReaddata("MakrmyTripSearch.xls","input");
	}
}
