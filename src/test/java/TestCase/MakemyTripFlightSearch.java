package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import BrowserDriver.BrowserLaunch;
import CommonElementsUtils.CommonLogics;
import Pages.SearchPage;
import Pages.SerachResultFlightSelectionPage;
import Utils.PropertyFileHandle;

public class MakemyTripFlightSearch extends BrowserLaunch {
	
	String currentUrl =null;
	
@BeforeSuite
public void launchTheBrowser()
{
	launch();
	
}

@BeforeTest()
public void EnterTheURL()
{
	currentUrl = PropertyFileHandle.propreaddata().getProperty("url");
	driver.get(currentUrl);
}

@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickOnAddClose(driver);
}

@Test(priority=0)
public void EnterValidSearchCriteria()
{
	SearchPage sp = new SearchPage(driver);
	
	sp.SelectFromAndToValue("BOM","MAA");
	sp.SelectFlyFromDate("20");
	sp.ClickonSearchButton();
	
	SerachResultFlightSelectionPage SRP = new SerachResultFlightSelectionPage(driver);
	SRP.ClickOnPopupOkGotIt();
	SRP.GetTextOfFlightFrom();
	Assert.assertEquals(sp.ValidateTextForAssertion(), "Flights from "+sp.FromCityName+" to "+sp.ToCityName);
	//Flights from Pune to Chennai
}

@AfterMethod
public void BaseUrl() throws InterruptedException
{
	driver.get(currentUrl);
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	c.ClickIfElementExist(driver,"//*[@class='close']");
	// c.ClickOnAddClose(driver);

}

@Test(priority=1)
public void EnterSameFromandToInSearchCriteria()
{
	SearchPage sp = new SearchPage(driver);
	
	sp.SelectFromAndToValue("MAA","MAA");
	
	Assert.assertEquals(sp.GetSameCityError(), "From & To airports cannot be the same");
	//Flights from Pune to Chennai
}

}
