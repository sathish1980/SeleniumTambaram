package FileHandling;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandling {
	
	String filepath = "C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Input\\environment.properties";
	
	public void Propertyfilereadandwrite() throws IOException
	{
		FileInputStream FI = new FileInputStream(filepath);
		Properties p = new Properties();
		p.load(FI);
		String actualName = p.getProperty("name");
		System.out.println(actualName);
		System.out.println(p.getProperty("Age"));
		System.out.println(p.getProperty("edu"));
		p.setProperty("passedout", "2010");
		System.out.println(p.getProperty("passedout"));
		System.out.println(Integer.parseInt(p.getProperty("age"))+Integer.parseInt(p.getProperty("age1")));
		FI.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileHandling p = new PropertyFileHandling();
		p.Propertyfilereadandwrite();
	}

}
