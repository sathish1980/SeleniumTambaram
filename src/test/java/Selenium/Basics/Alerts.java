package Selenium.Basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
	
	WebDriver driver = new ChromeDriver();
	public void alertsimplementation() throws InterruptedException
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']")).click();
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt104']")).click();
		Alert al = driver.switchTo().alert();
		al.sendKeys("Besant Technology");
		String text = al.getText();
		String actualText = "Type your name and click OK";
		System.out.println(text);
		al.accept();
		
		
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Alerts A = new Alerts();
		A.alertsimplementation();
	}

}
