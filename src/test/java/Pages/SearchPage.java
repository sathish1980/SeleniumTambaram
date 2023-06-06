package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonElementsUtils.CommonElement;

public class SearchPage extends CommonElement {
	
	WebDriver driver;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SelectFromAndToValue(String fromValue,String toValue)
	{
		WebElement fromButton = driver.findElement(By.xpath("//*[@for='fromCity']"));
		ClickOnButton(fromButton);
		WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),fromValue);
		WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		ClickOnButton(toButton);
		SelectTheValueFromList(driver, By.xpath("//ul[@role='listbox']//li"),toValue);
		
	}
	
	public void SelectFlyFromDate(String datatoFly)
	{
		SelectValueinCalender(driver,datatoFly);
	}

}
