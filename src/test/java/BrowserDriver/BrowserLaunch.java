package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import Utils.PropertyFileHandle;

public class BrowserLaunch {
	
	public static WebDriver driver;
	
	public void launch()
	{
		String browserName = PropertyFileHandle.propreaddata().getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			//options.addArguments("--incognito");
			driver= new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions();
			options.addArguments("start-maximized");
			options.addArguments("--disable-Notifications");
			options.addArguments("--incognito");
			driver= new EdgeDriver(options);
		}
		else
		{
			System.out.println("Please provide the valid Browser name");
		}
	}

}
