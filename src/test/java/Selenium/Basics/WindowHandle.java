package Selenium.Basics;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {
	
	WebDriver driver;
	public void windowshandlingimplementation()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml");
		String parent= driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='j_idt88:new']")).click();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String eachWindowName : allWindows)
		{
			if (!parent.equals(eachWindowName))
			{
				driver.switchTo().window(eachWindowName);
				List<WebElement> elementexist=driver.findElements(By.xpath("//*[@id='menuform:j_idt40']"));
				if (elementexist.size()>0)
				{
					WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
					wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='menuform:j_idt40']")));
					
				driver.findElement(By.xpath("//*[@id='menuform:j_idt40']")).click();
				driver.findElement(By.xpath("//*[text()='Check Box']//parent::a")).click();
				wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")));
				driver.findElement(By.xpath("//*[@id='j_idt87:j_idt89']//*[contains(@class,'ui-chkbox-box')]")).click();
				// driver.switchTo().window(parent);
				driver.quit();
				break;
				}
				else
				{
					driver.switchTo().window(parent);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WindowHandle W = new WindowHandle();
		W.windowshandlingimplementation();
	}

}
