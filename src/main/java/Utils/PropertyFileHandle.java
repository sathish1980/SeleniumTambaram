package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileHandle {

	public static 	Properties ps;
	static String filename = System.getProperty("user.dir")+"//Environment//EnvironmentData.properties";
	public static Properties propreaddata()
	{
		File fs = new File(filename);
		try {
			FileInputStream filestream= new FileInputStream(fs);
			ps= new Properties();
			try {
				ps.load(filestream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
