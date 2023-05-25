package Selenium.Basics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationandValidations {

	WebDriver driver;
	public void VVimplemetation() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/dashboard.xhtml");
		driver.findElement(By.xpath("//*[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//*[@id='menuform:m_checkbox']")).click();
		
		//validation
		Boolean elementDispalyed = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']")).isDisplayed();
		System.out.println(elementDispalyed);
		Boolean elementEnabled = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//div[2]")).isEnabled();
		System.out.println(elementEnabled);
		
		// Verification command
		String title = driver.getTitle();
		System.out.println(title);
		String elementclass = driver.findElement(By.xpath("//*[@id='j_idt87:j_idt102']//div[2]")).getAttribute("class");
		System.out.println(elementclass);
		if (elementclass.contains("disabled"))
		{
			System.out.println("yes its disabled");
		}
		String currenturl = driver.getCurrentUrl();
		System.out.println(currenturl);
		String dom =driver.getPageSource();
		System.out.println(dom);
		String firstHeading = driver.findElement(By.xpath("(//*[@id='j_idt87']//h5)[1]")).getText();
		System.out.println(firstHeading);
		List<WebElement> firstHeadings = driver.findElements(By.xpath("//*[@id='j_idt87']//h5"));
		for (WebElement eachweb : firstHeadings)
		{
			System.out.println(eachweb.getText());
		}
		String currentWindowNAme = driver.getWindowHandle();
		System.out.println(currentWindowNAme);
		Set<String> allWindowNAme = driver.getWindowHandles();
		System.out.println(allWindowNAme);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VerificationandValidations V = new VerificationandValidations();
		V.VVimplemetation();
	}

}
