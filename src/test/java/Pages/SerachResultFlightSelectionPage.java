package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CommonElementsUtils.CommonElement;

public class SerachResultFlightSelectionPage extends CommonElement {

	WebDriver driver;
	
	public SerachResultFlightSelectionPage(WebDriver driver)
	{
		this.driver=driver;
	}

	
	public void ClickOnPopupOkGotIt()
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[text()='OKAY, GOT IT!']"),60);
		clickOnButton(driver.findElement(By.xpath("//*[text()='OKAY, GOT IT!']")));
	}
	
	public void GetTextOfFlightFrom()
	{
		String text =GetTextOfelement(driver.findElement(By.xpath("//*[contains(@class,'journey-title')]")));
		System.out.println(text);
	}
}
