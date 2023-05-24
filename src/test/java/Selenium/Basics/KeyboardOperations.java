package Selenium.Basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardOperations {
	
	WebDriver driver = new ChromeDriver();
	public void KeyboardwithActions()
	{
		driver.navigate().to("https://www.facebook.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").perform();
		mouseaction.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		mouseaction.keyDown(Keys.SHIFT).keyDown(Keys.TAB).keyUp(Keys.SHIFT).keyUp(Keys.TAB).perform();
		mouseaction.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		
		mouseaction.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
		mouseaction.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
		
	}
	
	public void KeyboardwithRobot() throws AWTException
	{
		driver.navigate().to("https://www.facebook.com/");
		Actions mouseaction= new Actions(driver);
		mouseaction.moveToElement(driver.findElement(By.id("email"))).sendKeys("sathish").doubleClick().contextClick().perform();
		Robot keyboard = new Robot();
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_DOWN);
		keyboard.keyRelease(KeyEvent.VK_DOWN);
		keyboard.keyPress(KeyEvent.VK_ENTER);
		keyboard.keyRelease(KeyEvent.VK_ENTER);
		keyboard.keyPress(KeyEvent.VK_TAB);
		keyboard.keyRelease(KeyEvent.VK_TAB);
		keyboard.keyPress(KeyEvent.VK_CONTROL);
		keyboard.keyPress(KeyEvent.VK_V);
		keyboard.keyRelease(KeyEvent.VK_CONTROL);
		keyboard.keyRelease(KeyEvent.VK_V);
			
	}

	public static void main(String[] args) throws AWTException {
		// TODO Auto-generated method stub
		KeyboardOperations k = new KeyboardOperations();
		k.KeyboardwithRobot();

	}

}
