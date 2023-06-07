package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import CommonElementsUtils.CommonElement;

public class SearchPage extends CommonElement {
	
	WebDriver driver;
	public String FromCityName =null;
	public String ToCityName =null;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void SelectFromAndToValue(String fromValue,String toValue)
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
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
	
	public void GetTextofFromLocation()
	{
		FromCityName=GetTextOfelement(driver.findElement(By.xpath("//input[@id='fromCity']")));
	}
	
	public void GetTextofToLocation()
	{
		ToCityName=GetTextOfelement(driver.findElement(By.xpath("//input[@id='toCity']")));
	}
	
	public void ClickonSearchButton()
	{
		clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
	}
	
	public String ValidateTextForAssertion()
	{
		String text1 =  "Flights from ";
		String text2 =  " to ";
		String ActualText = text1+FromCityName+text2+ToCityName;
		return ActualText;
	}
	
	public String GetSameCityError()
	{
		return GetTextOfelement(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
	}

}
