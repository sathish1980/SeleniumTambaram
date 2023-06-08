package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utils.PropertyFileHandle;

public class BrowserLaunch {
	
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	private String reportpath=System.getProperty("user.dir");
	
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
		
		report = new ExtentReports(reportpath+"//Reports//extentreport.html",true);
		test= report.startTest("Makemytrip Automation report");	

	}

}
