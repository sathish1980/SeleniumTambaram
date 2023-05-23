package Selenium.Basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActions {
	
	WebDriver driver = new ChromeDriver();
	public void MouseActionsimplementation()
	{
		
		driver.get("https://www.ebay.com/");
		Actions mouse = new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("(//*[@id='mainContent']//a[text()='Electronics'])[1]"))).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//*[@id='mainContent']//a[text()='Cameras and photos'])[1]"))));
		mouse.moveToElement(driver.findElement(By.xpath("(//*[@id='mainContent']//a[text()='Cameras and photos'])[1]"))).click().perform();
		
		
	}
	
	public void DraganadDrop()
	{
		driver.manage().window().maximize();
		driver.navigate().to("https://leafground.com/drag.xhtml");
		Actions mouseaction= new Actions(driver);
		mouseaction.dragAndDrop(driver.findElement(By.xpath("//*[@id='form:drag_content']")), driver.findElement(By.xpath("//*[@id='form:drop_content']"))).perform();
	}
	
	public void othermouseactions()
	{
		// WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.facebook.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
	}
	
	public void Slider()
	{
		driver.navigate().to("https://leafground.com/drag.xhtml");
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement startbutton=driver.findElement(By.xpath("//*[text()='Start']//parent::button"));
		js.executeScript("arguments[0].scrollIntoView();", startbutton);
		Actions mouse= new Actions(driver);
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[1]")), -40, 0).perform();
		mouse.moveToElement(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]"))).dragAndDropBy(driver.findElement(By.xpath("//*[@id='form:j_idt125']//span[2]")), 80, 0).perform();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MouseActions M = new MouseActions();
		// M.MouseActionsimplementation();
		// M.DraganadDrop();
		// M.othermouseactions();
		M.Slider();
	}

}
