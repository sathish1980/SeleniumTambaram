package Selenium.Basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ListImplementation {
	
	public void listconcept(String expdctedCountry)
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://leafground.com/select.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.findElement(By.xpath("//div[@id='j_idt87:country']//div[contains(@class,'ui-selectonemenu-trigger')]")).click();
		
		List<WebElement> country =driver.findElements(By.xpath("//*[@id='j_idt87:country_items']//li"));
		
		for (WebElement eachValue : country)
		{
			String eachCountry = eachValue.getText();
			if(expdctedCountry.equalsIgnoreCase(eachCountry))
			{
				eachValue.click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListImplementation L = new ListImplementation();
		L.listconcept("Germany");
	}

}
