package Selenium.Basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButtonandCheckbox {
	
	public void radiobutton(String textRadioButton)
	{
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/radio.xhtml");
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		List<WebElement> allvalue = driver.findElements(By.xpath("//*[@id='j_idt87:console1']//td"));
		System.out.println(allvalue.size());
		for(int i=1;i<=allvalue.size();i++)
		{
			String radioText= driver.findElement(By.xpath("(//*[@id='j_idt87:console1']//td["+i+"]//label)")).getText();
			System.out.println(radioText);
			if( radioText.equalsIgnoreCase(textRadioButton))
			{
				driver.findElement(By.xpath("//*[@id='j_idt87:console1']//td["+i+"]")).click();
				String className = driver.findElement(By.xpath("(//*[@id='j_idt87:console1']//td["+i+"]//div//div[2])")).getAttribute("class");
				if (className.contains("ui-state-active"))
					System.out.println("This is clicked");
				break;
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadioButtonandCheckbox RB = new RadioButtonandCheckbox();
		RB.radiobutton("Edge");
	}

}
