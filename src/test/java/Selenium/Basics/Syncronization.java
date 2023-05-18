package Selenium.Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Syncronization {
	
	public void launch() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("firstname"))));
		
		driver.findElement(By.name("lastname")).sendKeys("sathish");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Syncronization s = new Syncronization();
		s.launch();
	}

}
