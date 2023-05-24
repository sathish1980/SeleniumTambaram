package Selenium.Basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollOperations {
	
	WebDriver driver;
	public void scrollimplementation() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		Thread.sleep(1000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//vertical scroll down
		js.executeScript("window.scrollBy(0,750)", "");
		Thread.sleep(1000);
		//vertical scroll up
		js.executeScript("window.scrollBy(0,-250)", "");
		// Horizontal Right
		js.executeScript("window.scrollBy(250,0)", "");
		Thread.sleep(1000);
		//Horizontal scroll Left
		js.executeScript("window.scrollBy(-250,0)", "");
		
		//Verticaly down
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//Verticaly up
		js.executeScript("window.scrollTo(0,0)");
		Thread.sleep(2000);
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
	
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ScrollOperations s = new ScrollOperations();
		s.scrollimplementation();

	}

}
