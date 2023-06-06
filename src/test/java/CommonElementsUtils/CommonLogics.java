package CommonElementsUtils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonLogics extends CommonElement{

	public void ClickIfElementExist(WebDriver driver,String Elementpath) {
		List<WebElement>allframeelement = driver.findElements(By.tagName("iframe"));
		for(int i=0;i<allframeelement.size();i++)
		{
		driver.switchTo().frame(i);
		List<WebElement> AllElements = driver.findElements(By.xpath(Elementpath));
		if (AllElements.size() > 0) {
			for (WebElement eachElement : AllElements) {

				eachElement.click();
				driver.switchTo().defaultContent();
				break;
			}
		}
		else
		{
			driver.switchTo().defaultContent();
		}
		}
	}
	
	public void ClickOnAddClose(WebDriver driver)
	{
		WaitForElementToBeClickable(driver,By.xpath("//*[@class='ic_circularclose_grey']"),60);
		driver.findElement(By.xpath("//*[@class='ic_circularclose_grey']")).click();
	}
	
	
}
