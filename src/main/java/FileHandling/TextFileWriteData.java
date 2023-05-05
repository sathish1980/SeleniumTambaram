package FileHandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class TextFileWriteData {
	
	String output = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Output\\outputnew.txt";
	
	public void TextFileWriteonechar() throws IOException
	{
		String name ="sathish kumar .R";
		File F = new File(output);
		FileOutputStream FI = new FileOutputStream(F);
		byte[] value= name.getBytes();
		//FI.write(65);
		FI.write(value);
		FI.close();
		System.out.println("Done");
		//FI.write(name.getBytes());
		
	}
	
	public void TextFileWritewithFileWriter() throws IOException
	{
		String name ="sathish kumar .R this is file reader";
		File F = new File(output);
		FileWriter FI = new FileWriter(F);
		//byte[] value= name.getBytes();
		//FI.write(65);
		FI.write(name);
		FI.close();
		System.out.println("Done");
		//FI.write(name.getBytes());
		
	}
	
	
	public void ReadandWriteTogehter() throws IOException
	{
		String inputfilepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\Sample.txt";
		
		File F = new File(inputfilepath);
		FileReader FI = new FileReader(F);
		File Fl = new File(output);
		FileWriter FW = new FileWriter(Fl);
		BufferedReader Bf = new BufferedReader(FI);
		String i;
		while((i= Bf.readLine())!=null)
		{
			FW.write(i);
		}

		
		//byte[] value= name.getBytes();
		//FI.write(65);
		
		FW.close();
		System.out.println("Done");
		//FI.write(name.getBytes());
		
	}
	
	public void copyfile()
	{
		String inputfilepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\Sample.txt";
		
		
		File f= new File(inputfilepath);
		File fout= new File(output);
		try {
			FileUtils.copyFile(f, fout);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("done");
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		TextFileWriteData T = new TextFileWriteData();
		//T.ReadandWriteTogehter();
		T.copyfile();
	}

}
