package TestCase;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import BrowserDriver.BrowserLaunch;
import CommonElementsUtils.CommonLogics;
import Pages.SearchPage;
import Utils.PropertyFileHandle;

public class MakemyTripFlightSearch extends BrowserLaunch {
	
	
@BeforeSuite
public void launchTheBrowser()
{
	launch();
	
}

@BeforeTest()
public void EnterTheURL()
{
	String currentUrl = PropertyFileHandle.propreaddata().getProperty("url");
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

@Test
public void EnterValidSearchCriteria()
{
	SearchPage sp = new SearchPage(driver);
	
	sp.SelectFromAndToValue();
}

}
