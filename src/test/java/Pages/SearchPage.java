package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;

public class SearchPage extends CommonElement {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SelectFromAndToValue()
	{
		driver.findElement(By.xpath("//*[@for='fromCity']")).click();
		WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),"PNQ");
		driver.findElement(By.xpath("//*[@for='toCity']")).click();
		
		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),"MAA");

	}
	

}
