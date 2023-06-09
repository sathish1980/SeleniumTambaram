package TestCase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.LogStatus;

import BrowserDriver.BrowserLaunch;
import BrowserDriver.Browserdriver;
import CommonElementsUtils.CommonLogics;
import Pages.SearchPage;
import Pages.SerachResultFlightSelectionPage;
import Utils.ExcelFileHandling;
import Utils.PropertyFileHandle;

public class MakemyTripFlightSearch extends Browserdriver {
	
	String currentUrl =null;
	CommonLogics c = new CommonLogics();
	
/*@BeforeSuite
public void launchTheBrowser()
{
	launch();
	
}

@BeforeTest()
public void EnterTheURL()
{
	currentUrl = PropertyFileHandle.propreaddata().getProperty("url");
	// driver.get(currentUrl);
	getdriver().get(currentUrl);
	test.log(LogStatus.INFO, "The following url is enterd : "+currentUrl);
}*/

@BeforeClass
public void deleteAdds() throws InterruptedException
{
	Thread.sleep(5000);
	CommonLogics c = new CommonLogics();
	//c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickIfElementExist(getdriver(),"//*[@class='close']");
	
	test.log(LogStatus.INFO, "The first popup window closed sucessfully");

	//c.ClickOnAddClose(driver);
	c.ClickOnAddClose(getdriver());
	test.log(LogStatus.INFO, "The second popup window closed sucessfully");
}

@Test(priority=0,dataProvider="SearchData",dataProviderClass=DataProviderImplementations.class)
public void EnterValidSearchCriteria(String fromcity, String toCity, String Date)
{
	//SearchPage sp = new SearchPage(driver);
	SearchPage sp = new SearchPage(getdriver());
	sp.SelectFromAndToValue(fromcity,toCity);
	test.log(LogStatus.INFO, "The "+fromcity +" as from city and "+toCity+" as to city is selected sucessfully");
	sp.SelectFlyFromDate(Date);
	test.log(LogStatus.INFO, "The "+Date+ " is the given date is selected");
	
	sp.ClickonSearchButton();
	test.log(LogStatus.INFO, "Search button is clicked suecssfully");
	
	//SerachResultFlightSelectionPage SRP = new SerachResultFlightSelectionPage(driver);
	SerachResultFlightSelectionPage SRP = new SerachResultFlightSelectionPage(getdriver());
	
	SRP.ClickOnPopupOkGotIt();
	test.log(LogStatus.INFO, "ok Got it popup is clicked suecssfully");
	
	
	SRP.GetTextOfFlightFrom();
	//String validateScreenShot= c.takescreenshot(driver);
	
	String validateScreenShot= c.takescreenshot(getdriver());
	test.log(LogStatus.INFO, "Search Text is validated sucessfully");
	
	Assert.assertEquals(sp.ValidateTextForAssertion(), "Flights from "+sp.FromCityName+" to "+sp.ToCityName);
	test.log(LogStatus.PASS, "All the Steps are executed sucessfully", test.addScreenCapture(validateScreenShot));
	
	//driver.navigate().back();
	getdriver().navigate().back();
	//Flights from Pune to Chennai
}

@AfterMethod
public void BaseUrl() throws InterruptedException
{
	//driver.get(currentUrl);
	getdriver().get(Urlvalue);
	Thread.sleep(5000);
	// c = new CommonLogics();
	//c.ClickIfElementExist(driver,"//*[@class='close']");
	c.ClickIfElementExist(getdriver(),"//*[@class='close']");
	
	// c.ClickOnAddClose(driver);

}

@Test(priority=1)
public void EnterSameFromandToInSearchCriteria()
{
	//SearchPage sp = new SearchPage(driver);
	
	SearchPage sp = new SearchPage(getdriver());
	
	sp.SelectFromAndToValue("MAA","MAA");
	//String validateScreenShot= c.takescreenshot(driver);
	
	String validateScreenShot= c.takescreenshot(getdriver());
	
	Assert.assertEquals(sp.GetSameCityError(), "From & To airports cannot be the same");
	test.log(LogStatus.PASS, "Same From and To is validated sucessfully", test.addScreenCapture(validateScreenShot));
	
	//Flights from Pune to Chennai
}


@AfterSuite
public void teatdown()
{
	report.flush();
	//driver.quit();
	getdriver().quit();
}


}
