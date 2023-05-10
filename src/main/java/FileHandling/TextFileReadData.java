package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileReadData {
	
	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\Sample.txt";
	
	public void TextfileReadonechar() throws IOException
	{
		//File F = new File(filepath);
		//FileInputStream FI = new FileInputStream(F);
		FileInputStream FI = new FileInputStream(filepath);
		System.out.println((char)FI.read());
		
	}
	
	public void TextfileReadallchar() throws IOException
	{
		File F = new File(filepath);
		FileInputStream FI = new FileInputStream(F);
		int i;
		while((i= FI.read())!=-1)
		{
			System.out.print((char)i);
		}
		
	}
	
	public void TextfileReadallbyFileReader() throws IOException, InterruptedException
	{
		File F = new File(filepath);
		FileReader FI = new FileReader(F);
		int i;
		while((i= FI.read())!=-1)
		{
			System.out.print((char)i);
			Thread.sleep(500);
		}
		
	}
	
	public void TextfileReaddataLineByLine() throws IOException, InterruptedException
	{
		File F = new File(filepath);
		FileReader FI = new FileReader(F);
		BufferedReader Bf = new BufferedReader(FI);
		String i;
		while((i= Bf.readLine())!=null)
		{
			System.out.println(i);
			Thread.sleep(1000);
		}
		
	}

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		TextFileReadData T = new TextFileReadData();
		T.TextfileReadallbyFileReader();
	}

}
