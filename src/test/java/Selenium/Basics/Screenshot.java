package Selenium.Basics;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {
	
	WebDriver driver;
	public void screenshotcapture()
	{
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\driverfiles\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		JavascriptExecutor js= (JavascriptExecutor)driver;
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		screen("homepage.png");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		screen("scrolldown.png");
		
	}
	
	public void screen(String filename)
	{
		TakesScreenshot tc = (TakesScreenshot)driver;
		File screenshot = tc.getScreenshotAs(OutputType.FILE);
		File DestinationFile = new File("C:\\Users\\sathishkumar\\eclipse-workspace\\SeleniumTambaram\\Screenshot\\"+filename);
		try {
			FileUtils.copyFile(screenshot, DestinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Screenshot s = new Screenshot();
		s.screenshotcapture();
	}

}
