package Selenium.Basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	WebDriver driver;
	public void frameconcpet() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[contains(@style,'#ff7295')]")).click();
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		int size = totalFrames.size();
		System.out.println(size);
		for (int i=0;i<size;i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> Button = driver.findElements(By.xpath("//button[contains(@style,'#ff7295')]"));
			int buttonSize = Button.size();
			if(buttonSize >0)
			{
				driver.findElement(By.xpath("//button[contains(@style,'#ff7295')]")).click();
				driver.switchTo().defaultContent();
				break;
				
			}
			driver.switchTo().defaultContent();
		}
	}
	
	public void multilpeframeconcpet() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[contains(@style,'#ff7295')]")).click();
		
		List<WebElement> totalFrames = driver.findElements(By.tagName("iframe"));
		int size = totalFrames.size();
		System.out.println(size);
		for (int i=0;i<size;i++)
		{
			driver.switchTo().frame(i);
			List<WebElement> totalinnerFrames = driver.findElements(By.tagName("iframe"));
			int innerFramesize = totalinnerFrames.size();
			System.out.println("total innerFrame: "+innerFramesize);
			if(innerFramesize>0)
			{
			
				driver.switchTo().frame("frame2");
				List<WebElement> Button = driver.findElements(By.xpath("//button[contains(@style,'#4b7ecf')]"));
				int buttonSize = Button.size();
				if(buttonSize >0)
				{
					driver.findElement(By.xpath("//button[contains(@style,'#4b7ecf')]")).click();
					driver.switchTo().defaultContent();
					break;
					
				}
			driver.switchTo().defaultContent();
			}
			driver.switchTo().defaultContent();
		}
		driver.switchTo().defaultContent();
	}


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Frames F = new Frames();
		F.multilpeframeconcpet();
	}

}
