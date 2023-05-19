package Selenium.Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {
	
	
	public void dropdownimplemetation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//*[text()='Create new account']")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("firstname")));
		
		driver.findElement(By.name("firstname")).sendKeys("sathish");
		
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("firstname"))));
		
		driver.findElement(By.name("lastname")).sendKeys("sathish");
		
		Select daydropdown = new Select(driver.findElement(By.id("day")));
		daydropdown.selectByIndex(10);
		Thread.sleep(2000);
		daydropdown.selectByValue("14");
		Thread.sleep(2000);
		daydropdown.selectByVisibleText("21");
		
		Select monthdropdown = new Select(driver.findElement(By.id("month")));
		monthdropdown.selectByValue("10");
		
		Select yeardropdown = new Select(driver.findElement(By.id("year")));
		yeardropdown.selectByVisibleText("2017");
	}
	
	public void multiselect() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
		Select multidropdown= new Select(driver.findElement(By.xpath("//select[@id='second']")));
		System.out.println(multidropdown.isMultiple());
		//drodpwon.selectByIndex(4);
		if(multidropdown.isMultiple())
		{
			multidropdown.selectByIndex(1);
			multidropdown.selectByValue("bonda");
			multidropdown.selectByVisibleText("Pizza");
			Thread.sleep(1000);
			multidropdown.deselectByValue("pizza");
			Thread.sleep(1000);
			multidropdown.deselectByVisibleText("Donut");
			Thread.sleep(1000);
			multidropdown.deselectAll();

		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Dropdown d = new Dropdown();
		d.multiselect();

	}

}
