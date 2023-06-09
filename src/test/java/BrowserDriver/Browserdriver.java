package BrowserDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utils.PropertyFileHandle;

public class Browserdriver 
{

	PropertyFileHandle  p= new PropertyFileHandle();
	//public static WebDriver driver;
	public  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	String projectpath=System.getProperty("user.dir");
	public String Urlvalue;
	public static ExtentReports report;
	public static ExtentTest test;
	static String reportpath= System.getProperty("user.dir")+"\\Reports\\";
	
	public void setdriver(WebDriver driver)
	{
		this.driver.set(driver);
	}
	
	public WebDriver getdriver()
	{
		return this.driver.get();
	}
	
	
	public void launchBrowser(String browsername)
	{
		//String browsername=p.propreaddata().getProperty("Browser");
		Urlvalue=p.propreaddata().getProperty("url");
		if(browsername.equalsIgnoreCase("chrome"))
		{	
			ChromeOptions c= new ChromeOptions();
			c.addArguments("--disable-notifications");
			c.addArguments("start-maximized");
			//System.setProperty("webdriver.chrome.driver",projectpath+"\\Browserdriver\\Chromedriver\\chromedriver.exe");
			//driver=new ChromeDriver(C);
			setdriver(new ChromeDriver(c));
		}
		else if (browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions E= new EdgeOptions();
			E.addArguments("--disable-notifications");
			//System.setProperty("webdriver.edge.driver",projectpath+"\\Browserdriver\\edgedriver_win64\\msedgedriver.exe");
			setdriver(new EdgeDriver(E));
		}
		extenterportstart();
	}
	
	public void extenterportstart()
	{
		report = new ExtentReports(reportpath+"extenreport.html",false);
		test= report.startTest("Extent report");	
	}
	
	public void extentreportclose()
	{
		report.flush();
		
	}
	
	@BeforeTest
	@Parameters("browser")
	public void Maximize(String browser)
	{
		launchBrowser(browser);
		//getdriver().manage().window().maximize();
		//driver.get("url")
		getdriver().get(Urlvalue);
		test.log(LogStatus.INFO, "The following url is enterd : "+Urlvalue);

	}
	
	@AfterTest
	public void Teardown()
	{
		
		getdriver().quit();
	}
	
	@BeforeSuite
	public void launch()
	{
		extenterportstart();
	}
	
	@AfterSuite
	public void teardonw()
	{
		extentreportclose();
		
	}
}
