package CommonElementsUtils;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonLogics extends CommonElement{

	public void ClickIfElementExist(WebDriver driver,String Elementpath) {
		List<WebElement>allframeelement = driver.findElements(By.tagName("iframe"));
		for(int i=0;i<allframeelement.size();i++)
		{
		driver.switchTo().frame(i);
		List<WebElement> AllElements = driver.findElements(By.xpath(Elementpath));
		if (AllElements.size() > 0) {
			for (WebElement eachElement : AllElements) {

				eachElement.click();
				driver.switchTo().defaultContent();
				break;
			}
		}
		else
		{
			driver.switchTo().defaultContent();
		}
		}
	}
	
	public void ClickOnAddClose(WebDriver driver)
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@class='ic_circularclose_grey']"),60);
		driver.findElement(By.xpath("//*[@class='ic_circularclose_grey']")).click();
	}
	
	public static String takescreenshot(WebDriver driver)
	{
		Date date = new Date();
	      //This method returns the time in millis
	    long timeMilli = date.getTime();
		String date_v= String.valueOf(timeMilli);
		//System.out.println(date_v);
		TakesScreenshot ts =(TakesScreenshot)driver;
		File sourcefile= ts.getScreenshotAs(OutputType.FILE);
		File Destinationfile= new File(System.getProperty("user.dir")+"//Screenshot//"+date_v+".png");
		try {
			FileUtils.copyFile(sourcefile, Destinationfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Destinationfile.toString();
	}
	
	
}
