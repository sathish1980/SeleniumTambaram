package TestCase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.*;

import BrowserDriver.BrowserLaunch;
import Utils.PropertyFileHandle;


public class FacebookLoginandLogout extends BrowserLaunch {
	
	
	@BeforeSuite
	public void PreStep()
	{
		launch();
	}

	@BeforeTest
	public void MaxixmizeandEnterUrl()
	{
		driver.manage().window().maximize();
		String url = PropertyFileHandle.propreaddata().getProperty("url");
		driver.get(url);	
	}
	
	//@Test
	public void FacebookLogin1()
	{
		driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Admin@123");
		driver.findElement(By.name("login")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Sathish Ramakrishnan']")));
		String actualText = driver.findElement(By.xpath("//*[text()='Sathish Ramakrishnan']")).getText();
		Assert.assertEquals(actualText, "Sathish Ramakrishnan");
	}
	
	@Test
		public void FacebookLogin()
		{
		FacebookLogin FL = new FacebookLogin(driver);
		FL.EnterUserName();
		FL.EnterPassword();
		FL.ClickLoginButton();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Sathish Ramakrishnan']")));
			String actualText = driver.findElement(By.xpath("//*[text()='Sathish Ramakrishnan']")).getText();
			Assert.assertEquals(actualText, "Sathish Ramakrishnan");
		}
	
	@AfterSuite
	public void Teardown()
	{
		driver.quit();
	}
}
