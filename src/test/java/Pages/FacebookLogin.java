package Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class FacebookLogin {
	
	WebDriver driver;
	
	public FacebookLogin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void EnterUserName()
	{
		driver.findElement(By.id("email")).sendKeys("kumar.sathish189@gmail.com");
		
	}
	
	public void EnterPassword()
	{
		driver.findElement(By.id("pass")).sendKeys("Admin@123");
		
	}
	
	public void ClickLoginButton()
	{
		driver.findElement(By.name("login")).click();
		
	}

}
