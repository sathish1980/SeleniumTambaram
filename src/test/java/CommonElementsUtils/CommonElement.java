package CommonElementsUtils;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonElement {
	
	public void WaitForElementToBeVisible(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.visibilityOfElementLocated(WaitForElement));
	}
	
	public void WaitForElementToBeClickable(WebDriver driver, By WaitForElement, int secondsToWait)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(secondsToWait));
		wait.until(ExpectedConditions.elementToBeClickable(WaitForElement));
	}
	
	public void SelectTheValueFromList(WebDriver driver, By AllListelement,String expectedloaction)
	{
		List<WebElement> AllValues = driver.findElements(AllListelement);
		for (WebElement eachElement : AllValues )
		{
			String actualFromLocation = eachElement.findElement(By.cssSelector("div[class*='makeFlex']>div[class*='pushRight']")).getText();
			if(expectedloaction.equalsIgnoreCase(actualFromLocation))
			{
				eachElement.click();
				break;
			}
		}
	}

}
