package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonElementsUtils.CommonElement;

public class SearchPage extends CommonElement 
{
	
	WebDriver driver;
	@FindBy (xpath="//*[@for='fromCity']")
	WebElement fromButton;
	//@FindBy (xpath="//*[@for='fromCity']")
	//By fromButtonByClass;
	//@FindBy (xpath="(//ul[@role='listbox']//li)[1]")
	//By fromListFirstValue;
	//@FindBy (xpath="//ul[@role='listbox']//li")
	//By fromListValue;
	@FindBy (xpath="//*[@for='toCity']")
	WebElement toButton;
	@FindBy (xpath="//input[@id='fromCity']")
	WebElement fromCity;
	@FindBy (xpath="//input[@id='toCity']")
	WebElement toCity;
	@FindBy (xpath="//*[@data-cy='submit']//a")
	WebElement submitButton;
	@FindBy (xpath="//*[@data-cy='sameCityError']")
	WebElement sameError;
	
	
	private String fromButtonByClass = "//*[@for='fromCity']";
	private String fromListFirstValue = "(//ul[@role='listbox']//li)[1]";
	private String fromListValue="//ul[@role='listbox']//li";
	public String FromCityName =null;
	public String ToCityName =null;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SelectFromAndToValue(String fromValue,String toValue)
	{
		//WaitForElementToBeClickable(driver,By.xpath("//*[@for='fromCity']"),60);
		WaitForElementToBeClickable(driver,By.xpath(fromButtonByClass),60);
		
		//WaitForElementToBeClickable(driver,fromButtonByClass,60);
		//WebElement fromButton = driver.findElement(By.xpath("//*[@for='fromCity']"));
		ClickOnButton(fromButton);
		//WaitForElementToBeVisible(driver,By.xpath("(//ul[@role='listbox']//li)[1]"),60);
		WaitForElementToBeVisible(driver,By.xpath(fromListFirstValue),60);
		SelectTheValueFromList(driver, By.xpath(fromListValue),fromValue);
		//WebElement toButton = driver.findElement(By.xpath("//*[@for='toCity']"));
		ClickOnButton(toButton);
		SelectTheValueFromList(driver, By.xpath(fromListValue),toValue);
		
	}
	
	public void SelectFlyFromDate(String datatoFly)
	{
		SelectValueinCalender(driver,datatoFly);
	}
	
	public void GetTextofFromLocation()
	{
		//FromCityName=GetTextOfelement(driver.findElement(By.xpath("//input[@id='fromCity']")));
		FromCityName=GetTextOfelement(fromCity);
	}
	
	public void GetTextofToLocation()
	{
		//ToCityName=GetTextOfelement(driver.findElement(By.xpath("//input[@id='toCity']")));
		ToCityName=GetTextOfelement(toCity);

	}
	
	public void ClickonSearchButton()
	{
		//clickOnButton(driver.findElement(By.xpath("//*[@data-cy='submit']//a")));
		clickOnButton(submitButton);
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
		
		//return GetTextOfelement(driver.findElement(By.xpath("//*[@data-cy='sameCityError']")));
		return GetTextOfelement(sameError);
	}

}
